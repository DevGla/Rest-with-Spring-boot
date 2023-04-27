//package br.com.erudio.unittests.mapper
//
//import org.junit.jupiter.api.Assertions.assertEquals
//import org.junit.jupiter.api.BeforeEach
//import org.junit.jupiter.api.Test
//import br.com.erudio.unittests.mapper.mocks.MockPerson
//import br.projto.demo.data.vo.v1.PersonVo
//import br.projto.demo.mapper.DozerMapper
//import br.projto.demo.model.Person
//
//class DozerMapperTest {
//
//    var inputObject: MockPerson? = null
//
//    @BeforeEach
//    fun setUp() {
//        inputObject = MockPerson()
//    }
//
//    @Test
//    fun parseEntityToVOTest() {
//        val output: PersonVo = DozerMapper.parseObject(inputObject!!.mockEntity(), PersonVo::class.java)
//        assertEquals(0, output.key)
//        assertEquals("First Name Test0", output.firstName)
//        assertEquals("Last Name Test0", output.lastName)
//        assertEquals("Address Test0", output.address)
//        assertEquals("Male", output.gender)
//    }
//
//    @Test
//    fun parseEntityListToVOListTest() {
//        val outputList: ArrayList<PersonVo> =
//            DozerMapper.parsingListObject(inputObject!!.mockEntityList(), PersonVo::class.java)
//
//        val outputZero: PersonVo = outputList[0]
//
//        assertEquals(0, outputZero.key)
//        assertEquals("First Name Test0", outputZero.firstName)
//        assertEquals("Last Name Test0", outputZero.lastName)
//        assertEquals("Address Test0", outputZero.address)
//        assertEquals("Male", outputZero.gender)
//
//        val outputSeven: PersonVo = outputList[7]
//        assertEquals(7.toLong(), outputSeven.key)
//        assertEquals("First Name Test7", outputSeven.firstName)
//        assertEquals("Last Name Test7", outputSeven.lastName)
//        assertEquals("Address Test7", outputSeven.address)
//        assertEquals("Female", outputSeven.gender)
//
//        val outputTwelve: PersonVo = outputList[12]
//        assertEquals(12.toLong(), outputTwelve.key)
//        assertEquals("First Name Test12", outputTwelve.firstName)
//        assertEquals("Last Name Test12", outputTwelve.lastName)
//        assertEquals("Address Test12", outputTwelve.address)
//        assertEquals("Male", outputTwelve.gender)
//    }
//
//    @Test
//    fun parseVOToEntityTest() {
//
//        val output: Person = DozerMapper.parseObject(inputObject!!.mockVO(), Person::class.java)
//
//        assertEquals(0, output.key)
//        assertEquals("First Name Test0", output.firstName)
//        assertEquals("Last Name Test0", output.lastName)
//        assertEquals("Address Test0", output.address)
//        assertEquals("Male", output.gender)
//    }
//
//    @Test
//    fun parserVOListToEntityListTest() {
//
//        val outputList: ArrayList<Person> = DozerMapper.parsingListObject(inputObject!!.mockVOList(), Person::class.java)
//
//        val outputZero: Person = outputList[0]
//        assertEquals(0, outputZero.key)
//        assertEquals("First Name Test0", outputZero.firstName)
//        assertEquals("Last Name Test0", outputZero.lastName)
//        assertEquals("Address Test0", outputZero.address)
//        assertEquals("Male", outputZero.gender)
//
//        val outputSeven: Person = outputList[7]
//        assertEquals(7, outputSeven.key)
//        assertEquals("First Name Test7", outputSeven.firstName)
//        assertEquals("Last Name Test7", outputSeven.lastName)
//        assertEquals("Address Test7", outputSeven.address)
//        assertEquals("Female", outputSeven.gender)
//
//        val outputTwelve: Person = outputList[12]
//        assertEquals(12, outputTwelve.key)
//        assertEquals("First Name Test12", outputTwelve.firstName)
//        assertEquals("Last Name Test12", outputTwelve.lastName)
//        assertEquals("Address Test12", outputTwelve.address)
//        assertEquals("Male", outputTwelve.gender)
//    }
//}