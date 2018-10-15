package com.hie2j.ad1009;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IOnDelListener {
    private ListView stuListView;
    private ArrayList<Student> studentArrayList = new ArrayList<Student>();
    private StuAdapter stuAdapter;
    private Button stuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stuListView = findViewById(R.id.lv_stu);

        initStudentList();
        stuAdapter = new StuAdapter(MainActivity.this,studentArrayList,MainActivity.this);



        stuListView.setAdapter(stuAdapter);
        stuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"姓名"+studentArrayList.get(position).getName()
                        +"年龄"+studentArrayList.get(position).getAge(),Toast.LENGTH_SHORT).show();
            }
        });


        stuBtn = findViewById(R.id.btn_addStu);
        stuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        AddstudentActivity.class);
                startActivityForResult(intent,1001);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.e("MainActivity","requestCode ="+requestCode+" resultCode ="+resultCode);
        if (data == null){
            return;
        }
        String name = data.getStringExtra("NAME");
        int age = data.getIntExtra("AGE",0);
        int imgId = data.getIntExtra("IMG",R.drawable.dog1);

        Student stu = new Student(name,age,imgId);
        studentArrayList.add(stu);

        stuAdapter.notifyDataSetChanged();

    }

    private void initStudentList() {
        Student s1 = new Student("张一",18,R.drawable.dog1);
        Student s2 = new Student("张二",19,R.drawable.dog2);
        Student s3 = new Student("张三",20,R.drawable.dog3);
        Student s4 = new Student("张四",21,R.drawable.dog4);
        Student s5 = new Student("张五",22,R.drawable.dog5);

        studentArrayList.add(s1);
        studentArrayList.add(s2);
        studentArrayList.add(s3);
        studentArrayList.add(s4);
        studentArrayList.add(s5);
    }

    @Override
    public void del(int i) {
        studentArrayList.remove(i);
        stuAdapter.notifyDataSetChanged();
    }
}
