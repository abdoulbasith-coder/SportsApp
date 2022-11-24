package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.retrofit.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var mLeagues: MutableList<League> = ArrayList()
    private lateinit var progress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progress = findViewById(R.id.progress)

        //Recyclerview
        val recyclerView: RecyclerView = findViewById(R.id.recycler_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = LeagueAdapter(this, mLeagues, LeagueAdapter.OnClickListener { league ->

            val intent = Intent(this, TeamListActivity::class.java)
            intent.putExtra(Constants.LEAGUE_EXTRA, league.leagueName)

            startActivity(intent)

        })
        recyclerView.adapter = adapter

        //Retrofit
        val retrofitInterface: RetrofitInterface = RetrofitClient.getClient().create(
            RetrofitInterface::class.java)

        val call: Call<LeagueList> = retrofitInterface.fetchLeagues()
        call.enqueue(object : Callback<LeagueList>{
            override fun onResponse(call: Call<LeagueList>, response: Response<LeagueList>) {
                progress.visibility = GONE

                val leagueList: MutableList<League> = response.body()?.items!!

                mLeagues.addAll(leagueList)

                adapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<LeagueList>, t: Throwable) {
                progress.visibility = GONE
                Log.d("retrofit", t.toString())
            }
        })
    }
}