package com.dmasegosa.springbootkotlin.publisher

import com.dmasegosa.springbootkotlin.model.Player
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.listener.ChannelTopic
import org.springframework.stereotype.Component

@Component
class RedisMessagePublisher(
    private val redisTemplate: RedisTemplate<String, Any>,
    private val topic: ChannelTopic
): MessagePublisher {

    override fun publish(messagePublisher: Player) {
        redisTemplate.convertAndSend(topic.topic, messagePublisher)
    }
}