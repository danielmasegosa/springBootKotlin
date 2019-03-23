package com.dmasegosa.springbootkotlin.repository

import com.dmasegosa.springbootkotlin.model.Player
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository: MongoRepository<Player, String>