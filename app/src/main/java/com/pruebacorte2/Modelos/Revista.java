package com.pruebacorte2.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Revista {
    private String  id;
    private String  nombre;
    private String  descripcion;
    private String  abreviatura;
    private String  imagen;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Revista(String id, String nombre, String descripcion, String abreviatura, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.abreviatura = abreviatura;
        this.imagen = imagen;
    }

    public Revista(JSONObject jsonObject) throws JSONException {
        id=jsonObject.getString("journal_id").toString();
        nombre=jsonObject.getString("name").toString();
        descripcion=jsonObject.getString("description").toString();
        abreviatura=jsonObject.getString("abbreviation").toString();
        imagen=jsonObject.getString("portada").toString();
    }

    public static ArrayList<Revista> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Revista> ltRevista = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            ltRevista.add(new Revista(datos.getJSONObject(i)));
        }
        return ltRevista;
    }

}
