package com.merqueotest.luistorm.merqueotest.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.merqueotest.luistorm.merqueotest.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initViews()
    }

    private fun initViews() {
        Picasso.get().load(intent.extras.getString(IMAGE_URL, "")).into(detailImage)
        movieTitleTextView.text = intent.extras.getString(TITLE, "")
        movieDescriptionTextView.text = intent.extras.getString(DESCRIPTION, "")
    }

    companion object {
        const val IMAGE_URL = "IMAGE_URL"
        const val TITLE = "TITLE"
        const val DESCRIPTION = "DESCRIPTION"
    }

}
