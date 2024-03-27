package com.example.pr4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId") // !!!
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onNextActivity(View view)
    {
        EditText nameEdit = findViewById(R.id.editTextName);
        EditText surnameEdit = findViewById(R.id.editTextSurname);
        String name = nameEdit.getText().toString();
        String surname = surnameEdit.getText().toString();

        if (!name.isEmpty() && !surname.isEmpty())
        {
            User user = new User(name, surname);
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(User.class.getSimpleName(), user);
            startActivity(intent);
        }
    }
}