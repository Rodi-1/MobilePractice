package com.example.pr3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume()
    {
        super.onResume();

        Bundle arguments = getIntent().getExtras();

        if(arguments != null)
        {
            Student student = arguments.getParcelable(Student.class.getSimpleName());
            String name = student.getName();
            String group = student.getGroup();
            int age = student.getAge();
            int mark = student.getDesired_mark();

            TextView nameView = findViewById(R.id.textView);
            nameView.setText(getString(R.string.student) + name);
            TextView groupView = findViewById(R.id.textView2);
            groupView.setText(getString(R.string.group) + group);
            TextView ageView = findViewById(R.id.textView3);
            ageView.setText(getString(R.string.age) + age);
            TextView markView = findViewById(R.id.textView4);
            markView.setText(getString(R.string.wanted_mark) + mark);
        }


    }
    public void onPreviousAction(View view)
    {
        Intent intent = new Intent(this, com.example.pr3.MainActivity.class);
        startActivity(intent);
    }
}