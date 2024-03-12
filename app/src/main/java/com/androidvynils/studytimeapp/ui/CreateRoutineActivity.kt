package com.androidvynils.studytimeapp.ui

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.studytime.app.R
import com.studytime.app.ui.DashboardActivity

class CreateRoutineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_routine)
        val topAppBar = this.findViewById<MaterialToolbar>(R.id.topAppBar)

        topAppBar.setNavigationOnClickListener {
            this.onSupportNavigateUp()
        }

        val studyTimeLess = this.findViewById<ImageView>(R.id.time_less)
        val studyTimeMore = this.findViewById<ImageView>(R.id.time_more)

        studyTimeLess.setOnClickListener {
            val text_field_studytime = this.findViewById<TextInputEditText>(R.id.text_field_studytime)
            val text = text_field_studytime.text.toString()
            var value = 0
            if (text.isNotEmpty()) {
                value = text.toInt()
            }

            if (value > 0) {
                value = value - 1
            }

            text_field_studytime.setText(value.toString())
        }

        studyTimeMore.setOnClickListener {
            val text_field_studytime = this.findViewById<TextInputEditText>(R.id.text_field_studytime)
            val text = text_field_studytime.text.toString()
            var value = 0
            if (text.isNotEmpty()) {
                value = text.toInt()
            }

            if (value < 999) {
                value = value + 1
            }

            text_field_studytime.setText(value.toString())
        }

        val spinner = findViewById<TextInputEditText>(R.id.spinner)
        val spinnerRestTime = findViewById<TextInputEditText>(R.id.spinner_rest_time)

        val items = listOf("Min", "Hrs")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val spinnerPopup = PopupMenu(this, spinner)
        val spinnerPopupRestTime = PopupMenu(this, spinnerRestTime)
        for (item in items) {
            spinnerPopup.menu.add(item)
            spinnerPopupRestTime.menu.add(item)
        }
        spinner.setOnClickListener {
            spinnerPopup.show()
        }

        spinnerRestTime.setOnClickListener {
            spinnerPopupRestTime.show()
        }

        spinnerPopup.setOnMenuItemClickListener { menuItem ->
            spinner.setText(menuItem.title)
            true
        }

        spinnerPopupRestTime.setOnMenuItemClickListener { menuItem ->
            spinnerRestTime.setText(menuItem.title)
            true
        }

        spinnerPopup.gravity = Gravity.END
        spinnerPopupRestTime.gravity = Gravity.END

        val studyTimeLessRestTime = this.findViewById<ImageView>(R.id.time_less_rest_time)
        val studyTimeMoreRestTime = this.findViewById<ImageView>(R.id.time_more_rest_time)

        studyTimeLessRestTime.setOnClickListener {
            val text_field_studytime = this.findViewById<TextInputEditText>(R.id.text_field_rest_time)
            val text = text_field_studytime.text.toString()
            var value = 0
            if (text.isNotEmpty()) {
                value = text.toInt()
            }

            if (value > 0) {
                value = value - 1
            }

            text_field_studytime.setText(value.toString())
        }

        studyTimeMoreRestTime.setOnClickListener {
            val text_field_studytime = this.findViewById<TextInputEditText>(R.id.text_field_rest_time)
            val text = text_field_studytime.text.toString()
            var value = 0
            if (text.isNotEmpty()) {
                value = text.toInt()
            }

            if (value < 999) {
                value = value + 1
            }

            text_field_studytime.setText(value.toString())
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

        val preview = this.findViewById<MaterialButton>(R.id.preview)
        preview.setOnClickListener {
            this.onSupportNavigateUp()
        }

        val next = this.findViewById<MaterialButton>(R.id.next)
        next.setOnClickListener {
            val intent = Intent(this, CreateAlarmActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed() // Handle the Up button click event
        return true
    }
}