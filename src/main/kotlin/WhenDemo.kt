/**
 * @author andreiserov
 */
data class Ext(val name: String, var value: String)

fun main() {
    val listOf = listOf(
        Ext("Currency", "kaliaBalia")
    )

    val formatToSmftRequest = listOf.formatToSmftRequest()

    println(formatToSmftRequest)

}

fun List<Ext>.formatToSmftRequest(): List<Ext> = this
    .asSequence()
    .map {
        with (it.name.lowercase()) {
            when {
                contains("currency") -> it.apply { value = "currency $value" }
                contains("amount") -> it.apply { value = "amount $value" }
                else -> it
            }
        }
    }
    .toList()