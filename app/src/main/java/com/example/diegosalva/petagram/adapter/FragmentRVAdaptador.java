package com.example.diegosalva.petagram.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diegosalva.petagram.R;
import com.example.diegosalva.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by DIEGO SALVA on 09/06/2016.
 */
public class FragmentRVAdaptador extends RecyclerView.Adapter<FragmentRVAdaptador.MiMascotaViewHolder>{
    ArrayList<Mascota> mascotas;
    Activity activity;

    public FragmentRVAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override //Inflar el layout y lo pasará al viewholder para que el obtenga los view
    public MiMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_petgrid, parent, false);
        return new MiMascotaViewHolder(v);
    }

    @Override //Asocia cada elemento de la lista con el view
    public void onBindViewHolder(MiMascotaViewHolder holder, int position) {
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

    public class MiMascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivFotoCV;
        private TextView tvNombreCV;
        private ImageButton ibHuesoB;

        public MiMascotaViewHolder (View itemView){
            super(itemView);

            ivFotoCV = (ImageView) itemView.findViewById(R.id.ivFotoCV);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            ibHuesoB = (ImageButton) itemView.findViewById(R.id.ibHuesoB);

        }
    }
}
