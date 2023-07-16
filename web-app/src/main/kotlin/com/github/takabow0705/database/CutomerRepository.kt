package com.github.takabow0705.database

import com.github.takabow0705.domain.Customer
import com.github.takabow0705.domain.customerStorage

interface CustomerRepository {
  fun findAll(): List<Customer>

  fun findOne(id: String): Customer?

  fun createCustomer(customer: Customer): Unit

  fun deleteCustomer(id: String): Boolean
}

class CustomerRepositoryImpl : CustomerRepository {
  override fun findAll(): List<Customer> {
    return customerStorage
  }

  override fun findOne(id: String): Customer? {
    return customerStorage.find { it.id == id }
  }

  override fun createCustomer(customer: Customer) {
    customerStorage.add(customer)
  }

  override fun deleteCustomer(id: String): Boolean {
    return customerStorage.removeIf { it.id == id }
  }
}
