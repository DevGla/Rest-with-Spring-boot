package br.projto.demo.services

import br.projto.demo.controller.PersonController
import br.projto.demo.data.vo.v1.PersonVo
import br.projto.demo.exceptions.RequiredObjectNullException
//import br.projto.demo.data.vo.v2.PersonVoV2
import br.projto.demo.exceptions.ResourceNotFound
import br.projto.demo.mapper.DozerMapper
import br.projto.demo.model.Person
import br.projto.demo.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonServices {

    @Autowired
    private lateinit var repository: PersonRepository

    private var logger = Logger.getLogger(PersonServices::class.java.name)


    fun findAll(): List<PersonVo> {
        logger.info("Find all people")
        val persons = repository.findAll()
        val vos = DozerMapper.parsingListObject(persons, PersonVo::class.java)
        for (person in vos) {
            val withSelfRel = linkTo(PersonController::class.java).slash(person.key).withSelfRel()
            person.add(withSelfRel)
        }
        return vos
    }

    fun findById(id: Long): PersonVo {
        logger.info("Find by id: $id")
        val person = repository.findById(id).orElseThrow({ ResourceNotFound("not exist this id") })
        val personVo : PersonVo = DozerMapper.parseObject(person, PersonVo::class.java)
        val withSelfRel = linkTo(PersonController::class.java).slash(personVo.key).withSelfRel()
        personVo.add(withSelfRel)
        return personVo
    }

    fun createPerson (person: PersonVo?): PersonVo {
        if(person == null) throw RequiredObjectNullException()
        logger.info("create one person with name: ${person.firstName}")
        val entity: Person = DozerMapper.parseObject(person, Person::class.java)
        val entityBD = repository.save(entity)
        val personVo : PersonVo = DozerMapper.parseObject(entityBD, PersonVo::class.java)
        val withSelfRel = linkTo(PersonController::class.java).slash(personVo.key).withSelfRel()
        personVo.add(withSelfRel)
        return personVo
    }

//    fun createPersonV2 (person: PersonVoV2): PersonVoV2 {
//        logger.info("create one person with name: ${person.firstName}")
//        val entity: Person = DozerMapper.parseObject(person, Person::class.java)
//        val entityBD = repository.save(entity)
//        return DozerMapper.parseObject(entityBD, PersonVoV2::class.java)
//    }

    fun updatePerson (person: PersonVo): PersonVo {
        logger.info("updating one person with id: ${person.key}")
        val findPerson = repository.findById(person.key).orElseThrow({ ResourceNotFound("not exist this id") })
        findPerson.firstName = person.firstName
        findPerson.lastName = person.lastName
        findPerson.address= person.address
        findPerson.gender = person.gender

        val entityBD = repository.save(findPerson)
        val personVo : PersonVo = DozerMapper.parseObject(entityBD, PersonVo::class.java)
        val withSelfRel = linkTo(PersonController::class.java).slash(personVo.key).withSelfRel()
        personVo.add(withSelfRel)
        return personVo
    }

    fun deletePerson (key: Long) {
        logger.info("deleting one person with id: ${key}")
        val person = repository.findById(key).orElseThrow({ ResourceNotFound("not exist this id") })
        return repository.delete(person)
    }

}
