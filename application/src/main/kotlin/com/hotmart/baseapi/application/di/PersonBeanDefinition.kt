package com.hotmart.baseapi.application.di

import com.hotmart.baseapi.domain.service.IPersonRepository
import com.hotmart.baseapi.usecase.person.GetAllPersonsUseCase
import com.hotmart.baseapi.usecase.person.IGetAllPersonsUseCase
import com.hotmart.repository.person.PersonRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PersonBeanDefinition {

//    @Bean
//    fun getAllPersonsUseCase(): IGetAllPersonsUseCase {
//        return GetAllPersonsUseCase(PersonRepository())
//    }
}