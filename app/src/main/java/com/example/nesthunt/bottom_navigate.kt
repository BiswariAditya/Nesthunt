package com.example.nesthunt

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.nesthunt.R.id.logout

class bottom_navigate : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigate)

        showBottomDialog()
        val logOut = findViewById<LinearLayout>(logout)
        val logoutHandler = LogoutHandler(this)

        logOut.setOnClickListener {
            logoutDialogBox(logoutHandler)
        }
    }

    private fun logoutDialogBox(logoutHandler: LogoutHandler) {
        val alertDialogBuilder = AlertDialog.Builder(this)

        alertDialogBuilder.setTitle("Logout")
        alertDialogBuilder.setMessage("Are you sure you want to log out?")

        alertDialogBuilder.setPositiveButton("Yes") { _, _ ->
            logoutHandler.performLogout()
        }

        alertDialogBuilder.setNegativeButton("No") { dialog, _ ->
            // User clicked "No", dismiss the dialog
            dialog.dismiss()
        }

        val alertDialog: AlertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    private fun showBottomDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.activity_bottom_navigate) // Use a separate layout for the dialog

//        val profile = dialog.findViewById<Button>(R.id.profile)
//        val addProperty = dialog.findViewById<Button>(R.id.addProperty)
//        val rent = dialog.findViewById<Button>(R.id.rent)
        val cancelButton = dialog.findViewById<Button>(R.id.cancelButton)
//
//        profile.setOnClickListener {
//            dialog.dismiss()
//        }
//
//        addProperty.setOnClickListener {
//            dialog.dismiss()
//        }
//
//        rent.setOnClickListener {
//            dialog.dismiss()
//        }

        cancelButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.setGravity(Gravity.BOTTOM)
    }

}
