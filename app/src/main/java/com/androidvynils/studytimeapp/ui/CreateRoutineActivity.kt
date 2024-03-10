package com.androidvynils.studytimeapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.studytime.app.R

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

        val items = listOf("Min", "Hrs")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val spinnerPopup = PopupMenu(this, spinner)
        for (item in items) {
            spinnerPopup.menu.add(item)
        }
        spinner.setOnClickListener {
            spinnerPopup.show()
        }

        spinnerPopup.setOnMenuItemClickListener { menuItem ->
            spinner.setText(menuItem.title)
            true
        }

        spinnerPopup.gravity = Gravity.END

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed() // Handle the Up button click event
        return true
    }
}