package com.ririnto.app.hellokt

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class IncreaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_increase)

        val mEt = findViewById<EditText>(R.id.mEt)
        val mBtn = findViewById<Button>(R.id.mBtn)

        mBtn.setOnClickListener {
            val mEtIncrease = mEt.text.toString().toInt() + 1
            mEt.setText(mEtIncrease.toString())
        }
    }
}