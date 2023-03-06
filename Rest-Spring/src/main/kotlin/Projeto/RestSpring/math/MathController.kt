package Projeto.RestSpring.math

import Projeto.RestSpring.exceptions.unssuportedMAthOperationException
import org.apache.el.parser.BooleanNode
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception

@RestController
class MathController {
    // RequestMaping permite uma ligacão entre o Path e o método manipulador(nesse caso: sum)
    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    // PathVariable nos permite recuperar dados que foram passados na URL e usá-los
    fun sum(
        @PathVariable(value = "numberOne") numberOne: String,
        @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw unssuportedMAthOperationException("Por favor escreva um valor numerico")
        return convertDouble(numberOne) + convertDouble(
            numberTwo
        )
    }
    @RequestMapping(value = ["/subtra/{numberOne}/{numberTwo}"])
    fun subtra(
        @PathVariable(value = "numberOne") numberOne: String,
        @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw unssuportedMAthOperationException("Por favor escreva um valor numerico")
        return convertDouble(numberOne) - convertDouble(
            numberTwo
        )
    }

    // PathVariable nos permite recuperar dados que foram passados na URL e usá-los
    @RequestMapping(value = ["/mult/{numberOne}/{numberTwo}"])
    fun mult(
        @PathVariable(value = "numberOne") numberOne: String,
        @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw unssuportedMAthOperationException("Por favor escreva um valor numerico")
        return convertDouble(numberOne) * convertDouble(
            numberTwo
        )
    }
    @RequestMapping(value = ["/div/{numberOne}/{numberTwo}"])
// PathVariable nos permite recuperar dados que foram passados na URL e usá-los
    fun div(
        @PathVariable(value = "numberOne") numberOne: String,
        @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw unssuportedMAthOperationException("Por favor escreva um valor numerico")
        return convertDouble(numberOne) / convertDouble(numberTwo)
    }
    fun isNumeric(number: String?): Boolean {
        if(number.isNullOrBlank()) return false
        val reNumber = number.replace(",".toRegex(), ".")
        return reNumber.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }
    private fun convertDouble(number: String?): Double {
        if(number.isNullOrBlank()) return 0.0
        val reNumber = number.replace(",".toRegex(), ".")
        return if (isNumeric(reNumber)) reNumber.toDouble() else 0.0
    }
}