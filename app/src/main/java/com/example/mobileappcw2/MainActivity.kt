package com.example.mobileappcw2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get a reference to the button
        val changingButton = findViewById<Button>(R.id.changing_button)
        val searchMealButton = findViewById<Button>(R.id.search_meals_button)
        val searchIngredientButton = findViewById<Button>(R.id.search_ingredient_button)
        val addMeal = findViewById<Button>(R.id.add_meal_button)

        // Set an OnClickListener to the button
        changingButton.setOnClickListener{
            // Create an AlertDialog to prompt the user for input
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Search Meal API")

            // Set up the input view
            val input = EditText(this)
            input.setPadding(80, 40, 80, 25)
            builder.setView(input)

            // Set up the positive button action
            builder.setPositiveButton("Search") { dialog, which ->
                // Get the user's input text
                val userInput = input.text.toString().trim()

                // Create an intent to start the SearchActivity
                val intent = Intent(this, SearchActivity::class.java)
                intent.putExtra("search_query", userInput) // Pass the input text to the SearchActivity
                startActivity(intent)
            }

            // Set up the negative button action
            builder.setNegativeButton("Cancel") { dialog, which ->
                // Do nothing, simply dismiss the dialog
                dialog.dismiss()
            }

            // Display the AlertDialog
            builder.show()
        }
        searchMealButton.setOnClickListener {
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
