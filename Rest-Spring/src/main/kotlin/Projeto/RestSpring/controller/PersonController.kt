package Projeto.RestSpring.controller

import Projeto.RestSpring.model.Person
import Projeto.RestSpring.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    lateinit var service: PersonService
    // autowired é que vai injetar a instância quando for necessário
    // a mesma coisa disso: var service: PersonService = PersonService()
    // lateinit --> usado quando queremos dizer que vai ser setado posteriormente


    @RequestMapping(value = ["{id}"], method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun sum(
        @PathVariable(value = "id") id: Long
    ): Person {
        return service.findById(id)
    }
}