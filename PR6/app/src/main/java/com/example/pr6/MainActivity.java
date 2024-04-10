package com.example.pr6;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.example.pr6.task1.p1_fragment_1;
import com.example.pr6.task1.p1_fragment_2;
import com.example.pr6.task1.p1_fragment_3;
import com.example.pr6.task2.MainActivity2;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(item -> {

            if (item.getItemId() == R.id.nav_pic1){
                fragmentManager.beginTransaction().replace(R.id.fragmentContainerView2, p1_fragment_1.class, null).commit();
                Toast.makeText(MainActivity.this, R.string.p1_dota2, Toast.LENGTH_SHORT).show();
                getSupportActionBar().setTitle("Dota2");
                return true;
            }
            else if (item.getItemId()==R.id.nav_pic2){
                fragmentManager.beginTransaction().replace(R.id.fragmentContainerView2, p1_fragment_2.class, null).commit();
                Toast.makeText(MainActivity.this,R.string.p1_apex_legend, Toast.LENGTH_SHORT).show();
                getSupportActionBar().setTitle("Apex Legends");
                return true;

            } else if (item.getItemId() == R.id.nav_pic3) {
                fragmentManager.beginTransaction().replace(R.id.fragmentContainerView2, p1_fragment_3.class, null).commit();
                Toast.makeText(MainActivity.this, R.string.p1_league_of_legends, Toast.LENGTH_SHORT).show();
                getSupportActionBar().setTitle("League of Legends");
                return true;

            } else if (item.getItemId() == R.id.nav_task2) {
                // Обработка выбора раздела "Задание 2"
                Toast.makeText(MainActivity.this, R.string.p1_task_2, Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, MainActivity2.class));
                return true;

            }

            return false;
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2, p1_fragment_1.class, null).commit();
            navigationView.setCheckedItem(R.id.nav_pic1);
            getSupportActionBar().setTitle("Dota2");
        }

        toggle = new ActionBarDrawerToggle(this, drawer, R.string.drawer_open, R.string.drawer_close);
        if (drawer != null) {
            drawer.addDrawerListener(toggle);
        }
        toggle.syncState();


    }
    protected void onResume() {
        super.onResume();
    }


    // Обработка нажатия на иконку меню в ActionBar для открытия и закрытия Drawer
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}