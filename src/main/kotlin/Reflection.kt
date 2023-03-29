/**
 * @author andreiserov
 */
class Reflection(
    val kProperty1: String
) {

    fun String.toReflection() = Reflection(this)

    companion object{
        val prop: String = "ljashdf"
        
        fun kProperty0(str: String) {
            println("KProperty0 demo $str")
        }
    }
}


fun main() {
//    val kProperty1 = Reflection::kProperty000

    val pair = Pair(1, 2)

    val breakPoint = ""
}