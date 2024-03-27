package com.example.pr4_2;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.second), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onFirstFragment(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_secondActivity,
                FirstFragment.class, null).commit();
    }

    public void onSecondFragment(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_secondActivity,
                SecondFragment.class, null).commit();
    }

    public void onThirdFragment(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_secondActivity,
                ThirdFragment.class, null).commit();
    }

    public void onFirstFragment2(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,
                FirstFragment.class, null).commit();
    }

    public void onSecondFragment2(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,
                SecondFragment.class, null).commit();
    }

    public void onThirdFragment2(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,
                ThirdFragment.class, null).commit();
    }


}