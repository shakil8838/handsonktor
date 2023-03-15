package com.example.plugins

import com.example.data.datamodels.SpeedResponseDataModel
import com.google.gson.Gson
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import kotlinx.coroutines.CoroutineScope

fun Application.configureRouting() {

    val theGson = Gson()

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        post("/speed") {
            val params = call.parameters
            val lat = call.parameters["lat"]
            val lon = call.parameters["lon"]
            val speed = call.parameters["speed"]?.toFloatOrNull()

            if (speed != null && lat != null && lon != null) {
                if (speed < 5.0) {
                    call.respondText(
                        theGson
                            .toJson(
                                SpeedResponseDataModel(
                                    "Current speed is ideal",
                                    "Ideal"
                                )
                            )
                    )
                } else {
                    call.respondText(
                        theGson
                            .toJson(
                                SpeedResponseDataModel(
                                    "Current speed is Over",
                                    "OverSpeed"
                                )
                            )
                    )
                }
            } else {
                call.respondText("{\"responseStatus\":\"all parameters are required\"}")
            }

        }
    }
}
