import kotlin.Array

/**
 * @author andreiserov
 */

class chainSum(var res: Int) {
    operator fun chainSum.invoke(num: Int) = this.apply { res + num }
    override fun toString() = "chainSum(res=$res)"
}
operator fun Int.invoke(n: Int) = this + n

fun main() {
    var sum = chainSum(10)
    val asfd: Array<String> = arrayOf("kalia")

    asfd.contentHashCode()


}