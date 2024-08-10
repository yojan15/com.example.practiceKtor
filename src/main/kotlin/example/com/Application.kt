package example.com

import example.com.plugins.configureRouting
import io.ktor.server.application.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.contentnegotiation.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    this.install(ContentNegotiation) {
        json()
    }
    configureRouting()
}
