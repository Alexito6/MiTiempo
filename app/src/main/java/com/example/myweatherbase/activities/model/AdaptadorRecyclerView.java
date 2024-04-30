package com.example.myweatherbase.activities.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myweatherbase.R;
import com.example.myweatherbase.base.ImageDownloader;
import com.example.myweatherbase.base.Parameters;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class AdaptadorRecyclerView extends RecyclerView.Adapter<AdaptadorRecyclerView.ViewHolder> {
    private LayoutInflater layoutInflater;
    private Root root;
    private View.OnClickListener onClickListener;
    public AdaptadorRecyclerView(Context context,Root root){
        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.root=root;
    }

    @NonNull
    @Override
    public AdaptadorRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=layoutInflater.inflate(R.layout.simple_element,viewGroup,false);
        view.setOnClickListener(onClickListener);
        return new ViewHolder(view);
    }
    public void setOnClickListener(View.OnClickListener onClickListener){
        this.onClickListener=onClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecyclerView.ViewHolder viewHolder, int i) {
        Date date = new Date((long)root.list.get(i).dt*1000);
        SimpleDateFormat dateDayOfWeek = new SimpleDateFormat("EEEE");
        SimpleDateFormat dateDay = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat horaMinutos = new SimpleDateFormat("HH:mm");

        viewHolder.diaSemana.setText(dateDayOfWeek.format(date));
        viewHolder.hora.setText(horaMinutos.format(date));
        viewHolder.fecha.setText(dateDay.format(date));

        viewHolder.temperatura.setText(viewHolder.temperatura.getTag().toString()+" "+root.list.get(i).main.temp+"º");
        viewHolder.temp_max.setText(viewHolder.temp_max.getTag().toString()+" "+root.list.get(i).main.temp_max+"º");
        viewHolder.temp_min.setText(viewHolder.temp_min.getTag().toString()+" "+root.list.get(i).main.temp_min+"º");

        viewHolder.estadoCielo.setText(root.list.get(i).weather.get(0).description);
        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + root.list.get(i).weather.get(0).icon + Parameters.ICON_URL_POST, viewHolder.imagenTiempo);
    }

    @Override
    public int getItemCount() {
        return root.list.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imagenTiempo;
        private TextView diaSemana;
        private TextView estadoCielo;
        private TextView temperatura;
        private TextView fecha;
        private TextView temp_max;
        private TextView hora;
        private TextView temp_min;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            imagenTiempo=itemView.findViewById(R.id.imagenTiempo);
            diaSemana=itemView.findViewById(R.id.diaSemana);
            estadoCielo=itemView.findViewById(R.id.estadoCielo);
            temperatura=itemView.findViewById(R.id.temperatura);
            fecha=itemView.findViewById(R.id.fecha);
            temp_min=itemView.findViewById(R.id.temp_min);
            temp_max=itemView.findViewById(R.id.temp_max);
            hora=itemView.findViewById(R.id.hora);
        }
    }

}
