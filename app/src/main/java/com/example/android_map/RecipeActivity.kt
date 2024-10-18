package com.example.android_map
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import java.io.InputStreamReader
import kotlin.random.Random


class RecipeActivity: AppCompatActivity() {
    private lateinit var recipes: List<Recipe>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)
        enableEdgeToEdge()
        supportActionBar?.title="Pick an Option"
        loadRecipes()
        val proteinButton = findViewById<Button>(R.id.button_protein);
        val vegetarianButton=findViewById<Button>(R.id.button_vege)
        val desertButton=findViewById<Button>(R.id.button_desert)



        proteinButton.setOnClickListener {
            val randomRecipe = getRandomProteinRecipe()
            randomRecipe?.let {
                val formmateddirections=it.directions.replace("[","")
                    .replace("]", "")  // Remove closing bracket
                    .replace("'", "")  

                val formmatedingredients=it.ingredients.replace("[","")
                    .replace("]", "")  // Remove closing bracket
                    .replace("'", "")  


                val intent = Intent(
                    this@RecipeActivity,
                    RecipeActivityList::class.java
                )
                intent.putExtra("category", "P")
                intent.putExtra("title", it.title)
                intent.putExtra("directions", formmateddirections)
                intent.putExtra("ingredients", formmatedingredients)
                intent.putExtra("calories", it.calories)
                startActivity(intent)

            }


        }
        vegetarianButton.setOnClickListener {
            val randomRecipe = getRandomVegetarianRecipe()
            randomRecipe?.let {
                val formmateddirections=it.directions.replace("[","")
                    .replace("]", "")  // Remove closing bracket
                    .replace("'", "")  

                val formmatedingredients=it.ingredients.replace("[","")
                    .replace("]", "")  // Remove closing bracket
                    .replace("'", "")  


                val intent = Intent(
                    this@RecipeActivity,
                    RecipeActivityList::class.java
                )
                intent.putExtra("category", "V")
                intent.putExtra("title", it.title)
                intent.putExtra("directions", formmateddirections)
                intent.putExtra("ingredients", formmatedingredients)
                intent.putExtra("calories", it.calories)
                startActivity(intent)

            }


        }

        desertButton.setOnClickListener {
            val randomRecipe = getRandomDesertRecipe()
            randomRecipe?.let {
                val formmateddirections=it.directions.replace("[","")
                    .replace("]", "")  // Remove closing bracket
                    .replace("'", "")  

                val formmatedingredients=it.ingredients.replace("[","")
                    .replace("]", "")  // Remove closing bracket
                    .replace("'", "")  


                val intent = Intent(
                    this@RecipeActivity,
                    RecipeActivityList::class.java
                )
                intent.putExtra("category", "D")
                intent.putExtra("title", it.title)
                intent.putExtra("directions", formmateddirections)
                intent.putExtra("ingredients", formmatedingredients)
                intent.putExtra("calories", it.calories)
                startActivity(intent)

            }


        }


    }

    private fun loadRecipes() {
        // Load recipes from JSON file
        val inputStream = assets.open("finalRecipes.json") 
        val reader = InputStreamReader(inputStream)
        val type = object : TypeToken<List<Recipe>>() {}.type
        recipes = Gson().fromJson(reader, type)
        reader.close()
    }

    private fun getRandomProteinRecipe(): Recipe? {
        // Filter protein recipes and return a random one
        val proteinRecipes = recipes.filter { it.category == "P" }
        return if (proteinRecipes.isNotEmpty()) {
            proteinRecipes[Random.nextInt(proteinRecipes.size)]
        } else {
            null
        }
    }
    private fun getRandomVegetarianRecipe(): Recipe? {
        // Filter veg recipes and return a random one
        val vegetarianRecipes = recipes.filter { it.category == "V" }
        return if (vegetarianRecipes.isNotEmpty()) {
            vegetarianRecipes[Random.nextInt(vegetarianRecipes.size)]
        } else {
            null
        }
    }
    private fun getRandomDesertRecipe(): Recipe? {
        // Filter  dessert recipes and return a random one
        val desertrecipe = recipes.filter { it.category == "D" }
        return if (desertrecipe.isNotEmpty()) {
            desertrecipe[Random.nextInt(desertrecipe.size)]
        } else {
            null
        }
    }

}