package com.rodrigobresan.samplearchitcturecomponents.transformation

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rodrigobresan.samplearchitcturecomponents.R
import kotlinx.android.synthetic.main.activity_team_detail.*

class TeamDetailActivity : AppCompatActivity() {

    companion object {
        fun provideIntent(context: Context, teamId: Long): Intent {
            val intent = Intent(context, TeamDetailActivity::class.java)
            intent.putExtra("id", teamId)

            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_team_detail)

        val teamId = intent.getLongExtra("id", 0)

        val teamViewModel = ViewModelProviders.of(this).get(TeamViewModel::class.java)

        teamViewModel.setTeam(teamId)
        teamViewModel.getTeam().observe(this, Observer {
            txt_team_detail_description.text = it?.description
        })
    }
}