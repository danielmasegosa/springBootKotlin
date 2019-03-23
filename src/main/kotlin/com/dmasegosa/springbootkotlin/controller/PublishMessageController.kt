package com.dmasegosa.springbootkotlin.controller

import com.dmasegosa.springbootkotlin.model.Player
import com.dmasegosa.springbootkotlin.service.PublishMessageService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/publish")
class PublishMessageController(
    val publishMessageService: PublishMessageService
) {

    @PostMapping
    fun publishMessage(@RequestBody message: Player): ResponseEntity<Any> {
        publishMessageService.publishMessage(message)
        return ResponseEntity(HttpStatus.ACCEPTED)
    }
}