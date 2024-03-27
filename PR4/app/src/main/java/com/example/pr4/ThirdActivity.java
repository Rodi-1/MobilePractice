package com.example.pr4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.thirdLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void sendMessage(View view)
    {
        EditText dayEdit, timeEdit, commentEdit;
        dayEdit = findViewById(R.id.editTextDay);
        timeEdit = findViewById(R.id.editTextTime);
        commentEdit = findViewById(R.id.editTextComment);

        String day, time, comment;
        day = dayEdit.getText().toString();
        time = timeEdit.getText().toString();
        comment = commentEdit.getText().toString();

        Intent intent = new Intent();
        if (!day.isEmpty() && !time.isEmpty() && !comment.isEmpty())
        {
            intent.putExtra(SecondActivity.ACCESS_MSG, day + " " + time + " " + comment);
            setResult(RESULT_OK, intent);
            finish();
        }
        else
        {
            setResult(RESULT_CANCELED, intent);
            finish();
        }
    }
}