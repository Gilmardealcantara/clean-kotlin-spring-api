package com.hotmart.baseapi.application.resttemplate

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HealthControllerTest {
    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    @Test
    fun `Should healthy`() {
        val response: ResponseEntity<String> = restTemplate.getForEntity("/", String::class.java)

        Assertions.assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        Assertions.assertThat(response.body).isEqualTo("health")
    }
}