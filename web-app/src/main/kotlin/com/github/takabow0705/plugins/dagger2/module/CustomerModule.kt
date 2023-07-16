package com.github.takabow0705.plugins.dagger2.module

import com.github.takabow0705.controller.CustomerApiController
import com.github.takabow0705.controller.CustomerApiV1Controller
import com.github.takabow0705.database.CustomerRepository
import com.github.takabow0705.database.CustomerRepositoryImpl
import com.github.takabow0705.database.DummyRepository
import com.github.takabow0705.database.DummyRepositoryImpl
import com.github.takabow0705.service.CustomerService
import com.github.takabow0705.service.CustomerServiceImpl
import com.github.takabow0705.service.DummyService
import com.github.takabow0705.service.DummyServiceImpl
import dagger.Module
import dagger.Provides

@Module
class CustomerModule {
  @Provides
  fun provideCustomerRepository(): CustomerRepository {
    return CustomerRepositoryImpl()
  }

  @Provides
  fun provideDummyRepository(): DummyRepository {
    return DummyRepositoryImpl()
  }

  @Provides
  fun provideCustomerService(
    customerRepository: CustomerRepository,
    dummyRepository: DummyRepository
  ): CustomerService {
    return CustomerServiceImpl(customerRepository, dummyRepository)
  }

  @Provides
  fun provideDummyService(dummyRepository: DummyRepository): DummyService {
    return DummyServiceImpl(dummyRepository)
  }

  @Provides
  fun provideCustomerApiController(
    customerService: CustomerService,
    dummyService: DummyService
  ): CustomerApiController {
    return CustomerApiV1Controller(customerService, dummyService)
  }
}
