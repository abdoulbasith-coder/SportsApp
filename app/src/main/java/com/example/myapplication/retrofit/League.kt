package com.example.myapplication.retrofit

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class League(
    @SerializedName("idLeague")
    val idLeague: Int,

    @SerializedName("strLeague")
    val leagueName: String,

    @SerializedName("strSport")
    val sportName: String,

    @SerializedName("strLeagueAlternate")
    val alternateLeagueName: String
) : Serializable
