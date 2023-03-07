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

    fun findById(id: Long): Person {
        logger.info("Find One Person!")
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "lucas"
        person.lastName = "almeida"
        person.address = "rua duque de caxias"
        person.gender = "male"
        return person
    }
}