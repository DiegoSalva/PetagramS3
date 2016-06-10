package com.example.diegosalva.petagram.menuopciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.diegosalva.petagram.R;

import javax.mail.internet.AddressException;

public class Contacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        //quitar icono 5 estrellas
        ImageView iv5Stars = (ImageView) findViewById(R.id.ivFiveStarts);
        iv5Stars.setVisibility(View.INVISIBLE);

    }

    public void enviaEmail(View v){
        EditText etEmail = (EditText) findViewById(R.id.etEmail);
        EditText etNombre = (EditText) findViewById(R.id.etNombre);
        EditText etMensaje = (EditText) findViewById(R.id.etMensaje);

        Toast.makeText(getBaseContext(), " Tu : " + etNombre.getText()  + " con mail : " + etEmail.getText()
                        + " Enviaste el mensaje: " + etMensaje.getText()
                , Toast.LENGTH_LONG).show();

    }

    public void enviarComentarios(View v) throws AddressException {

        EditText etEmail = (EditText) findViewById(R.id.etEmail);
        EditText etNombre = (EditText) findViewById(R.id.etNombre);
        EditText etMensaje = (EditText) findViewById(R.id.etMensaje);
        String email;
        String nombre;
        String mensaje;
        email = etEmail.getText().toString();
        nombre = etNombre.getText().toString();
        mensaje = etMensaje.getText().toString();
    }
}
