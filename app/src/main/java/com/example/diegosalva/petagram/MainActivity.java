package com.example.diegosalva.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public MascotaAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar=(Toolbar) findViewById(R.id.miActionbar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);//Elimina el título del style de la Actionbar

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        listaMascotas.setHasFixedSize(true);

        LinearLayoutManager llm= new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        DataSetMascotas();
        inicializarAdaptador();
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mFavoritos:
                Toast.makeText(this, "Cinco favoritos", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(MainActivity.this, Favoritos.class);
                startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }


    public void inicializarAdaptador(){
        adaptador= new MascotaAdaptador(mascotas, this);
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
