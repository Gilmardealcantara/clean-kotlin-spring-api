package com.hotmart.baseapi.application.di

import com.hotmart.baseapi.usecase.person.GetAllPersonsUseCase
import com.hotmart.baseapi.usecase.person.IGetAllPersonsUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PersonBeanDefinition {
    @Bean
    fun getAllPersonsUseCase(): IGetAllPersonsUseCase = GetAllPersonsUseCase()
}