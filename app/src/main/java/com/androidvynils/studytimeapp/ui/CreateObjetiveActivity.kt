package com.androidvynils.studytimeapp.ui

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.textfield.TextInputEditText
import com.studytime.app.R

class CreateObjetiveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_objetive)

        val button = findViewById<Button>(R.id.nextButton)
        button.setOnClickListener {
            val intent = Intent(this, CreateRoutineActivity::class.java)
            startActivity(intent)
        }



        val topAppBar = this.findViewById<MaterialToolbar>(R.id.topAppBar)

        topAppBar.setNavigationOnClickListener {
            this.onSupportNavigateUp()
        }


        val categories = findViewById<TextInputEditText>(R.id.listCategories)

        val items = listOf("Lectura", "Repaso","Estudio")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val categoriesPopup = PopupMenu(this, categories)
        for (item in items) {
            categoriesPopup.menu.add(item)
        }
        categories.setOnClickListener {
            categoriesPopup.show()
        }

        categoriesPopup.setOnMenuItemClickListener { menuItem ->
            categories.setText(menuItem.title)
            true
        }


        val cancelButton = this.findViewById<MaterialButton>(R.id.cancelButton)
        cancelButton.setOnClickListener{
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.custom_dialog_layout)

            val viewText = dialog.findViewById<TextView>(R.id.dialog_title)
            viewText.setText("¿Estás seguro que desea cancelar el proceso?")

            dialog.show()


            val yes = dialog.findViewById<MaterialButton>(R.id.yes_button)
            val no = dialog.findViewById<MaterialButton>(R.id.no_button)

            yes.setOnClickListener {
                this.onSupportNavigateUp()
            }

            no.setOnClickListener {
                dialog.dismiss()
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed() // Handle the Up button click event
        return true
    }
}