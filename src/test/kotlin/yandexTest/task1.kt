package yandexTest

/**
 * @author andreiserov
 */
fun main() {
    val (a, b, c) = readLine()!!.split(" ").map { it.toLong() }
    val sorted = listOf(a, b, c).sorted()
    val x = sorted[1]
    var cntGreater = 0
    var cntSmaller = 0
    for (score in listOf(a, b, c)) {
        if (score >= x) {
            cntGreater++
        }
        if (score <= x) {
            cntSmaller++
        }
    }
    println(if (cntGreater >= 2 && cntSmaller >= 2) x else sorted[2])
}