package ro.jtonic.ktors

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.netty.*
import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.ExperimentalTime

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }
    configureRouting()
}

@Serializable
data class Customer(val id: String, val firstName: String, val lastName: String, val email: String)

@OptIn(ExperimentalTime::class)
private fun Application.configureRouting() {
    routing {
        get {
            val customers: List<Customer> =
                (1 .. 100)
                    .map {
                        Customer(
                            id = "$it",
                            firstName = "customer_fname-$it",
                            lastName = "customer_lname-$it",
                            email = "fname.lname$it@gmail.com"
                        )
                    }
                    .onEach{
                        val delayInMillis =
                            environment.config.propertyOrNull("ktors.delay_in_millis")?.getString()
                                ?.toLong() ?: 10
                        delay(delayInMillis)
                    }
                    .fold(emptyList()) { acc, i -> acc + i }
            call.respond(customers)
        }
    }
}
