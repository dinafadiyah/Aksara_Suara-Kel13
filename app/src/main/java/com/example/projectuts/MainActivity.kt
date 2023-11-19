package com.example.projectuts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.ImageView
import androidx.cardview.widget.CardView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardViewAlbum: CardView = findViewById(R.id.CardViewAlbum)
        val cardViewLightstick: CardView = findViewById(R.id.CardViewLightstick)


        // Set click listener for Album CardView
        cardViewAlbum.setOnClickListener {
            // Handle the click event for the album
            startActivity(Intent(this@MainActivity, AlbumActivity::class.java))
        }

        // Set click listener for Lightstick CardView
        cardViewLightstick.setOnClickListener {
            // Handle the click event for the lightstick
            startActivity(Intent(this@MainActivity, LightstickActivity::class.java))
        }

        // Find the Jisoo ImageView by ID
        val jisooImageView: ImageView = findViewById(R.id.jisooImageView)

        // Set a click listener for the Jisoo ImageView
        jisooImageView.setOnClickListener {
            // Explicitly navigate to the AboutUsActivity (change this to your desired activity)
            val intent = Intent(this@MainActivity, AboutUsActivity::class.java)
            startActivity(intent)
        }
    }



}