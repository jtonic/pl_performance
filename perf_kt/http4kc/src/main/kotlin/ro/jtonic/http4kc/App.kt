package ro.jtonic.http4kc

import org.http4k.client.ApacheClient
import org.http4k.core.HttpHandler
import org.http4k.core.Method
import org.http4k.core.Request
import ro.jtonic.common.Url as URL
import ro.jtonic.common.format
import ro.jtonic.common.getUrls
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@OptIn(ExperimentalTime::class)
fun main() {
    val httpClient = ApacheClient()
    println("Start the execution of 100 HTTP calls.")
    val execTime = measureTime {
        getUrls()
            .forEachIndexed { idx, url ->
                val response = call(idx + 1, httpClient, url)
                response.body
            }
    }.toDouble(DurationUnit.SECONDS)
    println("Execution time [seconds]: ${execTime.format}")
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
