package ro.jtonic.common

import java.text.DecimalFormat
import java.util.*

@JvmInline
value class Url(val value: String)

fun getUrls(): List<Url> = run {
    (1..50).map {
        listOf(
            Url("http://localhost:8080"),
            Url("http://localhost:8080"),
        )
    }.flatten()
}

val Long.format: String
    get() = run {
        val df = DecimalFormat.getInstance(Locale("ro", "RO"))
        df.format(this)
    }

val Double.format: String
    get() = run {
        val df = DecimalFormat.getInstance(Locale("ro", "RO"))
        df.format(this)
    }
