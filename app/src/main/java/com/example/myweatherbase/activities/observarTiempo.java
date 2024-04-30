package com.example.myweatherbase.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.List;
import com.example.myweatherbase.activities.model.Root;
import com.example.myweatherbase.base.ImageDownloader;
import com.example.myweatherbase.base.Parameters;

import java.text.SimpleDateFormat;
import java.util.Date;

public class observarTiempo extends AppCompatActivity {
    private Button atras;
    private ImageView imagenTiempo;
    private TextView diaDeLaSemana,horaDelDia,tempMax,tempMin,estadoTiempo,fechaCompleta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.observar_tiempo);
        atras=findViewById(R.id.botonVolver);
        imagenTiempo=findViewById(R.id.imageTime);
        diaDeLaSemana=findViewById(R.id.dia_Semana);
        horaDelDia=findViewById(R.id.horaDelDia);
        tempMax=findViewById(R.id.tempMax);
        tempMin=findViewById(R.id.tempMin);
        estadoTiempo=findViewById(R.id.estadoTiempo);
        fechaCompleta=findViewById(R.id.fechaCompleta);

        Bundle extras =getIntent().getExtras();

        List datosDelTiempo= (List) extras.get("datosTiempo");
        Date date = new Date((long)datosDelTiempo.dt*1000);
        SimpleDateFormat dateDayOfWeek = new SimpleDateFormat("EEEE");
        SimpleDateFormat dateDay = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat horaMinutos = new SimpleDateFormat("HH:mm");
        diaDeLaSemana.setText(dateDayOfWeek.format(date));
        horaDelDia.setText(horaMinutos.format(date));
        fechaCompleta.setText(dateDay.format(date));

        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + datosDelTiempo.weather.get(0).icon + Parameters.ICON_URL_POST, imagenTiempo);
        tempMax.setText(tempMax.getTag().toString()+" "+datosDelTiempo.main.temp_max+"º");
        tempMin.setText(tempMin.getTag().toString()+" "+datosDelTiempo.main.temp_min+"º");
        estadoTiempo.setText(datosDelTiempo.weather.get(0).description);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
