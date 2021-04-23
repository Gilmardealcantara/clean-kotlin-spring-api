package com.hotmart.baseapi.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
//@ComponentScan(basePackages = ["com.hotmart.baseapi.repository", "com.hotmart.baseapi.usecase", "com.hotmart.baseapi.application"])
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}