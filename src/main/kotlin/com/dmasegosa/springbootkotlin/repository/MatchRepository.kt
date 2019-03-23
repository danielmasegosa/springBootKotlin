package com.dmasegosa.springbootkotlin.repository

import com.dmasegosa.springbootkotlin.model.Match
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MatchRepository: MongoRepository<Match, String>