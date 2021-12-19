val javaVersion: String by project
val kotlinVersion: String by project
val logbackVersion: String by project
val kotestVersion: String by project

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.10" apply(true)
    id("org.jetbrains.kotlin.plugin.serialization") version "1.6.0-RC" apply(true)
}

allprojects {

    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.plugin.serialization")
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("ch.qos.logback:logback-classic:$logbackVersion")

        testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
        testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(javaVersion.toInt()))
        }
    }

    kotlin {
        jvmToolchain {
            (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(javaVersion.toInt()))
        }
    }

    tasks {
        compileKotlin {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
            }
        }
    }

    testing {
        suites {
            val test by getting(JvmTestSuite::class) {
                useJUnitJupiter()
            }
        }
    }

    configurations {
        implementation {
            resolutionStrategy.failOnVersionConflict()
        }
    }
}

