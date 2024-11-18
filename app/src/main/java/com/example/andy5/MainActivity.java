package com.example.andy5;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.andy5.databinding.ActivityMain4Binding;
import com.example.andy5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMain4Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain4Binding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.BottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home_menu) {
                replaceFragment(new HomeFragment());
            } else if (item.getItemId() == R.id.dishes_menu) {
                replaceFragment(new DishesFragment());
            } else if (item.getItemId() == R.id.avatar_menu) {
                replaceFragment(new AvatarFragment());
            } else if (item.getItemId() == R.id.favorites_menu) {
                replaceFragment(new FavoritesFragment());
            }
            return true;
        });
    }
    private void replaceFragment (Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment).commit();
    }
}