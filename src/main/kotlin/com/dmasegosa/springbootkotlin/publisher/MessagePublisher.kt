package com.dmasegosa.springbootkotlin.publisher

import com.dmasegosa.springbootkotlin.model.Player

interface MessagePublisher {
    fun publish(messagePublisher: Player)
}