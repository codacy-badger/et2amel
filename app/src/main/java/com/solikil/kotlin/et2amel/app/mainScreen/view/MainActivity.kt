package com.solikil.kotlin.et2amel.app.mainScreen.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.solikil.kotlin.et2amel.app.FactorialCalculator
import com.solikil.kotlin.et2amel.app.NotificationUtil
import com.solikil.kotlin.et2amel.app.R
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity() {

    private val notificationUtil: NotificationUtil by lazy {
        NotificationUtil(
            this
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_compute.setOnClickListener {
            val input = edit_text_factorial.text.toString().toInt()
            val result = FactorialCalculator.computeFactorial(
                input
            ).toString()

            text_result.text = result
            text_result.visibility = View.VISIBLE

            notificationUtil.showNotification(
                context = this,
                title = getString(R.string.notification_title),
                message = result
            )
        }
    }
}
