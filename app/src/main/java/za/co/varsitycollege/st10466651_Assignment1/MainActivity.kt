package za.co.varsitycollege.st10466651_Assignment1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//import za.co.varsitycollege.st10466651_Assignment1.R

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        // this is an array for Breakfast
        val breakfast = arrayOf("Eggs and Bacon",
            "Muesli",
            "Cereal",
            "Avo and Toast",
            "Pancakes",
            "Croissant",
            "Muffin and a Coffee",
            "French Toast",
            "Breakfast Burrito",
            "Bagel and Cream Cheese",
            "Omelette",
            "Waffle",
            "Hash browns and Eggs",
            "Breakfast sandwich")

        // this is an array for Mid-Morning
        val midmorning = arrayOf("Fruit Salad",
            "Smoothie",
            "Yogurt",
            "Muffin",
            "Toast",
            "French Toast",
            "Breakfast Burrito",
            "Bagel and Cream Cheese",
            "Omelette",
            "Waffle",
            "Hash browns and Eggs",
            "Breakfast sandwich")

        // this is an array for Lunch
        val lunch = arrayOf("Egg Mayo Sandwich",
            "Wrap",
            "Toasted Cheese",
            "Green Salad",
            "Pizza",
            "Sloppy Joe",
            "Ramen noodles",
            "Grilled Cheese",
            "Chicken Pesto Wraps",
            "Chicken Salad",
            "Tuna Melt on Cornbread",
            "Open-Faced Pizza Burgers",
            "Indian Spiced Chickpea Wrap",
            "Southern Pork Salad",
            "Chicken and Onion Caesar Salad")

        // this is an array for Mid-Afternoon
        val midafternoon = arrayOf("Yogurt and Grapes",
            "Celery and Carrot Sticks",
            "Cookies",
            "Nuts",
            "Wrap",
            "Toasted Cheese",
            "Green Salad",
            "Pizza",
            "Sloppy Joe",
            "Ramen noodles",
            "Grilled Cheese")

        // this is an array for Dinner
        val dinner = arrayOf("Steak and Wine",
            "Seafood Pasta",
            "Burger and Chips",
            "Lobster",
            "Mac and Cheese",
            "Soup",
            "Lasagne",
            "Pizza",
            "Wrap",
            "Chicken and Chips",
            "Hake and Rice",
            "Chicken Potpie",
            "Chicken Casserole",
            "Hungarian Chicken Paprikash",
            "Shrimp Quesadilla",
            "Shepherd's Pie",
            "Ground Turkey Vegetable Soup",
            "Meatballs",
            "Crockpot Spareribs")

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // get the reset button
        val reset = findViewById<Button>(R.id.reset)
        // get the tips button
        val tips = findViewById<Button>(R.id.tips)
        // get the names text view
        //val names = findViewById<TextView>(R.id.textName)
        // get the meals text view
        val meals = findViewById<TextView>(R.id.textMeals)
        // get the time edit text view
        val time = findViewById<EditText>(R.id.textTime)
        // get the suggestion text view
        val suggestionTime = findViewById<TextView>(R.id.timeSuggestion)


        reset?.setOnClickListener {
            meals.text = ""
            time.text.clear()
            suggestionTime.text = ""
        }

        tips?.setOnClickListener {
            val timeOfDay = time.text.toString().trim().lowercase()
            val validTimeOfDay = listOf("breakfast","Breakfast", "mid-morning","Mid-morning",
                "lunch", "Lunch", "mid-afternoon", "Mid-afternoon", "dinner", "Dinner")
            var counter = 1

            if (timeOfDay.isEmpty() || !validTimeOfDay.contains(timeOfDay)) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Input Required")
                builder.setMessage("Please enter a valid time of day (e.g. breakfast, mid-morning, lunch, mid-afternoon, dinner)")
                builder.setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
                builder.create().show()

                suggestionTime.text = "Please enter a time of day!"
                return@setOnClickListener
            }

            if (time.text.toString() == "mid-morning") {
                meals.text = "Mid-Morning Dishes:\n\n"
                repeat(3) {
                    // Randomize the array
                    val randomizedArray = midmorning.random()
                    // Print the randomized array
                    meals.append("$counter" + ". " + "$randomizedArray\n")
                    counter++
                }
            }

            if (time.text.toString() == "breakfast") {
                meals.text = "Breakfast Dishes:\n\n"
                repeat(3) {
                    // Randomize the array
                    val randomizedArray = breakfast.random()
                    // Print the randomized array
                    meals.append("$counter" + ". " + "$randomizedArray\n")
                    counter++
                }
            }

            if (time.text.toString() == "lunch" ) {
                meals.text = "Lunch Dishes:\n\n"
                repeat(3) {
                    // Randomize the array
                    val randomizedArray = lunch.random()
                    // Print the randomized array
                    meals.append("$counter" + ". " + "$randomizedArray\n")
                    counter++
                }
            }

            if (time.text.toString() == "mid-afternoon" ) {
                meals.text = "Mid-Afternoon Dishes:\n\n"
                repeat(3) {
                    // Randomize the array
                    val randomizedArray = midafternoon.random()
                    // Print the randomized array
                    meals.append("$counter" + ". " + "$randomizedArray\n")
                    counter++
                }
            }

            if (time.text.toString() == "dinner" ) {
                meals.text = "Dinner Dishes:\n\n"
                repeat(3) {
                    // Randomize the array
                    val randomizedArray = dinner.random()
                    // Print the randomized array
                    meals.append("$counter" + ". " + "$randomizedArray\n")
                    counter++
                }
            }
        }
    }
}