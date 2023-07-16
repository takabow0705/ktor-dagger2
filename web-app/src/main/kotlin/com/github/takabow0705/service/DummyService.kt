package com.github.takabow0705.service

import com.github.takabow0705.database.DummyRepository
import javax.inject.Inject

interface DummyService {
  fun getSomething()

  fun listSomething()
}

class DummyServiceImpl @Inject constructor(private val dummyService: DummyRepository) :
  DummyService {
  override fun getSomething() {
    println(dummyService.getSomething())
  }

  override fun listSomething() {
    println(dummyService.findAll())
  }
}
