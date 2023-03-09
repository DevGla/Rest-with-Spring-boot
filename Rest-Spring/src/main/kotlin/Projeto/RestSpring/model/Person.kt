package Projeto.RestSpring.model

// quando trabalhamos com data class, precisamos usar var por conta do JPA
data class Person (
    var id: Long = 0,
    var firstName: String = "",
    var lastName: String = "",
    var address: String = "",
    var gender: String = "",
)