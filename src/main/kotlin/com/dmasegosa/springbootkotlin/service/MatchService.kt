package com.dmasegosa.springbootkotlin.service

import com.dmasegosa.springbootkotlin.model.Match

interface MatchService {
    fun insertMatchData(match: Match): Match
    fun getMatchData(): List<Match>
}
