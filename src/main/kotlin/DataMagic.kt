


data class DataMagic (
    val name: String,
    val data: Data
)

data class Data (
    val name: String,
    val dataMagic: List<DataMagic?>
)


fun main() {
    val data = Data("dataName", listOf<DataMagic>())
    DataMagic("a", data)
}