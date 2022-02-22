import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset


data class DataMagic (
    val name: String,
    val data: Data
)

data class Data (
    val name: String,
    val dataMagic: List<DataMagic?>
)

fun Instant.toGtcTime() =  LocalDateTime.ofInstant(this, ZoneOffset.UTC)


fun main() {
    val toGtcTime = Instant.now().toGtcTime()
    println(toGtcTime)
//    val data = Data("dataName", listOf<DataMagic>())
//    DataMagic("a", data)
}