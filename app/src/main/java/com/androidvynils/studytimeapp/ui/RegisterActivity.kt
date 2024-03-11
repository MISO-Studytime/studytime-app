package com.androidvynils.studytimeapp.ui

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.studytime.app.R
import com.studytime.app.ui.DashboardActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val cancelButton = findViewById<Button>(R.id.cancelButton)
        cancelButton.setOnClickListener {
            this.onSupportNavigateUp()
        }



        val topAppBar = this.findViewById<MaterialToolbar>(R.id.topAppBar)

        topAppBar.setNavigationOnClickListener {
            this.onSupportNavigateUp()
        }


        val registerButton = this.findViewById<MaterialButton>(R.id.registerButton)
        registerButton.setOnClickListener{
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.confirm_dialog_layout)

            dialog.show()
            val yes = dialog.findViewById<MaterialButton>(R.id.yes_button)

            yes.setOnClickListener {
                this.onSupportNavigateUp()
            }


        }


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed() // Handle the Up button click event
        return true
    }
}