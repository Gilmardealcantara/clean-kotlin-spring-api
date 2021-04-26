package com.hotmart.baseapi.application.resttemplate

import com.hotmart.baseapi.usecase.base.UseCaseResponse
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.jdbc.Sql

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonControllerTest {
    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    @Test
         @Sql("/test.sql")
    fun `Should healthy`() {

//        val response: ResponseEntity<*> = restTemplate.getForEntity("/")

//        Assertions.assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
    }
}