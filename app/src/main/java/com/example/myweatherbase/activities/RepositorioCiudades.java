package com.example.myweatherbase.activities;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCiudades {

    private List<String> nombresCiudad;
    private static RepositorioCiudades instance;
    public RepositorioCiudades(){
        this.nombresCiudad=new ArrayList<>();
        nombresCiudad.add("Valencia");
        nombresCiudad.add("Madrid");
        nombresCiudad.add("Sevilla");
        nombresCiudad.add("Zaragoza");
        nombresCiudad.add("Málaga");
        nombresCiudad.add("Murcia");
        nombresCiudad.add("Las Palmas");
        nombresCiudad.add("Alicante");
    }
    public static RepositorioCiudades getInstance(){
        if(instance==null)
            instance=new RepositorioCiudades();
        return instance;
    }
    public List<String> getAll(){
        return nombresCiudad;
    }
}
