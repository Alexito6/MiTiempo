package com.example.myweatherbase.activities;

import java.util.List;

public enum Ciudades {
    VALENCIA("&lat=39.5862518&lon=-0.5411163"),
    MADRID("&lat=40.4010214&lon=-3.6964752"),
    SEVILLA("&lat=37.3598402&lon=-6.0043645"),
    ZARAGOZA("&lat=41.669254&lon=-0.9576379"),
    MALAGA("&lat=36.702802&lon=-4.476733"),
    MURCIA("&lat=37.980255&lon=-1.120996"),
    LAS_PALMAS("&lat=40.046532&lon=0.026118"),
    ALICANTE("&lat=38.363110&lon=-0.479402"),
    BILBAO("&lat=43.256043&lon=-2.929790");
    private String latitud;
    Ciudades(String latitud_longitud){
        this.latitud=latitud_longitud;
    }

    public String getLatitud() {
        return latitud;
    }
}