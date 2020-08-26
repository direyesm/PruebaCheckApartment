package com.example.checkapartment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.checkapartment.databinding.FragmentFirstBinding;
import com.google.android.material.internal.FlowLayout;

public class FirstFragment extends Fragment implements DetopAdapter.Check {


    private FragmentFirstBinding binding;

    private RecyclerView mRecycle;
    private DetopAdapter detopAdapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container , false);

        mRecycle = binding.rvDepto;
        detopAdapter = new DetopAdapter(ApartmentData.apartmentList(), this);
        mRecycle.setLayoutManager(new GridLayoutManager(getContext(),2));
        mRecycle.setAdapter(detopAdapter);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void passElement(Apartment apartment) {

        Bundle bundle = new Bundle();
        bundle.putString("Nombre", apartment.getBuildingName());
        bundle.putString("Numero", apartment.getUnitId());
        bundle.putString("Dirección", apartment.getAddress());
        bundle.putString("url", apartment.getUrlImageBuilding());
        Navigation.findNavController(binding.getRoot()).navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);
    }
}