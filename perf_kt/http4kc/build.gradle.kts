val http4kVersion: String by project

plugins {
    application
}

dependencies {
    implementation(platform("org.http4k:http4k-bom:$http4kVersion"))
    implementation("org.http4k:http4k-core")
    implementation("org.http4k:http4k-client-apache")
}

application {
    mainClass.set("ro.jtonic.http4kc.AppKt")
}
