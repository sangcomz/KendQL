package xyz.sangcomz.kendql

import com.google.gson.Gson
import io.ktor.application.Application
import io.ktor.application.log
import io.ktor.http.content.default
import io.ktor.http.content.static
import io.ktor.routing.routing
import org.koin.ktor.ext.inject
import xyz.sangcomz.kendql.graphql.AppSchema
import xyz.sangcomz.kendql.graphql.graphql

@Suppress("unused")
fun Application.routes() {

    routing {
        val appSchema: AppSchema by inject()
        val gson: Gson by inject()

        graphql(log, gson, appSchema.schema)

        static("/") {
            default("index.html")
        }
    }
}