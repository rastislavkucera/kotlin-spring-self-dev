package com.exchange.backend.controllers

import com.exchange.backend.exceptions.ConflictException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus


@RestControllerAdvice
class ControllerAdvice {
    @ResponseStatus(value= HttpStatus.CONFLICT)
    @ExceptionHandler(ConflictException::class)
    fun handleConflictException(e: ConflictException?): Map<String, String>? {
            return e?.getRequestErrorBody()
    }
}