package com.hotmart.baseapi.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories("com.hotmart.baseapi.repository")
@EntityScan("com.hotmart.baseapi.data")
@ComponentScan(basePackages = [
    "com.hotmart.baseapi.application",
    "com.hotmart.baseapi.usecase",
    "com.hotmart.baseapi.repository",
])
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
