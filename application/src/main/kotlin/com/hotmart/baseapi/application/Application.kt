package com.hotmart.baseapi.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.hotmart.baseapi.application", "com.hotmart.baseapi.repository", "com.hotmart.baseapi.usecase"])
open class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}