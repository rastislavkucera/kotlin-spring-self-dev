package com.exchange.backend.controllers

import com.exchange.backend.exceptions.ConflictException
import com.exchange.backend.exceptions.ErrorResponseBody
import com.exchange.backend.exceptions.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus


@RestControllerAdvice
class ControllerAdvice {
    @ResponseStatus(value= HttpStatus.CONFLICT)
    @ExceptionHandler(ConflictException::class)
    fun handleConflictException(e: ConflictException?): ErrorResponseBody? {
            return e?.getErrorResponseBody()
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(e: NotFoundException?): ErrorResponseBody? {
        return e?.getErrorResponseBody()
    }
}