package eu.tutorials.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var tvSelectedDate: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker : Button = findViewById(R.id.btnDatePicker)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        btnDatePicker.setOnClickListener {
            clickDatePicker()
        }
    }

    private fun clickDatePicker() {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month: Int = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
           { view, selectedYear, selectedMonth, selectedDayofMonth ->
                Toast.makeText(this, "Year was $selectedYear, month was ${selectedMonth+1}, day was $selectedDayofMonth+", Toast.LENGTH_LONG).show()

               val selectedDate = "$selectedDayofMonth/${selectedMonth+1}/$selectedYear"

               tvSelectedDate?.text = selectedDate

               val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

               val theDate = sdf.parse(selectedDate)
            }, year, month, day
        

        ).show()
    }
}