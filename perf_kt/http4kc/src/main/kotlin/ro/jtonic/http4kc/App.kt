package ro.jtonic.http4kc

import org.http4k.client.ApacheClient
import org.http4k.core.Method
import org.http4k.core.Request
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@OptIn(ExperimentalTime::class)
fun main() {
    val httpClient = ApacheClient()
    println("Start the execution of 100 HTTP calls.")
    val execTimeMillisec = measureTime {
        getUrls()
            .forEach { url ->
                val request = Request(Method.GET, url.value)
                val response = httpClient(request)
                response.body
            }
    }.inWholeMilliseconds
    println("Execution time [millisec]: $execTimeMillisec")
}

fun getUrls(): List<Url> = run {
    (1..50).map {
        listOf(Url("http://localhost:8080"), Url("http://localhost:8080"))
    }.flatten()
}

@JvmInline
value class Url(val value: String)
