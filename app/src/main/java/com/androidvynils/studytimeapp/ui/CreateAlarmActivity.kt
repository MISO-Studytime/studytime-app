 package com.androidvynils.studytimeapp.ui

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.studytime.app.R
import com.studytime.app.ui.DashboardActivity
import com.studytime.app.ui.MainActivity
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

        val topAppBar = this.findViewById<MaterialToolbar>(R.id.topAppBar)

        topAppBar.setNavigationOnClickListener {
            this.onSupportNavigateUp()
        }

        val finish = this.findViewById<MaterialButton>(R.id.finish)
        finish.setOnClickListener {
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.ok_dialog_layout)

            dialog.show()

            val ok = dialog.findViewById<MaterialButton>(R.id.ok_button)

            ok.setOnClickListener {
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
            }

        }

        val cancel = this.findViewById<MaterialButton>(R.id.cancel)
        cancel.setOnClickListener{
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.custom_dialog_layout)

            val viewText = dialog.findViewById<TextView>(R.id.dialog_title)
            viewText.setText("¿Estás seguro que desea cancelar el proceso?")

            dialog.show()


            val yes = dialog.findViewById<MaterialButton>(R.id.yes_button)
            val no = dialog.findViewById<MaterialButton>(R.id.no_button)

            yes.setOnClickListener {
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
            }

            no.setOnClickListener {
                dialog.dismiss()
            }
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

     override fun onSupportNavigateUp(): Boolean {
         onBackPressed() // Handle the Up button click event
         return true
     }
}