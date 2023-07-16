package com.github.takabow0705.controller

import com.github.takabow0705.domain.Customer
import com.github.takabow0705.service.CustomerService
import com.github.takabow0705.service.DummyService
import javax.inject.Inject

interface CustomerApiController {
  fun listCustomers(): List<Customer>

  fun getCustomer(id: String): Customer?

  fun createCustomer(customer: Customer)

  fun deleteCustomer(id: String): Boolean
}

class CustomerApiV1Controller
@Inject
constructor(private val customerService: CustomerService, private val dummyService: DummyService) :
  CustomerApiController {
  override fun listCustomers(): List<Customer> {
    dummyService.listSomething()
    return customerService.findAll()
  }

  override fun getCustomer(id: String): Customer? {
    dummyService.getSomething()
    return customerService.findOne(id)
  }

  override fun createCustomer(customer: Customer) {
    return customerService.createCustomer(customer)
  }

  override fun deleteCustomer(id: String): Boolean {
    return customerService.deleteCustomer(id)
  }
}
