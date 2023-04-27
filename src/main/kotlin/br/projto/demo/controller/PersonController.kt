package br.projto.demo.controller

import br.projto.demo.data.vo.v1.PersonVo
//import br.projto.demo.data.vo.v2.PersonVoV2
import br.projto.demo.services.PersonServices
import br.projto.demo.utils.MediaType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
// facilitar o recurso REST com SPRING
class PersonController {
    @Autowired
    private lateinit var service : PersonServices


    @GetMapping(produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML0])
    fun findAllController(): List<PersonVo> {
        return service.findAll()
    }

    @GetMapping(value=["/{id}"], produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
         MediaType.APPLICATION_YML0])
    fun findByIdController(
        @PathVariable(value="id") id: Long,
        // usado para recuperar dados da URL
    ): PersonVo {
        return service.findById(id)
    }

    @PostMapping(produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML],
        consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML0])
    fun createController (@RequestBody person: PersonVo): PersonVo {
        return service.createPerson(person)
    }

//    @PostMapping(value=["/v2"],produces = [MediaType.APPLICATION_JSON], consumes = [MediaType.APPLICATION_JSON])
//    fun createControllerV2 (@RequestBody person: PersonVoV2): PersonVoV2 {
//        return service.createPersonV2(person)
//    }

    @PutMapping(produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML],
        consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML0])
    fun updateController (@RequestBody person: PersonVo): PersonVo {
        return service.updatePerson(person)
    }

    @DeleteMapping(value=["/{id}"])
    fun deleteController (@PathVariable(value="id") id: Long): ResponseEntity<*> {
        service.deletePerson(id)
        return ResponseEntity.noContent().build<Any>()
    }
}