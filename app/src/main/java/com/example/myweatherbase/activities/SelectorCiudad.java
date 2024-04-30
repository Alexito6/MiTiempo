package com.example.myweatherbase.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myweatherbase.R;

import java.util.ArrayList;

public class SelectorCiudad extends AppCompatActivity {
    private ImageView imagenCiudad;
    private Spinner selectorCiudad;
    private Button pronostico;
    private String latitudYlongitud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selector_ciudad);
        imagenCiudad=findViewById(R.id.fotoCiudad);
        selectorCiudad=findViewById(R.id.spinnerCiudades);
        pronostico=findViewById(R.id.boton_Prevision);
        RepositorioCiudades ciudades=new RepositorioCiudades();
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ciudades.getAll());
        selectorCiudad.setAdapter(adapter);
        imagenCiudad.setImageResource(R.drawable.ciudaddelasartesylasciencias);
        pronostico.setOnClickListener(view -> {
            Intent intent=new Intent(this, SecondActivity.class);
            String ciudad= (String) selectorCiudad.getSelectedItem();
            if (ciudad.equals("Valencia")){
                latitudYlongitud=Ciudades.VALENCIA.getLatitud();
            } else if (ciudad.equals("Madrid")) {
                latitudYlongitud=Ciudades.MADRID.getLatitud();
            } else if (ciudad.equals("Sevilla")) {
                latitudYlongitud=Ciudades.SEVILLA.getLatitud();
            } else if (ciudad.equals("Zaragoza")) {
                latitudYlongitud=Ciudades.ZARAGOZA.getLatitud();
            } else if (ciudad.equals("Málaga")) {
                latitudYlongitud=Ciudades.MALAGA.getLatitud();
            } else if (ciudad.equals("Murcia")) {
                latitudYlongitud=Ciudades.MURCIA.getLatitud();
            } else if (ciudad.equals("Las Palmas")) {
                latitudYlongitud=Ciudades.LAS_PALMAS.getLatitud();
            } else if (ciudad.equals("Alicante")) {
                latitudYlongitud=Ciudades.ALICANTE.getLatitud();
            }
            intent.putExtra("datosCiudad",latitudYlongitud);
            intent.putExtra("nombre_ciudad",ciudad);
            startActivity(intent);
        });
    }
}
