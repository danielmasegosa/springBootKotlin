package com.dmasegosa.springbootkotlin.controller

import com.dmasegosa.springbootkotlin.model.Match
import com.dmasegosa.springbootkotlin.service.MatchService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/match")
class MatchController(
    val matchService: MatchService
) {

    @PostMapping
    fun insertMatch(@RequestBody match: Match): ResponseEntity<Match> {
        val insertedMatchData = matchService.insertMatchData(match)
        return ResponseEntity(insertedMatchData, HttpStatus.CREATED)
    }

    @GetMapping
    fun getMatches(): ResponseEntity<List<Match>> {
        val matches = matchService.getMatchData()
        return ResponseEntity(matches, HttpStatus.OK)
    }
}