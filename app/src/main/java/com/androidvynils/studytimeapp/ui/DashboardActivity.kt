package com.studytime.app.ui

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import com.androidvynils.studytimeapp.ui.CreateObjectiveActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.studytime.app.R

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val topAppBar = this.findViewById<MaterialToolbar>(R.id.topAppBar)
        val drawerLayout = this.findViewById<DrawerLayout>(R.id.drawer_layout)
        val navigationView = this.findViewById<NavigationView>(R.id.navigation_view)

        topAppBar.setNavigationOnClickListener {
            drawerLayout.open()
        }
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle menu item selected
            menuItem.isChecked = true
            drawerLayout.close()
            true
        }

        val cancelButton1 = this.findViewById<MaterialButton>(R.id.cancel_button_1)
        cancelButton1.setOnClickListener{
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.custom_dialog_layout)

            dialog.show()


            val yes = dialog.findViewById<MaterialButton>(R.id.yes_button)
            val no = dialog.findViewById<MaterialButton>(R.id.no_button)

            yes.setOnClickListener {
                dialog.dismiss()
            }

            no.setOnClickListener {
                dialog.dismiss()
            }
        }

    val cancelButton2 = this.findViewById<MaterialButton>(R.id.cancel_button_2)
        cancelButton2.setOnClickListener{
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.custom_dialog_layout)

            dialog.show()


            val yes = dialog.findViewById<MaterialButton>(R.id.yes_button)
            val no = dialog.findViewById<MaterialButton>(R.id.no_button)

            yes.setOnClickListener {
                dialog.dismiss()
            }

            no.setOnClickListener {
                dialog.dismiss()
            }
        }

       val cancelButton3 = this.findViewById<MaterialButton>(R.id.cancel_button_3)
       cancelButton3.setOnClickListener{
           val dialog = Dialog(this)
           dialog.setContentView(R.layout.custom_dialog_layout)

           dialog.show()

           val yes = dialog.findViewById<MaterialButton>(R.id.yes_button)
           val no = dialog.findViewById<MaterialButton>(R.id.no_button)

           yes.setOnClickListener {
               dialog.dismiss()
           }

           no.setOnClickListener {
               dialog.dismiss()
           }




       }

        val button = findViewById<FloatingActionButton>(R.id.floating_action_button)
        button.setOnClickListener {
            val intent = Intent(this, CreateObjectiveActivity::class.java)
            startActivity(intent)
        }

        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle navigation view item clicks here.
            when (menuItem.itemId) {
                R.id.menu_create_objective -> {
                    val intent = Intent(this, CreateObjectiveActivity::class.java)
                    startActivity(intent)
                }

                R.id.item3 ->{
                    this.onSupportNavigateUp()
                }
            }


            // Close the drawer after item click
            drawerLayout.closeDrawers()
            true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed() // Handle the Up button click event
        return true
    }


}