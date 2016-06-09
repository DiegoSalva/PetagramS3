package com.example.diegosalva.petagram.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.diegosalva.petagram.pojo.Mascota;
import com.example.diegosalva.petagram.adapter.MascotaAdaptador;
import com.example.diegosalva.petagram.R;

import java.util.ArrayList;


public class Fragment_RecycleView extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_fragment__recycle_view, container, false);
        //return super.onCreateView(inflater, container, savedInstanceState);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        listaMascotas.setHasFixedSize(true);

        LinearLayoutManager llm= new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        DataSetMascotas();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        //crear objeto mascotaAdaptador setear la lista y que pueda hacer lo configurado
        MascotaAdaptador adaptador= new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);

    }

    public void DataSetMascotas(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.ayudantesanta, "Ayudante de Santa"));
        mascotas.add(new Mascota(R.drawable.brian, "Brian Griffin"));
        mascotas.add(new Mascota(R.drawable.snoopy, "Snoopy Brown"));
        mascotas.add(new Mascota(R.drawable.coraje, "Coraje"));
        mascotas.add(new Mascota(R.drawable.patan, "Patan"));
        mascotas.add(new Mascota(R.drawable.scoobyimg, "Scooby"));
        mascotas.add(new Mascota(R.drawable.scrappy, "Scrappy"));
        mascotas.add(new Mascota(R.drawable.jake, "Jake"));
        mascotas.add(new Mascota(R.drawable.firulais, "Firulais"));
        mascotas.add(new Mascota(R.drawable.spike, "Spike"));

    }
}
