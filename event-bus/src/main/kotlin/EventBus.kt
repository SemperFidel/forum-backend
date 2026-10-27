import kotlinx.coroutines.flow.SharedFlow
import kotlin.reflect.KClass

interface EventBus {
    suspend fun publish(topic: String, event: Event)

    // Подписка по конкретному топику или шаблону (например, "order.*")
    fun <T : Event> subscribe(topicPattern: String, eventType: KClass<T>): SharedFlow<T>
}