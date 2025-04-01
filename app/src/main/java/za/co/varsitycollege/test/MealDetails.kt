package za.co.varsitycollege.test

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MealDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_meal_details)
        val MealTextView = findViewById<TextView>(R.id.MealTextView)
        val mealType = intent.getStringExtra("MEAL_TYPE")?: "Unknown"

        val mealSuggestion = when (mealType){
            "breakfast" -> " Avocado Toast or Omelettes"
            "lunch" -> "Burger and fries or Chicken Wrap"
            "snack" -> "Fruit salad or Grilled Cheese"
            "dinner" -> "Roasted Chicken or Spaghetti Bolognese"
            else -> "Invalid meal Type. Please breakfast',lunch',snack',dinner'"
        }
        MealTextView.text = "Recommend Meal for $mealType:\n$mealSuggestion"

        val backButton = findViewById<Button>(R.id.backButton)

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}