package com.studytime.app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.studytime.app.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textInputLayoutPassword = findViewById<TextInputLayout>(R.id.pwdText)
        val editTextPassword = findViewById<TextInputEditText>(R.id.editTextPassword)

        textInputLayoutPassword.setEndIconOnClickListener {
            val currentInputType = editTextPassword.inputType

            if (currentInputType == InputType.TYPE_TEXT_VARIATION_PASSWORD or InputType.TYPE_CLASS_TEXT) {
                editTextPassword.inputType = InputType.TYPE_CLASS_TEXT
            } else {
                editTextPassword.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD or InputType.TYPE_CLASS_TEXT
            }

            editTextPassword.text?.let { it1 -> editTextPassword.setSelection(it1.length) }
        }

        val siginButton = findViewById<Button>(R.id.signInButton)
        siginButton.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }

    }
}