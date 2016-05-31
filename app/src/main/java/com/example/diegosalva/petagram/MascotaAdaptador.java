package com.example.diegosalva.petagram;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by DIEGO SALVA on 29/05/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override //Inflar el layout y lo pasará al viewholder para que el obtenga los view
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pet, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override //Asocia cada elemento de la lista con el view
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        final Mascota mascota= mascotas.get(position);
        holder.ivFotoCV.setImageResource(mascota.getFoto());
        holder.tvNombreCV.setText(mascota.getNombre());

        holder.ibHuesoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Like "+ mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override //Devuelve la cantidad de elementos
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivFotoCV;
        private TextView tvNombreCV;
        private ImageButton ibHuesoB;

        public MascotaViewHolder (View itemView){
            super(itemView);

            ivFotoCV = (ImageView) itemView.findViewById(R.id.ivFotoCV);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            ibHuesoB = (ImageButton) itemView.findViewById(R.id.ibHuesoB);

        }

    }
}
