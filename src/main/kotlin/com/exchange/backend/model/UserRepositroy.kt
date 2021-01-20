package com.exchange.backend.model

import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserRepository : CrudRepository<User, Long> {
    fun findUserById(id: Long): User?
    fun findByEmail(email: String): User?
}