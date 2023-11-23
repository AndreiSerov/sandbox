package yandexTest

/**
 * @author andreiserov
 */
fun findIndices(N: Int, A: IntArray, B: IntArray): Int {
    val prefixSumA = A.scan(0L) { acc, a -> acc + a }
    val prefixSumB = B.scan(0L) { acc, b -> acc + b }
    val sum = prefixSumA.last()
    val sumIndices = mutableMapOf<Long, Int>()
    for (i in prefixSumA.indices) {
        val diff = prefixSumA[i] - prefixSumB[i]
        val j = sumIndices[diff + sum]
        if (j != null && j >= i) {
            return j - i
        }
        sumIndices.putIfAbsent(diff + sum, i)
    }
    return -1
}

fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val b = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    println(findIndices(n, a, b))
}

/*
2
2 3
3 2

ответ 1


1
10
2

ответ -1
 */