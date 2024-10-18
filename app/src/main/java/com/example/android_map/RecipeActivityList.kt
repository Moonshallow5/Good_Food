package com.example.android_map
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class RecipeActivityList:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        // Get the recipe details from the intent
        val title = intent.getStringExtra("title")
        val ingredients = intent.getStringExtra("ingredients")
        val directions = intent.getStringExtra("directions")
        val calories = intent.getStringExtra("calories")

        val titleTextView = findViewById<TextView>(R.id.recipeTitle)
        val directionsTextView = findViewById<TextView>(R.id.recipeDirections)
        val ingredientsTextView = findViewById<TextView>(R.id.recipeIngredients)
        val caloriesTextView = findViewById<TextView>(R.id.recipeCalories)

        titleTextView.text = title
        directionsTextView.text = directions
        ingredientsTextView.text = ingredients
        caloriesTextView.text = "Calories: $calories"



    }
}