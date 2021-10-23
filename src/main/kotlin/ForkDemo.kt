
import java.util.concurrent.ForkJoinPool


fun main() {
    val commonPool = ForkJoinPool(3)

    commonPool.submit {
        Thread.sleep(1000)
        try {
            for(i in 500 downTo 0) {
                println("$commonPool: $i")
                Thread.sleep(1000)
            }
        }catch (e: InterruptedException ) {
            println("$commonPool Interrupted")
        }
        println("$commonPool exiting.")
    }.invoke()
}