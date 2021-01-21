package com.exchange.backend.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "ExchangeUser") // Note: default 'user' as table name is reserved
class User(@Id @GeneratedValue var id: Long, var email: String, var password: String) {
}