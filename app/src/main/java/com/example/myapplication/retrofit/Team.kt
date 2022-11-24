package com.example.myapplication.retrofit

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Team(
    @SerializedName("idTeam")
    val idTeam: Int,

    @SerializedName("idSoccerXML")
    val idSoccerXML: Int,

    @SerializedName("idAPIfootball")
    val idAPIfootball: Int,

    @SerializedName("intLoved")
    val intLoved: Int,

    @SerializedName("strTeam")
    val strTeam: String,

    @SerializedName("strTeamShort")
    val strTeamShort: String,

    @SerializedName("strAlternate")
    val strAlternate: String,

    @SerializedName("intFormedYear")
    val intFormedYear: Int,

    @SerializedName("strSport")
    val strSport: String,

    @SerializedName("strLeague")
    val strLeague: String,

    @SerializedName("idLeague")
    val idLeague: Int,

    @SerializedName("strLeague2")
    val strLeague2: String,

    @SerializedName("idLeague2")
    val idLeague2: Int,

    @SerializedName("strLeague3")
    val strLeague3: String,

    @SerializedName("idLeague3")
    val idLeague3: Int,


    @SerializedName("strDivision")
    val strDivision: String,

    @SerializedName("strManager")
    val strManager: String,

    @SerializedName("strStadium")
    val strStadium: String,

    @SerializedName("strKeywords")
    val strKeywords: String,

    @SerializedName("strTeamBadge")
    val strTeamBadge: String,


    @SerializedName("strCountry")
    val strCountry: String,


    @SerializedName("strTeamBanner")
    val strTeamBanner: String,



    @SerializedName("strDescriptionEN")
    val strDescriptionEN: String,




) : Serializable