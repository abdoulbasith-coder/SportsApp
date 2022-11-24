package com.example.myapplication.retrofit

import com.google.gson.annotations.SerializedName

class TeamList {

    @SerializedName("teams")
    val teams: MutableList<Team> = ArrayList()
}