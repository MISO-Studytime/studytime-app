 package com.androidvynils.studytimeapp.ui

import android.icu.text.SimpleDateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.studytime.app.R
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
}