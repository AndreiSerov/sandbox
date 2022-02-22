import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.time.Instant
import java.time.LocalDate
import java.util.concurrent.Executors


/**
 * @author andreiserov
 */

fun main() {

    println(generatePartitionKey())
    println(Instant.now().toEpochMilli())


    val threadPool = Executors.newFixedThreadPool(3)
    for (i in 0..3) {
        threadPool.submit { main2(i) }
    }
    threadPool.shutdown()

    println("main after blocking")
}
fun generatePartitionKey(): Int? {
    val date = LocalDate.now()
    return date.year * 12 + date.monthValue - 1
}

private fun main2(i: Int) {
    runBlocking {
        printWithDelay(i)
    }
}


suspend fun printWithDelay(i: Int) {
    for (i in 0..3) {
        withContext(Dispatchers.IO) {
            Thread.sleep(1000)
            println("printWithDelay in context $i")
        }
        println("printWithDelay out of context $i")
    }
    anothernestedCall(i)
}
suspend fun anothernestedCall(i: Int) {
    println("anothernestedCall before block operation $i")
    withContext(Dispatchers.IO) {
        Thread.sleep(1000)
        println("anothernestedCall in context $i")
    }
    println("anothernestedCall after block operation $i")
}
