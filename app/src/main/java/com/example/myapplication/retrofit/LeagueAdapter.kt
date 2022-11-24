package com.example.myapplication.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R


class LeagueAdapter(context: Context, data: MutableList<League>, private val onClickListener: OnClickListener) : RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {

    var mData: MutableList<League> = data
    var mInflater: LayoutInflater =  LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = mInflater.inflate(R.layout.league_row_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val league = mData[position]
        holder.myTextView.text = league.leagueName
        holder.myTextView.setOnClickListener{
            onClickListener.onClick(league)
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

   public class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var myTextView: TextView

        init {
            myTextView = itemView.findViewById(R.id.txt_league)
        }
    }

    class OnClickListener(val clickListener: (league: League) -> Unit) {
        fun onClick(league: League) = clickListener(league)
    }
}