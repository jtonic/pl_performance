val ktorVersion: String by project

plugins {
    application
}

dependencies {
    implementation(project(":common"))
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-serialization:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
    implementation("io.ktor:ktor-client-logging:$ktorVersion")
}

application {
    mainClass.set("ro.jtonic.ktorc.AppKt")
}
