package com.rodrigobresan.samplearchitcturecomponents.transformation

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rodrigobresan.samplearchitcturecomponents.R
import kotlinx.android.synthetic.main.item_team.view.*

class TeamAdapter(private val listener: (Team) -> Unit) : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    lateinit var teamList: List<Team>

    fun swapTeams(teams: List<Team>) {
        this.teamList = teams
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return teamList.size
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(teamList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_team, parent, false)
        return TeamViewHolder(listener, view)
    }

    class TeamViewHolder(private val listener: (Team) -> Unit, itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Team) = with(itemView) {
            txt_item_team_name.text = item.name
            setOnClickListener { listener(item) }
        }
    }

}