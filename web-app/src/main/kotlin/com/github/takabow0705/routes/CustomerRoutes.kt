package com.github.takabow0705.routes

import com.github.takabow0705.controller.CustomerApiController
import com.github.takabow0705.domain.Customer
import com.github.takabow0705.domain.customerStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.customerRouting(customerApiController: CustomerApiController) {
  route("/customer") {
    get {
      if (customerStorage.isNotEmpty()) {
        call.respond(customerApiController.listCustomers())
      } else {
        call.respondText("No customer found", status = HttpStatusCode.OK)
      }
    }
    get("{id?}") {
      val id =
        call.parameters["id"]
          ?: return@get call.respondText("Missing id", status = HttpStatusCode.BadRequest)
      val customer =
        customerApiController.getCustomer(id)
          ?: return@get call.respondText(
            "No customer with id $id",
            status = HttpStatusCode.NotFound
          )
      call.respond(customer)
    }
    post {
      try {
        val customer = call.receive<Customer>()
        customerApiController.createCustomer(customer)
        call.respondText("Customer stored correctly", status = HttpStatusCode.Created)
      } catch (e: Exception) {
        e.printStackTrace()
        print(e.message)
      }
    }
    delete("{id?}") {
      val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
      if (customerApiController.deleteCustomer(id)) {
        call.respondText("Customer removed correctly", status = HttpStatusCode.Accepted)
      } else {
        call.respondText("Not Found", status = HttpStatusCode.NotFound)
      }
    }
  }
}
