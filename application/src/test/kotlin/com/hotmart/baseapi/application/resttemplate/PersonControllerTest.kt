package com.hotmart.baseapi.application.resttemplate

import com.hotmart.baseapi.usecase.person.request.CreatePersonRequest
import com.hotmart.baseapi.usecase.person.response.PersonResponse
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.jdbc.Sql

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonControllerTest {
    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    @Test
    @Sql("/test.sql")
    fun `Should get persons`() {
        val response: ResponseEntity<List<*>> = restTemplate.getForEntity("/persons", List::class.java)

        Assertions.assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        Assertions.assertThat(response.body).hasSize(3)

//        val data = ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(response.body)
//        println(data)
    }

    @Test
    fun `Should post person`() {
        val person = CreatePersonRequest("Gilmar")
        val entity = HttpEntity<CreatePersonRequest>(person)

        val response: ResponseEntity<PersonResponse> =
            restTemplate.postForEntity("/persons", entity, PersonResponse::class.java)

        Assertions.assertThat(response.statusCode).isEqualTo(HttpStatus.CREATED)
        Assertions.assertThat(response.body)
            .hasFieldOrProperty("id")
            .hasFieldOrPropertyWithValue("name", "Gilmar")
    }
}