package com.example.myapplication.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.squareup.picasso.Picasso

class TeamAdapter(context: Context, data: MutableList<Team>, private val onClickListener: TeamAdapter.OnClickListener) : RecyclerView.Adapter<TeamAdapter.ViewHolder>()  {

    var mData: MutableList<Team> = data
    var mInflater: LayoutInflater =  LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamAdapter.ViewHolder {
        val view: View = mInflater.inflate(R.layout.team_row_layout, parent, false)
        return TeamAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamAdapter.ViewHolder, position: Int) {
        val team = mData[position]

        Picasso.get()
            .load(team.strTeamBadge)
            .into(holder.badge)
        holder.badge.setOnClickListener{
            onClickListener.onClick(team)
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }


    public class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var badge: ImageView

        init {
            badge = itemView.findViewById(R.id.img_team_badge)
        }
    }

    class OnClickListener(val clickListener: (team: Team) -> Unit) {
        fun onClick(team: Team) = clickListener(team)
    }
}