package com.pruebacorte2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.pruebacorte2.Adapter.adapterEdicionRevista;
import com.pruebacorte2.Adapter.adapterRevista;
import com.pruebacorte2.Modelos.EdicionRevista;
import com.pruebacorte2.Modelos.Revista;
import com.pruebacorte2.WebService.Asynchtask;
import com.pruebacorte2.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity implements Asynchtask {

    private TextView txtTituloC,txtDescripcionC;
    private ImageView imgImagenRevistaC;
    private String idRevistaUtilizar="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setTitle("Información de la Revista");

        MainActivity.handleSSLHandshake();
        Intent i = getIntent();
        idRevistaUtilizar=i.getStringExtra("idRevista");

        txtTituloC=(TextView) findViewById(R.id.txtTituloRevistaLista);
        txtDescripcionC=(TextView) findViewById(R.id.txtDescrionRevistaLista);
        imgImagenRevistaC=(ImageView) findViewById(R.id.imgImagenRevistaLista);

        txtTituloC.setText(i.getStringExtra("titulo"));
        txtDescripcionC.setText(i.getStringExtra("descripcion"));
        Glide.with(this)
                .load(i.getStringExtra("imagen"))
                .into(imgImagenRevistaC);

        //web service
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/issues.php?j_id="+idRevistaUtilizar,
                datos, MainActivity2.this, MainActivity2.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<EdicionRevista> lstEdicionRevista = new ArrayList<EdicionRevista> ();
        try {
            JSONArray JSONlistaEdicionRevista= new JSONArray(result);
            lstEdicionRevista = EdicionRevista.JsonObjectsBuild(JSONlistaEdicionRevista);

            //agregar datos al recyclerView
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcEdicionRevista);
            recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

//            recyclerView.setLayoutManager(new GridLayoutManager(this,3));

            adapterEdicionRevista adapter= new adapterEdicionRevista(lstEdicionRevista);
            recyclerView.setAdapter(adapter);
        }catch (JSONException e)
        {
            Toast.makeText(this.getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
        }
    }
}