package com.hotmart.baseapi.application.webmvc

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class HealthyController {
    @GetMapping
    fun get() = "health"
}