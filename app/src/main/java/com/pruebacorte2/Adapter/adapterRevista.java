package com.pruebacorte2.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
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
        holder.txtDescripcion.setText(lstRevista.get(position).getDescripcion());
        Glide.with(holder.itemView)
                .load(lstRevista.get(position).getImagen())
                .into(holder.imgRevista);
    }

    @Override
    public int getItemCount() {
        return lstRevista.size();
    }

    public class ViewHolderRevista extends RecyclerView.ViewHolder {
        TextView txtTitulo, txtDescripcion;
        ImageView imgRevista;

        public ViewHolderRevista(@NonNull View itemView) {
            super(itemView);
            txtTitulo= (TextView) itemView.findViewById(R.id.txtTituloRevista);
            txtDescripcion= (TextView) itemView.findViewById(R.id.txtDescrionRevista);
            imgRevista = itemView.findViewById(R.id.imgImagenRevista);
        }
    }
}
