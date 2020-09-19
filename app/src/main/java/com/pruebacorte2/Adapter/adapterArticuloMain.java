package com.pruebacorte2.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pruebacorte2.Modelos.ArticuloMain;
import com.pruebacorte2.R;

import java.util.List;

public class adapterArticuloMain extends RecyclerView.Adapter<adapterArticuloMain.ViewHolderArticuloMain> {

    List<ArticuloMain> lstArticulosMain;

    public adapterArticuloMain(List<ArticuloMain> lstArticulosMain) {
        this.lstArticulosMain = lstArticulosMain;
    }

    @NonNull
    @Override
    public ViewHolderArticuloMain onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_articulos_main, null, false);
        return new adapterArticuloMain.ViewHolderArticuloMain(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderArticuloMain holder, int position) {
        holder.txtCategoria.setText(lstArticulosMain.get(position).getCategoriaArticulo());
        holder.rcChild.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(),RecyclerView.VERTICAL,false));
        adapterArticuloChild adapter= new adapterArticuloChild(lstArticulosMain.get(position).getLstArticulo());
        holder.rcChild.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return lstArticulosMain.size();
    }

    public class ViewHolderArticuloMain extends RecyclerView.ViewHolder {
        TextView txtCategoria;
        RecyclerView rcChild;

        public ViewHolderArticuloMain(@NonNull View itemView) {
            super(itemView);
            txtCategoria = itemView.findViewById(R.id.txtCategoriaArticulo);
            rcChild = itemView.findViewById(R.id.rcArticulos);
        }
    }
}
