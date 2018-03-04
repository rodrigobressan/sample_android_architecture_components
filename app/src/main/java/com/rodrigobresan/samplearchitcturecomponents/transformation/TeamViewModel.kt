package com.rodrigobresan.samplearchitcturecomponents.transformation

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel

class TeamViewModel : ViewModel() {

    private var teams : MutableLiveData<List<Team>> = MutableLiveData()
    private var teamId : MutableLiveData<Long> = MutableLiveData()

    private var team: LiveData<Team>

    init {
        teams.value = TeamRepository.getTeams()

        team = Transformations.switchMap(teamId) {
            TeamRepository.getTeamLive(it)
        }
    }

    fun getTeams() = teams

    fun setTeam(id: Long) {
        teamId.value = id
    }

    fun getTeam() = team
}