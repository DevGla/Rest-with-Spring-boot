package br.projto.demo.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(HttpStatus.NOT_FOUND)
class RequiredObjectNullException : RuntimeException {
    constructor() : super("it is not allowed to persist a null object!")
    constructor(exception: String?) : super(exception)
}