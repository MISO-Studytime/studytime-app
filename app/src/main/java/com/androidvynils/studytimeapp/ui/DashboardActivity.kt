package com.studytime.app.ui

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.internal.ScrimInsetsFrameLayout
import com.google.android.material.math.MathUtils
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
    }



}