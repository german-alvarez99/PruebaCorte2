package com.pruebacorte2.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Autor {
    private String nombres;
    private String filiacion;
    private String email;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getFiliacion() {
        return filiacion;
    }

    public void setFiliacion(String filiacion) {
        this.filiacion = filiacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Autor(String nombres, String filiacion, String email) {
        this.nombres = nombres;
        this.filiacion = filiacion;
        this.email = email;
    }

    public Autor(JSONObject jsonObject) throws JSONException {
        nombres = jsonObject.getString("nombres");
        filiacion = jsonObject.getString("filiacion");
        email = jsonObject.getString("email");
    }

    public static ArrayList<Autor> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Autor> ltAutor = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            ltAutor.add(new Autor(datos.getJSONObject(i)));
        }
        return ltAutor;
    }
}
