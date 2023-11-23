package yandexTest


/**
 *
 */
/*
3
1 2 3

ans: 3

2
2 3

ans: 3
 */
fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map{ it.toInt() }.toIntArray()

    var ans = 0
    val set = mutableSetOf<Int>()
    var i = 0

    for (j in 0 until n) {
        while (set.contains(a[j])) {
            set.remove(a[i])
            i++
        }
        set.add(a[j])
        ans += (i + 1) * (i + 2) / 2
    }

    println(ans)
}