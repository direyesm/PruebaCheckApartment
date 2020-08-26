package com.example.checkapartment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.checkapartment.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    private int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Password(binding.editextpass.getText().toString());
                Toast.makeText(LoginActivity.this, "llevas " +cont+ " intentos, a la 4ta vez se bloquea", Toast.LENGTH_LONG).show();

            }
        });
    }

    public void Password(String pass) {
        if (pass.equals("123Pass") && cont < 4)
            next();
            cont++;
    }
    public void next(){
            Intent intent = new Intent(this, MainActivity.class);
            cont = 0;
            startActivity(intent);
        }
}

