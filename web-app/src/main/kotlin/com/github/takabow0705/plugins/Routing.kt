package com.github.takabow0705.plugins

import com.github.takabow0705.routes.customerRouting
import com.github.takabow0705.routes.getOrderRoute
import com.github.takabow0705.routes.listOrdersRoute
import com.github.takabow0705.routes.totalizeOrderRoute
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
  routing {
    get("/example") { call.respondText("Hello World") }
    customerRouting()
    listOrdersRoute()
    getOrderRoute()
    totalizeOrderRoute()
  }
}
