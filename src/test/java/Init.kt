/**
 * @author andreiserov
 */
data class InitData (
    val str: String,
    var str2: String
) {
    init {
        require(str.length == 1)
        require(str2.length == 1)
    }
}

fun main() {
    val initData = InitData("1", "1")
    initData.str2 = "1234"
}