package com.pruebacorte2.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pruebacorte2.MainActivity;
import com.pruebacorte2.MainActivity2;
import com.pruebacorte2.MainActivity3;
import com.pruebacorte2.Modelos.EdicionRevista;
import com.pruebacorte2.R;

import java.util.List;

public class adapterEdicionRevista extends RecyclerView.Adapter<adapterEdicionRevista.ViewHolderEdicionRevista> {

    List<EdicionRevista> lstEdicionRevista;

    public adapterEdicionRevista(List<EdicionRevista> lstEdicionRevista) {
        this.lstEdicionRevista = lstEdicionRevista;
    }

    @NonNull
    @Override
    public ViewHolderEdicionRevista onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_ediciones_revista,null,false);
        return new adapterEdicionRevista.ViewHolderEdicionRevista(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderEdicionRevista holder, int position) {
        holder.txtTitulo.setText(lstEdicionRevista.get(position).getTitulo());
        holder.txtVolumen.setText(lstEdicionRevista.get(position).getVolumen());
        holder.txtNumero.setText(lstEdicionRevista.get(position).getNumero());
        holder.txtAnio.setText(lstEdicionRevista.get(position).getAnio());
        holder.txtDoi.setText(lstEdicionRevista.get(position).getDoi());
        holder.txtFecha.setText(lstEdicionRevista.get(position).getFecha());
        Glide.with(holder.itemView)
                .load(lstEdicionRevista.get(position).getImagen())
                .into(holder.imgEdicionRevista);

        holder.titulo=lstEdicionRevista.get(position).getTitulo();
        holder.volumen=lstEdicionRevista.get(position).getVolumen();
        holder.numero=lstEdicionRevista.get(position).getNumero();
        holder.anio=lstEdicionRevista.get(position).getAnio();
        holder.doi=lstEdicionRevista.get(position).getDoi();
        holder.fecha=lstEdicionRevista.get(position).getFecha();
        holder.imagen=lstEdicionRevista.get(position).getImagen();
        holder.idEdicion=lstEdicionRevista.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return lstEdicionRevista.size();
    }

    public class ViewHolderEdicionRevista extends RecyclerView.ViewHolder {
        TextView txtTitulo, txtVolumen,txtNumero, txtAnio,txtDoi,txtFecha;
        ImageView imgEdicionRevista;

        String idEdicion ,titulo, volumen,numero, anio,doi,fecha,imagen;

        public ViewHolderEdicionRevista(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(view.getContext(), MainActivity3.class);
                    String idRevista=MainActivity2.getIdRevistaUtilizar();
                    i.putExtra("idRevista",  idRevista);
                    i.putExtra("idEdicion",  idEdicion);
                    i.putExtra("titulo",  titulo);
                    i.putExtra("volumen",  volumen);
                    i.putExtra("numero",  numero);
                    i.putExtra("anio",  anio);
                    i.putExtra("doi",  doi);
                    i.putExtra("fecha",  fecha);
                    i.putExtra("imagen",  imagen);
                    view.getContext().startActivity(i);
                }
            });

            txtTitulo= (TextView) itemView.findViewById(R.id.txtTituloEdicionRevista);
            txtVolumen= (TextView) itemView.findViewById(R.id.txtVolumenEdicion);
            txtNumero= (TextView) itemView.findViewById(R.id.txtNumeroEdicion);
            txtAnio= (TextView) itemView.findViewById(R.id.txtAnioEdicion);
            txtFecha= (TextView) itemView.findViewById(R.id.txtFechaEdicion);
            txtDoi= (TextView) itemView.findViewById(R.id.txtDoiEdicion);
            imgEdicionRevista= (ImageView) itemView.findViewById(R.id.imgImagenEdicionRevista);
        }
    }
}
