package com.pruebacorte2.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class EdicionRevista {
    private String id;
    private String titulo;
    private String volumen;
    private String numero;
    private String anio;
    private String imagen;
    private String doi;
    private String fecha;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public EdicionRevista(String id, String titulo, String volumen, String numero, String anio, String imagen, String doi, String fecha) {
        this.id = id;
        this.titulo = titulo;
        this.volumen = volumen;
        this.numero = numero;
        this.anio = anio;
        this.imagen = imagen;
        this.doi = doi;
        this.fecha = fecha;
    }

    public EdicionRevista(JSONObject jsonObject) throws JSONException {
        id=jsonObject.getString("issue_id").toString();
        titulo=jsonObject.getString("title").toString();
        volumen=jsonObject.getString("volume").toString();
        numero=jsonObject.getString("number").toString();
        anio="("+jsonObject.getString("year").toString()+")";
        imagen=jsonObject.getString("cover").toString();
        doi="DOI:"+jsonObject.getString("doi").toString();
        fecha="Fecha de publicación"+jsonObject.getString("date_published").toString();
    }

    public static ArrayList<EdicionRevista> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<EdicionRevista> ltEdicionRevista = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            ltEdicionRevista.add(new EdicionRevista(datos.getJSONObject(i)));
        }
        return ltEdicionRevista;
    }
}
