package com.example.myweatherbase.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myweatherbase.API.Connector;
import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.AdaptadorRecyclerView;
import com.example.myweatherbase.activities.model.List;
import com.example.myweatherbase.activities.model.Root;
import com.example.myweatherbase.base.BaseActivity;
import com.example.myweatherbase.base.CallInterface;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SecondActivity extends BaseActivity implements CallInterface,View.OnClickListener{
    private RecyclerView recyclerView;
    private Root root;
    private FloatingActionButton irSelector;
    private String latitud;
    private TextView nombreCiudad;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        recyclerView=findViewById(R.id.RecyclerView);
        irSelector=findViewById(R.id.volverSelector);
        nombreCiudad=findViewById(R.id.nombreCiudad);
        Bundle extras=getIntent().getExtras();
        nombreCiudad.setText(extras.get("nombre_ciudad").toString());
        latitud= (String) extras.get("datosCiudad");
        // Mostramos la barra de progreso y ejecutamos la llamada a la API
        showProgress();
        executeCall(this);
    }
    @Override
    public void onClick(View view){
        List tiempo=root.list.get(recyclerView.getChildAdapterPosition(view));
        Intent intent =new Intent(this,observarTiempo.class);
        intent.putExtra("datosTiempo",tiempo);
        startActivity(intent);
    }

    // Realizamos la llamada y recogemos los datos en un objeto Root
    @Override
    public void doInBackground() {
        root = Connector.getConector().get(Root.class,latitud);
    }

    // Una vez ya se ha realizado la llamada, ocultamos la barra de progreso y presentamos los datos
    @Override
    public void doInUI() {
        hideProgress();
        AdaptadorRecyclerView adaptador=new AdaptadorRecyclerView(this,root);
        adaptador.setOnClickListener(this);
        recyclerView.setAdapter(adaptador);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        irSelector.setOnClickListener(view -> {
            finish();
        });
    }
}