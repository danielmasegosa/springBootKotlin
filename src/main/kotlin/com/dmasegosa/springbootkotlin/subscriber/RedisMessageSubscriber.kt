package com.dmasegosa.springbootkotlin.subscriber

import com.dmasegosa.springbootkotlin.model.Player
import com.dmasegosa.springbootkotlin.repository.PlayerRepository
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.connection.MessageListener

class RedisMessageSubscriber(
    val playerRepository: PlayerRepository
): MessageListener {

    private val objectMapper = jacksonObjectMapper()

    override fun onMessage(message: Message, pattern: ByteArray?) {
        val player: Player = objectMapper.readValue(message.toString())
        playerRepository.save(player)
    }
}