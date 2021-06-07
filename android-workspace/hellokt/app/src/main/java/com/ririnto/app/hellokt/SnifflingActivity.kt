package com.ririnto.app.hellokt

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SnifflingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sniffling)

        val mEtCom = findViewById<EditText>(R.id.mEtCom)
        val mEtMine = findViewById<EditText>(R.id.mEtMine)
        val mEtResult = findViewById<EditText>(R.id.mEtResult)
        val mBtn = findViewById<Button>(R.id.mBtn)

        mBtn.setOnClickListener {
            if ("홀" != mEtMine.text.toString() && "짝" != mEtMine.text.toString()) {
                mEtCom.setText("")
                mEtResult.setText("홀 또는 짝을 입력해주세요.")
            } else {
                val rand = Math.random()
                var com = "짝"
                if (rand < 1 / 2.0) {
                    com = "홀"
                }
                var result = "짐"
                if (com.equals(mEtMine.text.toString())) {
                    result = "이김"
                }
                mEtCom.setText(com)
                mEtResult.setText(result)
            }
        }
    }
}