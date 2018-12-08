package com.merqueotest.luistorm.merqueotest.ui.activities

import android.app.Dialog
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import com.merqueotest.luistorm.merqueotest.R
import com.merqueotest.luistorm.merqueotest.ui.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var dialog: Dialog
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    fun showLoader(context: Context) {
        dialog = Dialog(context)
        dialog.setContentView(R.layout.loader_dialog)
        dialog.setCancelable(false)
        dialog.window.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT)
        dialog.window.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
    }

    fun hideLoader() {
        dialog.cancel()
    }

}
