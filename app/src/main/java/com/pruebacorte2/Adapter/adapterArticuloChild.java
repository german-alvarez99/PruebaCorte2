package com.pruebacorte2.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pruebacorte2.Modelos.Articulo;
import com.pruebacorte2.R;

import java.util.List;

public class adapterArticuloChild extends RecyclerView.Adapter<adapterArticuloChild.ViewHolderArticulo> {
    List<Articulo> lstArticulos;

    public adapterArticuloChild(List<Articulo> lstArticulos) {
        this.lstArticulos = lstArticulos;
    }

    @NonNull
    @Override
    public ViewHolderArticulo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_articulos_child, null, false);
        return new adapterArticuloChild.ViewHolderArticulo(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderArticulo holder, int position) {
        holder.txtTitulo.setText(lstArticulos.get(position).getTitle());
        holder.txtPalabrasClaves.setText(parsearPalabrasClaves(lstArticulos.get(position).getKeywords()));
        holder.txtDoi.setText(lstArticulos.get(position).getDoi());
        holder.txtFecha.setText(lstArticulos.get(position).getDate_published());

        for (int e=0;e<lstArticulos.get(position).getGaleys().size();e++){
            if(lstArticulos.get(position).getGaleys().get(e).getLabel().equals("PDF")){
                holder.btnPdf.setVisibility(View.VISIBLE);
            }
            if(lstArticulos.get(position).getGaleys().get(e).getLabel().equals("HTML")){
                holder.btnHtml.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return lstArticulos.size();
    }

    public String parsearPalabrasClaves(List<String> datos){
        String palabras="keywords: ";
        for (int i=0; i<datos.size();i++)
            palabras+=datos.get(i)+", ";
        return palabras.substring(0,palabras.length()-2);
    }

    public class ViewHolderArticulo extends RecyclerView.ViewHolder {
        TextView txtTitulo, txtPalabrasClaves, txtDoi, txtFecha;
        Button btnPdf, btnHtml;

//        String titulo, PalabrasClaves, doi, fecha;

        public ViewHolderArticulo(@NonNull View itemView) {
            super(itemView);
            txtTitulo = (TextView) itemView.findViewById(R.id.txtTituloArticuloListar);
            txtPalabrasClaves = (TextView) itemView.findViewById(R.id.txtPClaveArticuloListar);
            txtDoi = (TextView) itemView.findViewById(R.id.txtDoiArticuloListar);
            txtFecha = (TextView) itemView.findViewById(R.id.txtFechaArticuloListar);
            btnPdf=itemView.findViewById(R.id.btnPdfActiculos);
            btnHtml=itemView.findViewById(R.id.btnHtmlArticulos);
        }
    }
}
