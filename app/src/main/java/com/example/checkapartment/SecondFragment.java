package com.example.checkapartment;

import android.content.Intent;
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

    public static final int NORMAL = 3;
    public static final int REGULAR = 2;
    public static final int MALA = 1;

    public static final int LUCES = 10;
    public static final int DORMI = 20;
    public static final int COCINA = 30;
    public static final int BANO = 40;


    private String url;
    private String name;
    private String address;
    private String depart;
    private int result = 0;

    private FragmentSecondBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString("Nombre");
            depart = getArguments().getString("Numero");
            address = getArguments().getString("Dirección");
            url = getArguments().getString("url");
        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        Glide.with(getContext()).load(url).centerCrop().into(binding.ivDescription);
        binding.txtname.setText(name);
        binding.txtnum.setText(depart);
        binding.txtdirec.setText(address);

        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (binding.rbnormal.isChecked()) {
                    result = result * NORMAL;
                }
                if (binding.rbregular.isChecked()) {
                    result = result * REGULAR;
                }
                if (binding.rbmalas.isChecked()) {
                    result = result * MALA;
                }
            }
        });


        binding.btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultCheckBox();
            }
        });

        binding.btnalerta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareWithWhatsApp(view, "hola");
            }
        });


        return binding.getRoot();
    }



    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void resultCheckBox(){
        if(binding.checkBoxluz.isChecked()){
            result += LUCES;
        }
        if (binding.checkBoxcocina.isChecked()){
            result += COCINA;
        }
        if (binding.checkBoxbano.isChecked()){
            result += BANO;
        }
        if (binding.checkBoxdormi.isChecked()){
            result += DORMI;
        }
        binding.txtresult.setText(String.valueOf(result));
    }

    public void shareWithWhatsApp(View v, String mensaje){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, " " + mensaje);
        sendIntent.setType("text/plain");
        //sendIntent.setPackage("com.whatsapp");
        startActivity(sendIntent);
    }



//    public void resultRadioButon(){
//        if (binding.rbnormal.isChecked()){
//            result += NORMAL;
//        }
//        if (binding.rbregular.isChecked()){
//            result += REGULAR;
//        }
//        if (binding.rbmalas.isChecked()){
//            result += MALA;
//        }
//        binding.txtresult.setText(String.valueOf(result));
//
//    }



}