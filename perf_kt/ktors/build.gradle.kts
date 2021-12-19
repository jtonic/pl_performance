val ktorVersion: String by project

plugins {
    application
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-serialization:$ktorVersion")

    testImplementation("io.ktor:ktor-server-tests:$ktorVersion")
}


application {
    mainClass.set("ro.jtonic.ktors.AppKt")
}
