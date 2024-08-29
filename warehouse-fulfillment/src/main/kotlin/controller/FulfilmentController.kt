package org.jesperancinha.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class FulfilmentController {

    @GetMapping
    fun getItems() = (1..10).map { Thread.sleep(1000) }
}