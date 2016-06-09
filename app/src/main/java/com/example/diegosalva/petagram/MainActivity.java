package com.example.diegosalva.petagram;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.diegosalva.petagram.adapter.PageAdapter;
import com.example.diegosalva.petagram.fragment.Fragment_RecycleView;
import com.example.diegosalva.petagram.fragment.MascotaFragment;
import com.example.diegosalva.petagram.menuopciones.Acerca;
import com.example.diegosalva.petagram.menuopciones.Contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getSupportActionBar().setDisplayShowTitleEnabled(false);//Elimina el título del style de la Actionbar

        //Registro de las herramientas toolbar, tablayout y viewpager
        toolbar=(Toolbar) findViewById(R.id.toolBar);
        tabLayout=(TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        if(toolbar!=null){
            setSupportActionBar(toolbar);
        }

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionbar);
        setSupportActionBar(miActionBar);

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mContacto:
                Intent intentContacto = new Intent(this, Contacto.class);
                startActivity(intentContacto);
                break;
            case R.id.mAcerca:
                Intent intentAcerca= new Intent(this, Acerca.class);
                startActivity(intentAcerca);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void irFavoritos(View v){
        Intent intent = new Intent(MainActivity.this, Favoritos.class);
        //intent.putExtra("listado",mascotas);
        startActivity(intent);
    }

   private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Fragment_RecycleView());
        fragments.add(new MascotaFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.dog);
    }
}
