package com.hie2j.ad1009;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class AddstudentActivity extends AppCompatActivity {
    private EditText edtName;
    private EditText edtAge;
    private RadioButton radio1;
    private RadioButton radio2;
    private RadioButton radio3;
    private RadioButton radio4;
    private RadioButton radio5;
    private Button btnSaveStu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstudent);
        setTitle("添加学生");

        edtName = findViewById(R.id.stu_edtName);
        edtAge = findViewById(R.id.stu_edtAge);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        radio3 = findViewById(R.id.radio3);
        radio4 = findViewById(R.id.radio4);
        radio5 = findViewById(R.id.radio5);
        btnSaveStu = findViewById(R.id.btn_saveStu);

        btnSaveStu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                int age = Integer.parseInt(edtAge.getText().toString());

                int imgId = R.drawable.dog1;
                if (radio1.isChecked()){
                    imgId = R.drawable.dog1;
                }else if (radio2.isChecked()){
                    imgId = R.drawable.dog2;
                }else if (radio3.isChecked()){
                    imgId = R.drawable.dog3;
                }else if (radio4.isChecked()){
                    imgId = R.drawable.dog4;
                }else if (radio5.isChecked()){
                    imgId = R.drawable.dog5;
                }

                Intent intent = new Intent();
                intent.putExtra("NAME",name);
                intent.putExtra("AGE",age);
                intent.putExtra("IMG",imgId);
                setResult(2002,intent);

                finish();
            }
        });
    }
}
