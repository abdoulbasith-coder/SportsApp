package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.retrofit.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamListActivity : AppCompatActivity() {

    private var mTeams: MutableList<Team> = ArrayList()
    private lateinit var progress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_list)

        progress = findViewById(R.id.progress_team_list)

        val teamName = intent.getStringExtra(Constants.LEAGUE_EXTRA).toString()


        //Recycler
        val recyclerView: RecyclerView = findViewById(R.id.recycler_list_team)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val adapter = TeamAdapter(this, mTeams, TeamAdapter.OnClickListener{ team ->

            val intent = Intent(this, TeamDetailActivity::class.java)
            intent.putExtra(Constants.TEAM_OBJECT_EXTRA, team)

            startActivity(intent)
        })
        recyclerView.adapter = adapter

        //Retrofit
        val retrofitInterface: RetrofitInterface = RetrofitClient.getClient().create(
            RetrofitInterface::class.java)

        val call: Call<TeamList> = retrofitInterface.fetchTeams(teamName)
        call.enqueue(object : Callback<TeamList>{
            override fun onResponse(call: Call<TeamList>, response: Response<TeamList>) {
                progress.visibility = View.GONE

                val teamList: MutableList<Team> = response.body()?.teams!!

                mTeams.addAll(teamList)
                adapter.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<TeamList>, t: Throwable) {
                progress.visibility = View.GONE

            }

        })
    }
}