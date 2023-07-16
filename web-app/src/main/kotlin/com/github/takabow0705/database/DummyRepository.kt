package com.github.takabow0705.database

// 2変数以上のコンストラクターインジェクションの確認用
interface DummyRepository {
  fun getSomething(): String

  fun findAll(): List<String>
}

class DummyRepositoryImpl : DummyRepository {
  override fun getSomething(): String {
    return "**********************Something**********************"
  }

  override fun findAll(): List<String> {
    return listOf(
      "**********************Something1**********************",
      "**********************Something2**********************"
    )
  }
}
