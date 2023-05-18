package tl2.lecticiacuna.appfood.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import tl2.lecticiacuna.appfood.databinding.ActivitySplashScreenBinding;

public class SplashScreen extends AppCompatActivity {

    private ActivitySplashScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void login(View view) {
        startActivity(new Intent(SplashScreen.this, LogInActivity.class));
    }

    public void registration(View view) {
        startActivity(new Intent(SplashScreen.this, RegisterActivity.class));
    }
}