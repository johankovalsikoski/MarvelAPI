package com.kovalsikoski.johan.marvelapi

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View

class ComicsDialog @SuppressLint("ValidFragment")
private constructor(): DialogFragment(){

    internal lateinit var parentActivity : FragmentActivity
    internal lateinit var comicObject: MarvelModel.MarvelPage.Character.Comic
    private lateinit var alertDialog: AlertDialog
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ComicsAdapter

    companion object {
        fun newInstance(
                activity: FragmentActivity,
                comicObject: MarvelModel.MarvelPage.Character.Comic): DialogFragment {

            val dialog = ComicsDialog()

            dialog.parentActivity = activity
            dialog.comicObject = comicObject

            return dialog
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val dialogView = View.inflate(context, R.layout.custom_dialog_comics, null)

        val alertDialogBuilder = AlertDialog.Builder(parentActivity)

        alertDialogBuilder.setView(dialogView)

        recyclerView = dialogView.findViewById(R.id.comics_recyclerview)
        adapter = ComicsAdapter(comicObject, context!! )
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(parentActivity, StaggeredGridLayoutManager.VERTICAL)

        alertDialog = alertDialogBuilder.create()

        return alertDialog
    }

}