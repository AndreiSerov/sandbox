class MyThread(threadName: String) : Runnable {
    private val name: String = threadName
    private val t: Thread = Thread(this, name)

    init {
        println("New thread: $t")
        t.start()
    }

    override fun run() {
        try {
            for(i in 50 downTo 0) {
                println("$name: $i")
                Thread.sleep(1000)
            }
        }catch (e: InterruptedException ) {
            println("$name Interrupted")
        }
        println("$name exiting.")
    }
}

fun main() {
    MyThread("One")
    MyThread("Two")
    MyThread("Three")
    try {
        Thread.sleep(10000)
    } catch (e: InterruptedException) {
        println("Main thread Interrupted")
    }
    println("Main thread exiting.")
}