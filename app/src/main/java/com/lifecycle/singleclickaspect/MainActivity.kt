package com.lifecycle.singleclickaspect

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.lifecycle.singleclickaspect.singleclick.annotation.SingleClick
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener(object : View.OnClickListener {
            @SingleClick(10000)
            override fun onClick(v: View?) {
                Toast.makeText(this@MainActivity, "btn", Toast.LENGTH_SHORT).show()
            }

        })

        btn1.setOnClickListener(object : View.OnClickListener {
            @SingleClick(10000)
            override fun onClick(v: View?) {
                Toast.makeText(this@MainActivity, "btn111111", Toast.LENGTH_SHORT).show()
            }

        })
    }
}
