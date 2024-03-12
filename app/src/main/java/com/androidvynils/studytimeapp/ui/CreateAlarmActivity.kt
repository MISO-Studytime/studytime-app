 package com.androidvynils.studytimeapp.ui

import android.app.TimePickerDialog
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.studytime.app.R
import java.sql.Time
import java.util.Date
import java.util.Locale

 class CreateAlarmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_alarm)

        val datePickerText = findViewById<TextInputEditText>(R.id.select_dialog_item)

        datePickerText.setOnClickListener {
            this.showDatePickerDialog(datePickerText)
        }

        val datePickerEndText = findViewById<TextInputEditText>(R.id.select_dialog_item_end)

        datePickerEndText.setOnClickListener {
            this.showDatePickerDialog(datePickerEndText)
        }

        val startTime = findViewById<TextInputEditText>(R.id.select_dialog_time)

        startTime.setOnClickListener{
           this.showTimePickerDialog(startTime)
        }

        val endTime = findViewById<TextInputEditText>(R.id.select_dialog_time_end)

        endTime.setOnClickListener{
            this.showTimePickerDialog(endTime)
        }
    }

     private fun showTimePickerDialog(editText: TextInputEditText) {
         val calendar = Calendar.getInstance()
         val hour = calendar.get(Calendar.HOUR_OF_DAY)
         val minute = calendar.get(Calendar.MINUTE)

         val timePickerDialog = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
             // Format the selected time
             val formattedTime = formatTime(hourOfDay, minute)
             // Set the formatted time to the text field
             editText.setText(formattedTime)
         }, hour, minute, false)
         timePickerDialog.show()
     }

    private fun showDatePickerDialog(editText: TextInputEditText) {
        val builder = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Seleccionar fecha")
            .setInputMode(MaterialDatePicker.INPUT_MODE_CALENDAR)
        val picker = builder.build()

        // Set listener for date selection
        picker.addOnPositiveButtonClickListener { selection ->
            // Convert the selected date to a formatted string
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val selectedDate = sdf.format(Date(selection))

            // Update the TextView with the selected date
            editText.setText(selectedDate)
        }

        // Show the date picker dialog
        picker.show(supportFragmentManager, picker.toString())
    }

     private fun formatTime(hour: Int, minute: Int): String {
         val calendar = Calendar.getInstance()
         calendar.set(Calendar.HOUR_OF_DAY, hour)
         calendar.set(Calendar.MINUTE, minute)
         val dateFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
         return dateFormat.format(calendar.time)
     }
}