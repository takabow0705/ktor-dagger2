package com.github.takabow0705.user

import com.github.takabow0705.database.user.User

interface UserManagementService {

  fun listUser(): List<UserListedResponse>

  fun registerUser(user: UserRegistrationRequest): User?

  fun deleteUser(emailAddress: String): Boolean
}

data class UserRegistrationRequest(
  val emailAddress: String,
  val password: String,
  val userName: String,
  val detail: String?
)

data class UserListedResponse(
  val id: Int,
  val emailAddress: String,
  val userName: String,
  val isDeleted: Boolean,
  val detail: String?
)
