package ro.jtonic.http4kc

import org.http4k.client.ApacheClient
import org.http4k.core.HttpHandler
import org.http4k.core.Method
import org.http4k.core.Request
import ro.jtonic.common.Url as URL
import ro.jtonic.common.format
import ro.jtonic.common.getUrls
import kotlin.system.measureTimeMillis
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
fun main() {
    val httpClient = ApacheClient()
    println("Start the execution of 100 HTTP calls.")
    val execTimeMillis = measureTimeMillis {
        getUrls()
            .forEachIndexed { idx, url ->
                val response = call(idx + 1, httpClient, url)
                response.body
            }
    }
    println("Execution time [millis]: ${execTimeMillis.format}")
}

private fun call(
    idx: Int,
    httpClient: HttpHandler,
    url: URL
) = run {
    val response = httpClient(Request(Method.GET, url.value))
    println("$idx => [${url.value}] Response status: ${response.status.code}")
    response
}
