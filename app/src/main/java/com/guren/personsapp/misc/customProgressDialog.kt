package com.guren.personsapp.misc

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.guren.personsapp.R

private var customProgressDialog: AlertDialog? = null

fun AppCompatActivity.showProgressDialog(message: String) {
    val progressDialog = LayoutInflater.from(this)
        .inflate(R.layout.progress_dialog_layout, null)
    customProgressDialog = AlertDialog.Builder(this, R.style.LoadingDialog)
        .createCustomAlertDialog(view = progressDialog, cancelable = false)
    customProgressDialog?.show()
}

fun AppCompatActivity.dismissProgressDialog() {
    customProgressDialog?.dismiss()
    customProgressDialog = null
}

fun androidx.fragment.app.Fragment.showProgressDialog(message: String) {
    (activity as? AppCompatActivity)?.showProgressDialog(message)
}

fun androidx.fragment.app.Fragment.dismissProgressDialog() {
    if(customProgressDialog != null){
        (activity as? AppCompatActivity)?.dismissProgressDialog()
    }
}

fun ViewModel.dissmissProgressDialog() {

    if (customProgressDialog != null) {
        customProgressDialog?.dismiss()
        customProgressDialog = null
    }

}

fun dismissProgressDialog() {

    if (customProgressDialog != null) {
        customProgressDialog?.dismiss()
        customProgressDialog = null
    }
}

fun ViewModel.showProgressDialog(message: String, ctx: Context) {
    val progressDialog = LayoutInflater.from(ctx)
        .inflate(R.layout.progress_dialog_layout, null)
//    progressDialog.dialog_title.text = message
    customProgressDialog = AlertDialog.Builder(ctx, R.style.LoadingDialog)
        .createCustomAlertDialog(view = progressDialog, cancelable = false)
    customProgressDialog?.show()
}

fun showProgressDialog(message: String, ctx: Context) {
    val progressDialog = LayoutInflater.from(ctx)
        .inflate(R.layout.progress_dialog_layout, null)

    customProgressDialog = AlertDialog.Builder(ctx, R.style.LoadingDialog)
        .createCustomAlertDialog(view = progressDialog, cancelable = false)
    customProgressDialog?.show()

}

fun isProgressDialogShowing(): Boolean {
    if(customProgressDialog != null){
        return customProgressDialog!!.isShowing
    }else{
        return false
    }
}

fun showAlertProgressDialog(ctx: Context): AlertDialog {
    val dialog = createAlertDialog(ctx)
    dialog.show()
    return dialog
}

fun createAlertDialog(
    ctx: Context
): AlertDialog {
    val builder: AlertDialog.Builder = AlertDialog.Builder(ctx, R.style.LoadingDialog)
    val progressDialog = LayoutInflater.from(ctx)
        .inflate(R.layout.progress_dialog_layout, null)
    builder.setView(progressDialog)
    val dialog = builder.create()
    dialog.setCanceledOnTouchOutside(false)
    return dialog
}