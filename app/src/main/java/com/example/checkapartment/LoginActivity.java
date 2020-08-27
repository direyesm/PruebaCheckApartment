package com.example.checkapartment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
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

        binding.editxtcorreo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                EditText et = (EditText) view;
                if(et.getText().toString().length() == 0 && b == Boolean.FALSE) {
                    binding.editxtcorreo.setError("Ingrese Corrreo");
                    Toast.makeText(LoginActivity.this, "Ingresa un correo", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.editextpass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                EditText et = (EditText) view;
                if(et.getText().toString().length() == 0 && b == Boolean.FALSE) {
                    binding.editextpass.setError("Ingrese Contraseña");
                    Toast.makeText(LoginActivity.this, "Ingresa una contraseña", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Password(binding.editextpass.getText().toString());

            }
        });
    }

    public void Password(String pass) {
        if (pass.equals("123Pass")){
            next();
        }else {
            cont++;
            Toast.makeText(LoginActivity.this, "llevas " +cont+ " intentos, a la 4ta vez se bloquea", Toast.LENGTH_LONG).show();
            //binding.button.setEnabled(false);
        }if (cont >= 4){
            binding.button.setEnabled(false);
            Toast.makeText(this, "Boton Bloqueado", Toast.LENGTH_LONG).show();
        }


    }
    public void next(){
            Intent intent = new Intent(this, MainActivity.class);
            cont = 0;
            startActivity(intent);
        }
}

