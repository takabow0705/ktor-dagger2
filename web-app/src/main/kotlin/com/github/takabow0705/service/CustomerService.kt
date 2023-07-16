package com.github.takabow0705.service

import com.github.takabow0705.database.CustomerRepository
import com.github.takabow0705.database.DummyRepository
import com.github.takabow0705.domain.Customer
import javax.inject.Inject

interface CustomerService {
  fun findAll(): List<Customer>

  fun findOne(id: String): Customer?

  fun createCustomer(customer: Customer): Unit

  fun deleteCustomer(id: String): Boolean
}

class CustomerServiceImpl
@Inject
constructor(
  private val customerRepository: CustomerRepository,
  private val dummyRepository: DummyRepository
) : CustomerService {
  override fun findAll(): List<Customer> {
    print(dummyRepository.getSomething())
    return customerRepository.findAll()
  }

  override fun findOne(id: String): Customer? {
    return customerRepository.findOne(id)
  }

  override fun createCustomer(customer: Customer) {
    return customerRepository.createCustomer(customer)
  }

  override fun deleteCustomer(id: String): Boolean {
    return customerRepository.deleteCustomer(id)
  }
}
