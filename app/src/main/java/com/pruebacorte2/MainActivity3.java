package com.pruebacorte2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.pruebacorte2.Adapter.adapterArticuloMain;
import com.pruebacorte2.Modelos.Articulo;
import com.pruebacorte2.Modelos.ArticuloMain;
import com.pruebacorte2.Modelos.CategoriaArticulo;
import com.pruebacorte2.WebService.Asynchtask;
import com.pruebacorte2.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity3 extends AppCompatActivity implements Asynchtask {

    private int ban;
    private List<Articulo> lstArticulo;
    private List<ArticuloMain> lstArticuloMain;
    private static String idEdicionSeleccionada = "", categoria = "";
    private static Context ctx;

    private RequestQueue request;
    private StringRequest stringr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //--------------Cargar valores de la actividad anterior
        TextView txtTitulo, txtVolumen, txtNumero, txtAnio, txtDoi, txtFecha;
        ImageView imgEdicionRevista;

        txtTitulo = (TextView) findViewById(R.id.txtTituloArticulosER);
        txtVolumen = (TextView) findViewById(R.id.txtVolumenArticulosER);
        txtNumero = (TextView) findViewById(R.id.txtNumeroArticulosER);
        txtAnio = (TextView) findViewById(R.id.txtAnioArticulosER);
        txtFecha = (TextView) findViewById(R.id.txtFechaArticulosER);
        txtDoi = (TextView) findViewById(R.id.txtDoiArticulosER);
        imgEdicionRevista = (ImageView) findViewById(R.id.imgImagenArticulosER);

        MainActivity.handleSSLHandshake();
        Intent i = getIntent();
        idEdicionSeleccionada = i.getStringExtra("idEdicion");
        txtTitulo.setText(i.getStringExtra("titulo"));
        txtVolumen.setText(i.getStringExtra("volumen"));
        txtNumero.setText(i.getStringExtra("numero"));
        txtAnio.setText(i.getStringExtra("anio"));
        txtFecha.setText(i.getStringExtra("fecha"));
        txtDoi.setText(i.getStringExtra("doi"));
        Glide.with(this)
                .load(i.getStringExtra("imagen"))
                .into(imgEdicionRevista);
        ctx=this;
        lstArticuloMain=new ArrayList<ArticuloMain>();
        lstArticulo=new ArrayList<Articulo>();
        //--------------Fin de Cargar valores de la actividad anterior

        //Llamar al ws de categoris de articulos por IdEdiccionRevista
        lstArticuloMain = new ArrayList<ArticuloMain>();
        Map<String, String> datos = new HashMap<>();
        WebService ws = new WebService("https://revistas.uteq.edu.ec/ws/pubs.php?i_id=" + idEdicionSeleccionada,
                datos, MainActivity3.this, MainActivity3.this);
        ws.execute("GET");
    }

//    public void ejecutarWS2() {
//        ban = 1;
//        for (int j = 0; j < lstCategoriaArticulo.size(); j++) {
//            Map<String, String> datos = new HashMap<String, String>();
//            WebService ws = new WebService("https://revistas.uteq.edu.ec/ws/pubs.php?i_id=" + idEdicionSeleccionada + "&section=" + lstCategoriaArticulo.get(j).getId(),
//                    datos, MainActivity3.this, MainActivity3.this);
//            ws.execute("GET");
//            lstArticuloMain.add(new ArticuloMain(lstCategoriaArticulo.get(j).getSection(), lstArticulo));
//        }
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcArticulosER);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
//        adapterArticuloMain adapter = new adapterArticuloMain(lstArticuloMain);
//        recyclerView.setAdapter(adapter);
//    }

    @Override
    public void processFinish(String result) throws JSONException {
        List<String> lstCategoria = new ArrayList<String>();
        List<Articulo> lstArticulosProvicional = new ArrayList<Articulo>();
        lstArticuloMain=new ArrayList<ArticuloMain>();
        try {
            lstArticulo = new ArrayList<>();
            JSONArray JSONlistaArticulo = new JSONArray(result);
            lstArticulo = Articulo.JsonObjectsBuild(JSONlistaArticulo);
            //obtener categorias
            for(int i=0; i<lstArticulo.size();i++)
            {
                if(!lstCategoria.contains(lstArticulo.get(i).getSeccion()))
                    lstCategoria.add(lstArticulo.get(i).getSeccion());
            }

            //obtener Articulos de categorias
            for(int i=0; i<lstCategoria.size();i++)
            {
                for(int j=0;j<lstArticulo.size();j++)
                {
                    lstArticulosProvicional.add(lstArticulo.get(j));
                }
                lstArticuloMain.add(new ArticuloMain(lstCategoria.get(i), lstArticulosProvicional));
            }
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcArticulosER);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
            adapterArticuloMain adapter = new adapterArticuloMain(lstArticuloMain);
            recyclerView.setAdapter(adapter);
        } catch (JSONException e) {
            Toast.makeText(this.getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
        }
    }
}