package br.projto.demo.data.vo.v1

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.github.dozermapper.core.Mapping
import org.springframework.hateoas.RepresentationModel

//@JsonPropertyOrder("id", "address", "first_name", "last_name", "gender")
// usada quando queremos mudar a sequeência dos dados retornados
data class PersonVo (
    @Mapping("id")
    var key: Long = 0,
    var firstName: String = "",
    // @field:JsonProperty("last_name")
    // usado quando queremos mdudar o nome de exibição do dado retornado
    var lastName: String = "",
    var address: String = "",
//    @field:JsonIgnore
    // usado quando queremos não mostrar o dado retornado
    var gender: String = ""
) : RepresentationModel<PersonVo>()