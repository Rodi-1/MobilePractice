package com.example.app2;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.app2.entity.User;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    public static final Uri CONTENT_URI = Uri.parse("content://com.example.pr12.UserProvider");
    private TextView tvName;
    private TextView tvSurname;
    private TextView tvEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    public void onLoad(View view) {

        // Используем ContentResolver для запроса данных
        Cursor cursor = getContentResolver().query(CONTENT_URI, null, null, null, null);
        Toast.makeText(this, "Cursor: " + cursor, Toast.LENGTH_SHORT).show();

        if (cursor != null && cursor.moveToFirst()) {
            // Получаем данные из первой строки и первой колонки (там где хранится JSON)
            String jsonData = cursor.getString(0);

            // Разбираем JSON
            User user = new Gson().fromJson(jsonData, User.class);

            // Отображаем данные в TextView
            if (user != null) {
                tvName.setText(user.getName());
                tvSurname.setText(user.getSurname());
                tvEmail.setText(user.getEmail());
            }

            cursor.close();
        }
    }
}