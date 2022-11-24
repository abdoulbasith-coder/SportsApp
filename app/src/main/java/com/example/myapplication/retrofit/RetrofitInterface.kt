package com.example.myapplication.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {

    @GET("all_leagues.php")
    fun fetchLeagues(): Call<LeagueList>

    @GET("search_all_teams.php")
    fun fetchTeams(@Query("l") league: String) : Call<TeamList>
}