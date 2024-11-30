package hdse.kuhdse233f21.unitconverter

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val conversionOptions = arrayOf("Distance (Km to M)", "Temperature (F to C)", "Weight (G to Kg)")
        val spinner: Spinner = findViewById(R.id.spinner)
        val inputField: EditText = findViewById(R.id.inputField)
        val resultField: TextView = findViewById(R.id.resultField)
        val convertButton: Button = findViewById(R.id.calculateButton)

        // Populate Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, conversionOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        convertButton.setOnClickListener {
            val inputValue = inputField.text.toString()
            if (inputValue.isNotEmpty()) {
                val result = when (spinner.selectedItem.toString()) {
                    "Distance (Km to M)" -> convertKmToM(inputValue.toDouble())
                    "Temperature (F to C)" -> convertFahrenheitToCelsius(inputValue.toDouble())
                    "Weight (G to Kg)" -> convertGramsToKg(inputValue.toDouble())
                    else -> 0.0
                }
                resultField.text = result.toString()
            } else {
                Toast.makeText(this, "Please enter a value!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun convertKmToM(value: Double): Double {
        return value * 1000
    }

    private fun convertFahrenheitToCelsius(value: Double): Double {
        return (value - 32) * 5 / 9
    }

    private fun convertGramsToKg(value: Double): Double {
        return value / 1000
    }
}