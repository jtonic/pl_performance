package ro.jtonic.ktorc

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import ro.jtonic.common.format
import ro.jtonic.common.getUrls
import kotlin.system.measureTimeMillis
import ro.jtonic.common.Url as URL

suspend fun main() {
    runBlocking() {
        val httpClient = HttpClient(OkHttp)

        println("Start the execution of 100 HTTP calls.")
        val execTimeMillis = measureTimeMillis {
            getUrls().mapIndexed { idx, url ->
                async(Dispatchers.IO) { call(idx + 1, httpClient, url) }
            }.forEach {
                it.await()
            }
        }
        println("Execution time [millis]: ${execTimeMillis.format}")
        httpClient.close()
    }
}

private suspend fun call(idx: Int, httpClient: HttpClient, url: URL) {
    val response = httpClient.get<HttpStatement>(url.value).execute()
    println("$idx => [${url.value}] Response status: ${response.status.value}")
}
