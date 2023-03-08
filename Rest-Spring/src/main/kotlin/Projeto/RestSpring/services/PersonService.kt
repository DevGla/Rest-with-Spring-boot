package Projeto.RestSpring.services

import Projeto.RestSpring.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

// usado para não precisar unicializa-lo em outro lugar
@Service
class PersonService {

    private val counter: AtomicLong = AtomicLong()

    // usado para gerar um log do que está acontecendo na nossa aplicação
    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Find All People!")
        val persons: MutableList<Person> = ArrayList()
        for (i in 0 .. 7){
            val person = mockPerson(i)
            persons.add(person)
        }
        return persons
    }
    fun findById(id: Long): Person {
        logger.info("Find One Person!")
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Person name $id"
        person.lastName = "Person LastName $id"
        person.address = "Some address in Brasil"
        person.gender = "male"
        return person
    }

    fun createPerson(person: Person): Person {
        // Lógica de ir ao banco e criar uma pessoa e retornar a mesma!
        return person
    }

    fun updatePerson(person: Person): Person {
        // Lógica de ir ao banco e atualizar uma pessoa e retornar a mesma!
        return person
    }

    fun deletePerson(id: Long) {}
    // Nesse caso aqui não retornamos nada.
    private fun mockPerson(i: Int): Person {
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Person name $i"
        person.lastName = "Person LastName $i"
        person.address = "Some address in Brasil"
        person.gender = "male"
        return person
    }
}