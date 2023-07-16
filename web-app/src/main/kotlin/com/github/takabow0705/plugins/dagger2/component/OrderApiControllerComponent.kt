package com.github.takabow0705.plugins.dagger2.component

import com.github.takabow0705.controller.OrderApiController
import com.github.takabow0705.plugins.dagger2.module.OrderModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [OrderModule::class])
interface OrderApiControllerComponent {
  fun injectOrderApiController(): OrderApiController
}
