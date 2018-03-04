package com.rodrigobresan.samplearchitcturecomponents.transformation

import android.arch.lifecycle.*

class TeamViewModel : ViewModel() {

    private var teams : MutableLiveData<List<Team>> = MutableLiveData()
    private var teamId : MutableLiveData<Long> = MutableLiveData()

    private var team: MediatorLiveData<Team> = MediatorLiveData()

    init {
        teams.value = TeamRepository.getTeams()

        team.addSource(teamId) {
            team.value = TeamRepository.getTeam(it!!)
            team.removeSource(teamId)
        }
    }

    fun getTeams() = teams

    fun setTeam(id: Long) {
        teamId.value = id
    }

    fun getTeam() = team
}