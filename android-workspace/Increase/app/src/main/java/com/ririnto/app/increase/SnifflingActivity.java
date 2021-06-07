package com.ririnto.app.increase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SnifflingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sniffling);

        EditText mEtCom = findViewById(R.id.mEtCom);
        EditText mEtMine = findViewById(R.id.mEtMine);
        EditText mEtResult = findViewById(R.id.mEtResult);
        Button mBtn = findViewById(R.id.mBtn);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!"홀".equals(mEtMine.getText().toString()) && !"짝".equals(mEtMine.getText().toString())) {
                    mEtCom.setText("");
                    mEtResult.setText("홀 또는 짝을 입력해주세요.");
                    return;
                }

                double rand = Math.random();
                String com = "짝";
                if (rand < 1 / 2.0) {
                    com = "홀";
                }
                String result = "짐";
                if (com.equals(mEtMine.getText().toString())) {
                    result = "이김";
                }
                mEtCom.setText(com);
                mEtResult.setText(result);
            }
        });
    }
}