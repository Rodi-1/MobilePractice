package com.example.pr4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.secondLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    protected void onResume()
    {
        super.onResume();

        Bundle arguments = getIntent().getExtras();
        if (arguments != null)
        {
            User user = arguments.getParcelable(User.class.getSimpleName());

            TextView nameView = findViewById(R.id.textViewName);
            nameView.setText(getString( R.string.name) + user.getName());
            TextView surnameView = findViewById(R.id.textViewSurname);
            surnameView.setText(getString( R.string.surname) + user.getSurname());
        }
    }

    static final String ACCESS_MSG = "ACCESS";

    ActivityResultLauncher<Intent> startForResult = registerForActivityResult
            (
                    new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>()
                    {
                        @Override
                        public void onActivityResult(ActivityResult result)
                        {
                            TextView subjectView = findViewById(R.id.textViewSubject);
                            if (result.getResultCode() == Activity.RESULT_OK)
                            {
                                Intent intent = result.getData();
                                String subject = intent.getStringExtra(ACCESS_MSG);
                                subjectView.setText(subject);
                                Toast.makeText(getApplicationContext(), R.string.alert_ok, Toast.LENGTH_SHORT).show();
                            }
                            else Toast.makeText(getApplicationContext(), R.string.alert_canceled, Toast.LENGTH_SHORT).show();
                        }
                    }
            );

    public void onNextActivity(View view)
    {
        Intent intent = new Intent(this, ThirdActivity.class);
        startForResult.launch(intent);
    }
}