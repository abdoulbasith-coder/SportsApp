package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.retrofit.Team
import com.squareup.picasso.Picasso

class TeamDetailActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)

        val team: Team = intent.getSerializableExtra(Constants.TEAM_OBJECT_EXTRA) as Team

        val banner = findViewById<ImageView>(R.id.img_banner)
        val country = findViewById<TextView>(R.id.txt_country)
        val league = findViewById<TextView>(R.id.txt_league)
        val description = findViewById<TextView>(R.id.txt_description)

        Picasso.get()
            .load(team.strTeamBanner)
            .into(banner)

        country.text = team.strCountry
        league.text = team.strLeague
        description.text = team.strDescriptionEN

    }

}