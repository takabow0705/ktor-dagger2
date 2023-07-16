package com.github.takabow0705.service

import com.github.takabow0705.database.DummyRepository
import com.github.takabow0705.database.OrderRepository
import com.github.takabow0705.domain.Order
import javax.inject.Inject

interface OrderService {
  fun listOrder(): List<Order>

  fun calculateTotalOrder(number: String): Double

  fun getOrder(number: String): Order?
}

class OrderServiceImpl
@Inject
constructor(
  private val orderRepository: OrderRepository,
  private val dummyRepository: DummyRepository
) : OrderService {
  override fun listOrder(): List<Order> {
    println(dummyRepository.findAll())
    return orderRepository.findAll()
  }

  override fun calculateTotalOrder(number: String): Double {
    return orderRepository.getOrderCount(number)
  }

  override fun getOrder(number: String): Order? {
    return orderRepository.findOne(number)
  }
}
