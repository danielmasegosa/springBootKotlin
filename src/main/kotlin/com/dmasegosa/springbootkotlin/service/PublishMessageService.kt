package com.dmasegosa.springbootkotlin.service

import com.dmasegosa.springbootkotlin.model.Player

interface PublishMessageService {
    fun publishMessage(message: Player)
}