package za.co.varsitycollege.test

import android.content.Intent
import android.health.connect.datatypes.MealType
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val mealInput = findViewById<EditText>(R.id.mealInput)
        val recommendButton = findViewById<Button>(R.id.recommendButton)
        val resetButton = findViewById<Button>(R.id.resetButton)

        recommendButton.setOnClickListener {
            val mealType = mealInput.text.toString().trim().lowercase()
            if (mealType.isBlank()){
                Toast.makeText(this, "Please enter a meal type", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val validMeal = listOf("breakfast","lunch","snack","dinner")

            if(mealType in validMeal){
                val intent= Intent(this,MealDetails::class.java)
                intent.putExtra("MEAL_TYPE", mealType)
                startActivity(intent)

            } else {
                Toast.makeText(this,"Invalid meal type. Use breakfast, lunch, snack or dinner", Toast.LENGTH_SHORT).show()
            }
            }
        resetButton.setOnClickListener {
            mealInput.text.clear()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}