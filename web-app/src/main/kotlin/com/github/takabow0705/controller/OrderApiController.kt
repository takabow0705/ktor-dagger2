package com.github.takabow0705.controller

import com.github.takabow0705.domain.Order
import com.github.takabow0705.service.OrderService
import javax.inject.Inject

interface OrderApiController {
  fun getOrder(number: String): Order?

  fun getTotalOrderAmount(number: String): Double

  fun listOrder(): List<Order>
}

class OrderApiV1Controller @Inject constructor(private val orderService: OrderService) :
  OrderApiController {
  override fun getOrder(number: String): Order? {
    return orderService.getOrder(number)
  }

  override fun getTotalOrderAmount(number: String): Double {
    return orderService.calculateTotalOrder(number)
  }

  override fun listOrder(): List<Order> {
    return orderService.listOrder()
  }
}
