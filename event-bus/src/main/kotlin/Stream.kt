import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.shareIn
import kotlin.reflect.KClass

class Stream(
    private val scope: CoroutineScope
) : EventBus {

    private val _eventFlow = MutableSharedFlow<Envelope>(
        extraBufferCapacity = 64
    )

    override suspend fun publish(topic: String, event: Event) {
        _eventFlow.emit(Envelope(topic, event))
    }

    override fun <T : Event> subscribe(topicPattern: String, eventType: KClass<T>): SharedFlow<T> {
        val regex = topicPatternToRegex(topicPattern)

        @Suppress("UNCHECKED_CAST")
        return _eventFlow
            .filter { envelope ->
                regex.matches(envelope.topic) && eventType.isInstance(envelope.event)
            }
            .map { it.event as T }
            .shareIn(
                scope = scope,
                started = SharingStarted.Lazily,
                replay = 0
            )
    }

    private fun topicPatternToRegex(pattern: String): Regex {
        val escaped = pattern
            .replace(".", "\\.")
            .replace("*", "[^.]+")
            .replace(">", ".*")
        return Regex("^$escaped$")
    }
}