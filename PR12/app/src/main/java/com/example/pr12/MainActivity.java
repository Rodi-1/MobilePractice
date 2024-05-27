package com.example.pr12;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etAuthor;
    private Button btnAddBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_book_name);
        etAuthor = findViewById(R.id.et_book_author);
        btnAddBook = findViewById(R.id.btn_add_book);

        btnAddBook.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String author = etAuthor.getText().toString().trim();

            if (!name.isEmpty() && !author.isEmpty()) {
                // Создаем новую книгу
                ContentValues values = new ContentValues();
                values.put("title", name);
                values.put("author", author);

                // Определяем URI провайдера контента
                Uri contentUri = Uri.parse("content://com.example.pr12.provider/books");

                // Вставляем данные через ContentResolver
                getContentResolver().insert(contentUri, values);

                Toast.makeText(MainActivity.this, "Книга добавлена", Toast.LENGTH_SHORT).show();
                etName.setText("");
                etAuthor.setText("");
            } else {
                Toast.makeText(MainActivity.this, "Заполните все поля", Toast.LENGTH_SHORT).show();
            }
        });

    }
}