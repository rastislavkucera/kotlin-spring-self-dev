package com.exchange.backend.exceptions

class ConflictException(var error: String) : Throwable() {
    fun getRequestErrorBody(): Map<String, String> {
        return mapOf("error" to error)
    }
}