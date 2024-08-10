
val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "2.0.10"
    id("io.ktor.plugin") version "2.3.12"
    id("org.jetbrains.kotlin.plugin.serialization") version "2.0.10"
}

group = "example.com"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-server-config-yaml")
    testImplementation("io.ktor:ktor-server-test-host-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

        implementation("io.ktor:ktor-server-core:2.3.12")
        implementation("io.ktor:ktor-server-netty:2.3.12")
        implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.12")
        implementation("org.jetbrains.exposed:exposed-core:0.42.1")
        implementation("org.jetbrains.exposed:exposed-dao:0.42.1")
        implementation("org.jetbrains.exposed:exposed-jdbc:0.42.1")
        implementation("mysql:mysql-connector-java:8.0.30")
        implementation("io.ktor:ktor-server-host-common:2.3.12")
        implementation("io.ktor:ktor-server-content-negotiation:2.3.12")
    }

