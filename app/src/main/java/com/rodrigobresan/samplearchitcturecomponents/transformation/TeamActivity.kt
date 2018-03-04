package com.rodrigobresan.samplearchitcturecomponents.transformation

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.rodrigobresan.samplearchitcturecomponents.R
import kotlinx.android.synthetic.main.activity_team.*

class TeamActivity : AppCompatActivity() {

    companion object {
        fun provideIntent(context: Context): Intent {
            val intent = Intent(context, TeamActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_team)

        val teamAdapter = TeamAdapter { team ->
            val intentDetail = TeamDetailActivity.provideIntent(this, team.id)
            startActivity(intentDetail)
        }

        rv_teams.layoutManager = LinearLayoutManager(this)
        rv_teams.adapter = teamAdapter

        val teamViewModel = ViewModelProviders.of(this).get(TeamViewModel::class.java)
        teamViewModel.getTeams().observe(this, Observer {
            teamAdapter.swapTeams(it!!)
        })
    }
}