package com.kovalsikoski.johan.marvelapi

import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.view.View

class ComicsDialog : DialogFragment(){

    internal lateinit var parentActivity : FragmentActivity
    private lateinit var alertDialog: AlertDialog

    companion object {
        fun newInstance(activity: FragmentActivity) : DialogFragment {

            val dialog = ComicsDialog()

            dialog.parentActivity = activity

            return dialog
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val dialogView = View.inflate(activity, R.layout.activity_comics, null)

        val alertDialogBuilder = AlertDialog.Builder(parentActivity)

        alertDialogBuilder.setView(dialogView)

        alertDialog = alertDialogBuilder.create()

        return alertDialog
    }
}