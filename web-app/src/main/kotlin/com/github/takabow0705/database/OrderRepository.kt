package com.github.takabow0705.database

import com.github.takabow0705.domain.Order
import com.github.takabow0705.domain.orderStorage

interface OrderRepository {
  fun findAll(): List<Order>

  fun getOrderCount(id: String): Double

  fun findOne(number: String): Order?
}

class OrderRepositoryImpl : OrderRepository {
  override fun findAll(): List<Order> {
    return orderStorage
  }

  override fun getOrderCount(id: String): Double {
    val order = orderStorage.find { it.number == id }
    if (order == null) return 0.0
    return order.contents.sumOf { it.price * it.amount }
  }

  override fun findOne(number: String): Order? {
    return orderStorage.find { it.number == number }
  }
}
