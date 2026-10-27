package functions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException
import kotlin.time.Duration

inline fun <reified T>  scheduled(
    scope: CoroutineScope,
    delayTime: Duration,
    crossinline callback: suspend () -> T
) = scope.launch {
    while (isActive) {
        try {
            callback()
        } catch (e: CancellationException) {
            throw e
        }
        delay(delayTime)
    }
}