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
        val searchMealButton = findViewById<Button>(R.id.search_meals_button)
        val searchIngredientButton = findViewById<Button>(R.id.search_ingredient_button)
        val addMeal = findViewById<Button>(R.id.add_meal_button)

        // Set an OnClickListener to the button
        searchMealButton.setOnClickListener {
            // Create an intent to start the SearchActivity
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        searchIngredientButton.setOnClickListener{
            val intent = Intent (this, SearchActivity::class.java)
            startActivity(intent)
        }

        addMeal.setOnClickListener{
            val intent = Intent (this, SearchActivity::class.java)
            startActivity(intent)
        }
    }
}
