package com.github.takabow0705.routes

import com.github.takabow0705.controller.OrderApiController
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.listOrdersRoute(orderApiController: OrderApiController) {
  get("/order") { call.respond(orderApiController.listOrder()) }
}

fun Route.getOrderRoute(orderApiController: OrderApiController) {
  get("/order/{id?}") {
    val id =
      call.parameters["id"]
        ?: return@get call.respondText("Bad Request", status = HttpStatusCode.BadRequest)
    val order =
      orderApiController.getOrder(id)
        ?: return@get call.respondText("Not Found", status = HttpStatusCode.NotFound)
    call.respond(order)
  }
}

fun Route.totalizeOrderRoute(orderApiController: OrderApiController) {
  get("/order/{id?}/total") {
    val id =
      call.parameters["id"]
        ?: return@get call.respondText("Bad Request", status = HttpStatusCode.BadRequest)
    val total = orderApiController.getTotalOrderAmount(id)
    call.respond(total)
  }
}
