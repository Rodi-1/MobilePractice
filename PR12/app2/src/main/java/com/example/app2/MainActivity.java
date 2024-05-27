package com.example.app2;

import static android.content.ContentValues.TAG;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Uri contentUri = Uri.parse("content://com.example.app.provider/books");

        // Выполняем запрос данных через ContentResolver
        Cursor cursor = getContentResolver().query(
                contentUri,                        // URI провайдера контента
                new String[]{"_id", "title", "author"},  // Список колонок для выборки
                null,                             // Условие выборки (без условия)
                null,                             // Аргументы условия (без аргументов)
                "title ASC"                       // Сортировка результата по названию книги
        );

        // Проверяем, что cursor не null
        if (cursor != null) {
            try {
                // Получаем индексы колонок внутри блока try
                int idColumnIndex = cursor.getColumnIndex("_id");
                int titleColumnIndex = cursor.getColumnIndex("title");
                int authorColumnIndex = cursor.getColumnIndex("author");

// Проверяем, что индексы корректные
                if (idColumnIndex != -1 && titleColumnIndex != -1 && authorColumnIndex != -1) {
                    // Проходим по результатам запроса
                    while (cursor.moveToNext()) {
                        // Получаем значения из курсора по индексам колонок
                        int id = cursor.getInt(idColumnIndex);
                        String title = cursor.getString(titleColumnIndex);
                        String author = cursor.getString(authorColumnIndex);

                        // Делаем что-то с полученными данными (например, выводим в лог)
                        Log.d(TAG, "Book ID: " + id);
                        Log.d(TAG, "Book Title: " + title);
                        Log.d(TAG, "Author: " + author);
                    }
                } else {
                    // Обработка случая, когда какая-то из колонок не найдена
                    Log.e(TAG, "Column not found in Cursor");
                }
            } finally {
                // Важно закрыть курсор после использования
                cursor.close();
            }
        }

    }
}