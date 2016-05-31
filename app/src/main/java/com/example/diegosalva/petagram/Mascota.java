package com.example.diegosalva.petagram;

/**
 * Created by DIEGO SALVA on 29/05/2016.
 */
public class Mascota {
    private String nombre;
    private int foto;

    public Mascota (int foto, String nombre){
        this.nombre= nombre;
        this.foto=foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }



}


