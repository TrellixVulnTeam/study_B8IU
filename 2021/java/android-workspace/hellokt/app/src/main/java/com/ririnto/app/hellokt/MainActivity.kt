package com.ririnto.app.hellokt

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mTv = findViewById<TextView>(R.id.mTv)
        val mBtn = findViewById<Button>(R.id.mBtn)
        mBtn.setOnClickListener {
            if (mTv.text === "Good Evening") {
                mTv.text = "Good Morining"
            } else {
                mTv.text = "Good Evening"
            }
        }
    }
}