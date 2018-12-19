package xyz.sangcomz.kendql

import com.google.gson.Gson
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.*
import io.ktor.gson.gson
import io.ktor.locations.Locations
import org.koin.core.Koin
import org.koin.dsl.module.module
import org.koin.log.PrintLogger
import org.koin.standalone.StandAloneContext.startKoin
import xyz.sangcomz.kendql.graphql.AppSchema
import java.text.DateFormat

class KendQLApp {
    private val mainModule = module {
        factory { Gson() }
        factory { AppSchema() }
    }

    fun Application.main() {
        Koin.logger = PrintLogger()
        startKoin(listOf(mainModule))

        install(DefaultHeaders)
//        install(CORS) {
//            method(HttpMethod.Options)
//            method(HttpMethod.Get)
//            method(HttpMethod.Post)
//            anyHost()
//            allowCredentials = true
//            maxAge = Duration.ofDays(1)
//        }
        install(CallLogging)
        install(Locations)
        install(ConditionalHeaders)
        install(PartialContent)
        install(ContentNegotiation) {
            gson {
                setDateFormat(DateFormat.LONG)
                setPrettyPrinting()
            }
        }
    }
}