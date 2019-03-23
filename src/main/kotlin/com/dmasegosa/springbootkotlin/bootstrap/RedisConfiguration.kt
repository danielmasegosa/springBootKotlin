package com.dmasegosa.springbootkotlin.bootstrap

import com.dmasegosa.springbootkotlin.publisher.MessagePublisher
import com.dmasegosa.springbootkotlin.publisher.RedisMessagePublisher
import com.dmasegosa.springbootkotlin.repository.PlayerRepository
import com.dmasegosa.springbootkotlin.subscriber.RedisMessageSubscriber
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.listener.ChannelTopic
import org.springframework.data.redis.listener.RedisMessageListenerContainer
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer



@Configuration
class RedisConfiguration {

    @Bean
    fun jedisConnectionFactory(): JedisConnectionFactory {
        return JedisConnectionFactory();
    }

    @Bean
    fun redisTemplate(): RedisTemplate<String, Any> {
        val template = RedisTemplate<String, Any>()
        template.setConnectionFactory(jedisConnectionFactory())
        template.setDefaultSerializer(GenericJackson2JsonRedisSerializer())
        return template
    }

    @Bean
    fun messageListener(playerRepository: PlayerRepository): MessageListenerAdapter {
        return MessageListenerAdapter(RedisMessageSubscriber(playerRepository))
    }

    @Bean
    fun redisContainer(playerRepository: PlayerRepository): RedisMessageListenerContainer {
        val container = RedisMessageListenerContainer()
        container.setConnectionFactory(jedisConnectionFactory())
        container.addMessageListener(messageListener(playerRepository), topic())
        return container
    }

    @Bean
    fun redisPublisher(): MessagePublisher {
        return RedisMessagePublisher(redisTemplate(), topic())
    }

    @Bean
    fun topic(): ChannelTopic {
        return ChannelTopic("messageQueue")
    }
}