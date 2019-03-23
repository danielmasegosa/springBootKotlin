package com.dmasegosa.springbootkotlin.service.impl

import com.dmasegosa.springbootkotlin.model.Player
import com.dmasegosa.springbootkotlin.publisher.RedisMessagePublisher
import com.dmasegosa.springbootkotlin.service.PublishMessageService
import org.springframework.stereotype.Service

@Service
class PublishMessageServiceImpl(
    val redisMessagePublisher: RedisMessagePublisher
): PublishMessageService {

    override fun publishMessage(message: Player) {
        redisMessagePublisher.publish(message)
    }
}