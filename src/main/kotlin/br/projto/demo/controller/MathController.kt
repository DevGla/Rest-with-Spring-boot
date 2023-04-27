package br.projto.demo.controller

import br.projto.demo.exceptions.unssuportedMath
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception

@RestController
// facilitar o recurso REST com SPRING
class MathController {

    private fun isNumeric(n: String?): Boolean {
        if (n.isNullOrBlank()) return false;
        val number = n.replace(",".toRegex(), ".")
        return number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }

    private fun convertToDouble(n: String?): Double {
        if (n.isNullOrBlank()) return 0.0
        val number = n.replace(",".toRegex(), ".")
        return if(isNumeric(n)) number.toDouble() else 0.0
    }

    @RequestMapping(value=["/sum/{n1}/{n2}"])
    fun sum(
        @PathVariable(value="n1") n1: String?,
        @PathVariable(value="n2") n2: String?
        // usado para recuperar dados da URL
    ): Double{
        if (!isNumeric(n1) || !isNumeric(n2)) throw unssuportedMath("Por favor escreva um valor numerico")
        return convertToDouble(n1) + convertToDouble(n2)
    }
}