package com.example.mobileappcw2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get a reference to the button
        val button = findViewById<Button>(R.id.button)

        // Set an OnClickListener to the button
        button.setOnClickListener {
            // Create an intent to start the SearchActivity
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
    }
}
