package br.projto.demo.mockito.services

import br.com.erudio.unittests.mapper.mocks.MockPerson
import br.projto.demo.exceptions.RequiredObjectNullException
import br.projto.demo.repository.PersonRepository
import br.projto.demo.services.PersonServices
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
class PersonServicesTest {

    private lateinit var inputObject: MockPerson

    @InjectMocks
    private lateinit var service: PersonServices

    @Mock
    private lateinit var repository: PersonRepository

    @BeforeEach
    fun setUpMock() {
        inputObject = MockPerson()
        MockitoAnnotations.openMocks(this)

    }

    @Test
    fun findAll() {

        val list = inputObject.mockEntityList()
        `when`(repository.findAll()).thenReturn(list)

        val persons = service.findAll()

        assertNotNull(persons)
        assertEquals(14, persons.size)

        val personOne = persons[1]

        assertEquals("Address Test1", personOne.address)
        assertEquals("Last Name Test1", personOne.lastName)
        assertEquals("First Name Test1", personOne.firstName)
        assertEquals("Female", personOne.gender)
    }

    @Test
    fun findById() {
        val person = inputObject.mockEntity(1)
        person.id = 1L
        `when`(repository.findById(1)).thenReturn(Optional.of(person))

        val result = service.findById(1)

        assertNotNull(result)
        assertNotNull(result.key)
        assertNotNull(result.links)
        assertTrue(result.links.toString().contains("</person/1>;rel=\"self\""))

        assertEquals("Address Test1", result.address)
        assertEquals("Last Name Test1", result.lastName)
        assertEquals("First Name Test1", result.firstName)
        assertEquals("Female", result.gender)
    }

    @Test
    fun createPerson() {

        val entity = inputObject.mockEntity(1)

        val persisted = entity.copy()
        persisted.id = 1
        `when`(repository.save(entity)).thenReturn(persisted)

        val vo = inputObject.mockVO(1)
        val result = service.createPerson(vo)


        assertNotNull(result)
        assertNotNull(result.key)
        assertNotNull(result.links)
        assertTrue(result.links.toString().contains("</person/1>;rel=\"self\""))

        assertEquals("Address Test1", result.address)
        assertEquals("Last Name Test1", result.lastName)
        assertEquals("First Name Test1", result.firstName)
        assertEquals("Female", result.gender)

    }

    @Test
    fun updatePerson() {
        val entity = inputObject.mockEntity(1)

        val persisted = entity.copy()
        persisted.id = 1

        `when`(repository.findById(1)).thenReturn(Optional.of(entity))
        `when`(repository.save(entity)).thenReturn(persisted)

        val vo = inputObject.mockVO(1)
        val result = service.updatePerson(vo)


        assertNotNull(result)
        assertNotNull(result.key)
        assertNotNull(result.links)
        assertTrue(result.links.toString().contains("</person/1>;rel=\"self\""))

        assertEquals("Address Test1", result.address)
        assertEquals("Last Name Test1", result.lastName)
        assertEquals("First Name Test1", result.firstName)
        assertEquals("Female", result.gender)
    }

    @Test
    fun deletePerson() {
        val person = inputObject.mockEntity(1)
        person.id = 1L
        `when`(repository.findById(1)).thenReturn(Optional.of(person))

        service.deletePerson(1)
    }

    @Test
    fun createWithNullPerson() {
        val exception: Exception = assertThrows(
            RequiredObjectNullException::class.java
        ) {service.createPerson(null)}

        val message = "it is not allowed to persist a null object"
        val actualMessage = exception.message

        assertTrue(actualMessage!!.contains(message))
    }
}

