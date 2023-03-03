package Projeto.RestSpring.math

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Test {

    @RequestMapping(value = ["/sum/teste/{numberOne}/{numberTwo}"])

    fun sum(@PathVariable(value= "numberOne") numberOne: Int,
            @PathVariable(value= "numberTwo") numberTwo: Int): String{
        return "A Soma dos dois valores é: $numberOne + $numberTwo"
    }
}