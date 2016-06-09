package com.example.diegosalva.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.diegosalva.petagram.pojo.Mascota;
import com.example.diegosalva.petagram.adapter.MascotaAdaptador;

import java.util.ArrayList;

public class Favoritos extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public MascotaAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar miActionBar= (Toolbar) findViewById(R.id.miActionbar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//Habilita el boton de regresar en el Actionbar
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        listaMascotas = (RecyclerView)findViewById(R.id.rvMascotas);

        LinearLayoutManager llm= new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        DataSetFavoritos();
        inicializarAdaptador();

    }

      public void DataSetFavoritos(){
        mascotas =new ArrayList<>();
          mascotas.add(new Mascota(R.drawable.brian, "Brian Griffin"));
          mascotas.add(new Mascota(R.drawable.spike, "Spike"));
          mascotas.add(new Mascota(R.drawable.ayudantesanta, "Ayudante de Santa"));
          mascotas.add(new Mascota(R.drawable.coraje, "Coraje"));
          mascotas.add(new Mascota(R.drawable.scrappy, "Scrappy"));


    }


    private void inicializarAdaptador(){
        adaptador= new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);

    }


}
