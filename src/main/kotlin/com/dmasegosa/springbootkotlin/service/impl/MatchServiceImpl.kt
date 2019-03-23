package com.dmasegosa.springbootkotlin.service.impl

import com.dmasegosa.springbootkotlin.model.Match
import com.dmasegosa.springbootkotlin.repository.MatchRepository
import com.dmasegosa.springbootkotlin.service.MatchService
import org.springframework.stereotype.Service

@Service
class MatchServiceImpl(
   val matchRepository: MatchRepository
): MatchService {

    override fun insertMatchData(match: Match): Match {
        return matchRepository.save(match)
    }

    override fun getMatchData(): List<Match> {
        return matchRepository.findAll()
    }
}