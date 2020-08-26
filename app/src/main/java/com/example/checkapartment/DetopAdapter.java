package com.example.checkapartment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.checkapartment.databinding.DeptoListDataBinding;

import java.util.List;

public class DetopAdapter extends RecyclerView.Adapter<DetopAdapter.ApartViewHolder> {

        private List <Apartment>  apartmentList;
        private Check mCheck;

    public DetopAdapter(List<Apartment> apartmentList, Check mCheck) {
        this.apartmentList = apartmentList;
        this.mCheck = mCheck;
    }

    @NonNull
    @Override
    public ApartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DeptoListDataBinding binding = DeptoListDataBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ApartViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ApartViewHolder holder, int position) {
        Apartment apartment = apartmentList.get(position);
        holder.txtname.setText(apartment.getBuildingName());
        holder.txtnumero.setText(apartment.getUnitId());
        holder.txtdirecc.setText(apartment.getAddress());
        Glide.with(holder.image_depto.getContext()).load(apartment.getUrlImageBuilding()).into(holder.image_depto);
    }

    @Override
    public int getItemCount() {
        return apartmentList.size();
    }


    public  class ApartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

       private ImageView image_depto;
       private TextView txtname;
       private TextView txtnumero;
       private TextView txtdirecc;


       public ApartViewHolder(@NonNull DeptoListDataBinding binding) {
           super(binding.getRoot());
           image_depto = binding.imageDepto;
           txtname = binding.txtname;
           txtnumero = binding.txtnumero;
           txtdirecc = binding.txtdirecc;
           itemView.setOnClickListener(this);

       }

        @Override
        public void onClick(View view) {
           int position = getLayoutPosition();
           Apartment apartment = apartmentList.get(position);
           mCheck.passElement(apartment);

        }
    }

   public interface Check{
        void passElement (Apartment  apartment);
   }

}
