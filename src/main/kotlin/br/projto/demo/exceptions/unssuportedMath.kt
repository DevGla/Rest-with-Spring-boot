package br.projto.demo.exceptions

import java.lang.Exception
import java.lang.RuntimeException

class unssuportedMath (exception: String): RuntimeException(exception)