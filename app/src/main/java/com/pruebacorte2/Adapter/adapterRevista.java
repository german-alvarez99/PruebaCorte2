package com.pruebacorte2.Adapter;

import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pruebacorte2.MainActivity2;
import com.pruebacorte2.Modelos.Revista;
import com.pruebacorte2.R;

import java.util.List;

public class adapterRevista extends RecyclerView.Adapter<adapterRevista.ViewHolderRevista> {
    List<Revista> lstRevista;

    public adapterRevista(List<Revista> lstRevista) {
        this.lstRevista = lstRevista;
    }

    @NonNull
    @Override
    public ViewHolderRevista onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_revista,null,false);
        return new ViewHolderRevista(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderRevista holder, int position) {
        holder.txtTitulo.setText(lstRevista.get(position).getNombre());
        holder.txtDescripcion.setText(Html.fromHtml(lstRevista.get(position).getDescripcion()));
        Glide.with(holder.itemView)
                .load(lstRevista.get(position).getImagen())
                .into(holder.imgRevista);

        //dar valores a los parámetros
        holder.id=lstRevista.get(position).getId();
        holder.titulo=lstRevista.get(position).getNombre();
        holder.descripcion=lstRevista.get(position).getDescripcion();
        holder.imagen=lstRevista.get(position).getImagen();
    }

    @Override
    public int getItemCount() {
        return lstRevista.size();
    }

    public class ViewHolderRevista extends RecyclerView.ViewHolder {
        TextView txtTitulo, txtDescripcion;
        ImageView imgRevista;

        //parametros para actividad 2
        String id,titulo,descripcion,imagen;
        public ViewHolderRevista(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(view.getContext(), MainActivity2.class);
                    i.putExtra("idRevista",  id);
                    i.putExtra("titulo",  titulo);
                    i.putExtra("descripcion",  descripcion);
                    i.putExtra("imagen",  imagen);
                    view.getContext().startActivity(i);
                }
            });
            txtTitulo= (TextView) itemView.findViewById(R.id.txtTituloRevista);
            txtDescripcion= (TextView) itemView.findViewById(R.id.txtDescrionRevista);
            imgRevista = itemView.findViewById(R.id.imgImagenRevista);
        }
    }
}
