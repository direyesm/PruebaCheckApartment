package com.example.checkapartment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.example.checkapartment.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    public static final int LUCES = 10;
    public static final int BANO = 40;
    public static final int COCINA = 30;
    public static final int DORMI = 20;


    private String url;
    private String name;
    private String address;
    private String depart;

    private FragmentSecondBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            name = getArguments().getString("Nombre");
            depart = getArguments().getString("Numero");
            address = getArguments().getString("Dirección");
            url = getArguments().getString("url");
        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        Glide.with(getContext()).load(url).centerCrop().into(binding.ivDescription);
        binding.txtname.setText(name);
        binding.txtnum.setText(depart);
        binding.txtdirec.setText(address);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }

    public void checkLis(String result){

        int cant = 0;
        if (binding.checkBoxdormi.isChecked() == true){
            cant = DORMI;
        }
        if (binding.checkBoxbaño.isChecked() == true){
            cant = BANO;
        }
        if (binding.checkBoxcocina.isChecked() == true){
            cant = COCINA;
        }
        if (binding.checkBoxluz.isChecked() == true){
            cant = LUCES;
        }




    }

}