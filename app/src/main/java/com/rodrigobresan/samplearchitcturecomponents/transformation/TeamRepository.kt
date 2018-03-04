package com.rodrigobresan.samplearchitcturecomponents.transformation

import android.arch.lifecycle.MutableLiveData

object TeamRepository {
    private val teams = listOf(
            Team(1, "Manchester United", "Description for Manchester United"),
            Team(2, "Barcelona", "Description for Barcelona"),
            Team(3, "Corinthians", "Description for Corinthians"),
            Team(4, "Arsenal", "Description for Arsenal"),
            Team(5, "Palmeiras", "Description for Palmeiras")
    )

    fun getTeams() = teams

    fun getTeam(id: Long) = teams.first { it.id == id }

    fun getTeamLive(id: Long) = MutableLiveData<Team>().apply {
        value = teams.first { it.id == id }
    }
}