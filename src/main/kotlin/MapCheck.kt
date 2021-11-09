import java.time.Instant


//data class Point(val x: Int)
//operator fun Point.hash(other: Point): Point = Point(x + other.x)

//class ABs {
//    lateinit var name: String
//
//}
//
//fun <T: Comparable<T>> sort(list: List<T>): List<T> {
//    return list.sorted()
//}
//
//val res = generateSequence(1) { it + 1 }.toList()
fun main() {
    val longTimeAgo = Instant.now()
    println(longTimeAgo)
    println(Instant.now().isAfter(longTimeAgo.plusMillis(86_400_000)))
//    val x = "asdasd"
//    val ka: Int = x?.length ?: -1
//
//    println(res)
//    val a = arrayOf(1, 2, 3)
//    val b = arrayOf(1, 2, 3)
//    val c = listOf(*a, *b)
//    println(c)
//    val map = HashMap<String, List<String>>()
//    map.put("GPB", listOf("asd"))
//    map.put("gpb", listOf("dsa"))
//
//    println(map.get("gpb"))
}