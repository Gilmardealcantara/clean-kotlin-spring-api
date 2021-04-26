package com.hotmart.baseapi.application.automockmvc

import com.fasterxml.jackson.databind.ObjectMapper
import com.hotmart.baseapi.domain.entity.Person
import com.hotmart.baseapi.repository.data.PersonDataMapper
import com.hotmart.baseapi.repository.person.PersonSpringDataRepository
import com.hotmart.baseapi.usecase.person.request.CreatePersonRequest
import io.mockk.every
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.util.*


@SpringBootTest
@AutoConfigureMockMvc
internal class PersonControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var personSpringDataRepository: PersonSpringDataRepository

    @Test
    fun `Should get person`() {

        personSpringDataRepository.save(PersonDataMapper(UUID.randomUUID(), "Person"))

        val request = MockMvcRequestBuilders.get("/persons")
        mockMvc.perform(request)
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.*").isNotEmpty)
    }

    @Test
    fun `Should post person`() {

        val request = MockMvcRequestBuilders.post("/persons")
            .content(ObjectMapper().writeValueAsString(CreatePersonRequest("new person")))
            .contentType(MediaType.APPLICATION_JSON)

        mockMvc.perform(request)
            .andDo(print())
            .andExpect(status().isCreated)
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("new person"))
    }
}