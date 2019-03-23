package com.dmasegosa.springbootkotlin.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("matches")
data class Match(
    @Id
    val id: String?,
    val player1: Player,
    val player2: Player
)

data class Player(
    @Id
    val id: String?,
    val name: String,
    val score: Int
)