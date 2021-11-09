import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import java.nio.charset.StandardCharsets
import java.util.*


const val stringToDecode = "eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ=="
val stringToEncode = """
{"sub":"1234567890",
"name":"John Doe",
"iat":1516239022,
"iss":"stubIss",
"realm":"stubRealm",
"auth:token:encrypt":"Stub Encrypt Token"}
""".replace("^\\s+|\\n".toRegex(RegexOption.MULTILINE), "")

data class A (var x: String, var y: String )
val  etalon = """{"sub":"1234567890","name":"John Doe","iat":1516239022}"""
fun main() {


    println(encode(stringToEncode))
}

//    {"sub":"1234567890","name":"John Doe","iat":1516239022}
private fun decode(str: String): Map<String, String> {
    val objectMapper = ObjectMapper()
    val payload = String(
        Base64.getUrlDecoder().decode(str.toByteArray(StandardCharsets.UTF_8)), StandardCharsets.UTF_8
    )
    return objectMapper.readValue(payload, object : TypeReference<Map<String, String>>() {})
}

private fun encode(str: String): String {
    return Base64.getUrlEncoder().encodeToString(str.toByteArray(StandardCharsets.UTF_8))
}