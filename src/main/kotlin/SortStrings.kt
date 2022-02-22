fun main() {
    val list = listOf("C", "A", "B", "10", "11", "23")
    println(list
        .asSequence()
        .sortedBy { it }
        .joinToString(", "))
}