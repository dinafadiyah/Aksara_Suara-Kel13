package com.example.projectuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

class AboutUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

        val toolbar: Toolbar = findViewById(R.id.toolbaraboutus)
        setSupportActionBar(toolbar)

        // Set the click listener for the navigation icon
        toolbar.setNavigationOnClickListener {
            // Handle the click event
            val intent = Intent(this@AboutUsActivity, MainActivity::class.java)
            startActivity(intent)
            finish() // Optional: finish the current activity
        }
    }
}