package com.github.takabow0705.plugins.dagger2.module

import com.github.takabow0705.controller.OrderApiController
import com.github.takabow0705.controller.OrderApiV1Controller
import com.github.takabow0705.database.DummyRepository
import com.github.takabow0705.database.DummyRepositoryImpl
import com.github.takabow0705.database.OrderRepository
import com.github.takabow0705.database.OrderRepositoryImpl
import com.github.takabow0705.service.OrderService
import com.github.takabow0705.service.OrderServiceImpl
import dagger.Module
import dagger.Provides

@Module
class OrderModule {
  @Provides
  fun provideOrderRepository(): OrderRepository {
    return OrderRepositoryImpl()
  }

  @Provides
  fun provideDummyRepository(): DummyRepository {
    return DummyRepositoryImpl()
  }

  @Provides
  fun provideOrderService(
    orderRepository: OrderRepository,
    dummyRepository: DummyRepository
  ): OrderService {
    return OrderServiceImpl(orderRepository, dummyRepository)
  }

  @Provides
  fun provideOrderApiController(orderService: OrderService): OrderApiController {
    return OrderApiV1Controller(orderService)
  }
}
