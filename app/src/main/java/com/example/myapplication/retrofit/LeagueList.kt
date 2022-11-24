package com.example.myapplication.retrofit

import com.google.gson.annotations.SerializedName

class LeagueList {
    @SerializedName("leagues")
    val items: MutableList<League> = ArrayList()
}