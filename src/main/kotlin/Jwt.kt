import com.auth0.jwt.JWT
import com.auth0.jwt.interfaces.DecodedJWT
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

data class A (var x: String, var z: Int)
val  etalon = """{"sub":"1234567890","name":"John Doe","iat":1516239022,"auth:token:encrypt":"kalia-balia"}"""

fun main() {
    val head = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9"
    val secret = "03f329983b86f7d9a9f5fef85305880101d5e302afafa20154d094b229f75773"
    val encoded = "$head.${encode(etalon)}.$secret"

    println(encoded)

    val jwt: DecodedJWT = JWT.decode(encoded)

    val token = jwt.token

    val encryptToken = jwt.claims["auth:token:encrypt"]

    println(encryptToken)

    println(token)
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