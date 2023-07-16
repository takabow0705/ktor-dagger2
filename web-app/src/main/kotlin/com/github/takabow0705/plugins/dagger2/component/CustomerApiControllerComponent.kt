package com.github.takabow0705.plugins.dagger2.component

import com.github.takabow0705.controller.CustomerApiController
import com.github.takabow0705.plugins.dagger2.module.CustomerModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CustomerModule::class])
interface CustomerApiControllerComponent {
  fun injectCustomerApiController(): CustomerApiController
}
