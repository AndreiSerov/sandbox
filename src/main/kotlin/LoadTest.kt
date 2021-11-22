import kotlinx.coroutines.runBlocking
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.RequestEntity
import org.springframework.web.client.RestTemplate
import java.lang.Thread.sleep
import java.time.Instant
import kotlin.concurrent.thread


fun get(threadNumber: Int) {
    for (i in 1..threadNumber) {
        thread() {
            println(Instant.now())
            val restTemplate = RestTemplate()
            val forEntity = restTemplate.getForEntity("http://localhost:8080/kt/getEntity", String::class.java)
            println(forEntity)
        }
    }
}


fun getStream(threadNumber: Int) {
    for (i in 1..threadNumber) {
        thread() {
//            println(Instant.now())
            val restTemplate = RestTemplate()
            val forEntity = restTemplate.getForEntity("http://localhost:8080/stream", String::class.java)
            println(forEntity)
        }
    }
}

fun getOne(threadNumber: Int) {
    for (i in 1..threadNumber) {
        thread() {
            println(Instant.now())
            val restTemplate = RestTemplate()
            val forEntity = restTemplate.getForEntity("http://localhost:8080/kt/getEntity/$i", String::class.java)
            println(forEntity)
        }
    }
}

fun post(threadNumber: Int) {
    for (i in 1..threadNumber) {
        thread() {
            println(Instant.now())
            val restTemplate = RestTemplate()
            val requestEntity = HttpEntity(user, HttpHeaders().apply {
                contentType = MediaType.APPLICATION_JSON
            })
            val forEntity = restTemplate.postForEntity("http://localhost:8080/kt/create", requestEntity, String::class.java)
            println(forEntity)
        }
    }
}

fun main() {
//    sleep(10000L)
//    println("START")
//    listOf<Int>(10, 9, 8, 7, 6, 5, 4, 3, 2, 1).forEach { i: Int ->
//        sleep(1000L)
//        println("$i")
//    }
    runBlocking {
//        get(1)
//        getOne(500)
//        post(30)
        getStream(1000)
    }
}

val user = User(
    "VAsya",
    Address(
        "Volg",
        "Moscow"
    )
)

data class User (
//    val id: Int,
    val username: String,
    val address: Address
)

data class Address (
    val street: String,
    val city: String
)
class LoadTest {
}