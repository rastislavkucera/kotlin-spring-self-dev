package com.exchange.backend.exceptions

import com.fasterxml.jackson.annotation.JsonInclude

// Note: remove nulls from final JSON - https://www.baeldung.com/jackson-ignore-null-fields
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ErrorResponseBody(var error: String?, var fieldErrors: Map<String, String>?){
    constructor(error: String): this(error, null)
    constructor(fieldErrors: Map<String, String>): this(null, fieldErrors)
}

open class RequestException(open var params: ErrorResponseBody) : Throwable(params.error){
    fun getErrorResponseBody(): ErrorResponseBody{
            return params
    }
}

class ConflictException(override var params: ErrorResponseBody): RequestException(params)
class NotFoundException(override var params: ErrorResponseBody): RequestException(params)