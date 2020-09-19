package com.pruebacorte2.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Articulo {
    private String section_id;
    private String seccion;
    private String title;
    //private String abstract;
    private String doi;
    private String date_published;
    private List<String> keywords;
    private List<Galey> galeys;
    private List<Autor> authors;

    public String getSection_id() {
        return section_id;
    }

    public void setSection_id(String section_id) {
        this.section_id = section_id;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getDate_published() {
        return date_published;
    }

    public void setDate_published(String date_published) {
        this.date_published = date_published;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<Galey> getGaleys() {
        return galeys;
    }

    public void setGaleys(List<Galey> galeys) {
        this.galeys = galeys;
    }

    public List<Autor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Autor> authors) {
        this.authors = authors;
    }

    public Articulo(String section_id, String seccion, String title, String doi, String date_published, List<String> keywords, List<Galey> galeys, List<Autor> authors) {
        this.section_id = section_id;
        this.seccion = seccion;
        this.title = title;
        this.doi = doi;
        this.date_published = date_published;
        this.keywords = keywords;
        this.galeys = galeys;
        this.authors = authors;
    }

        public Articulo(JSONObject jsonObject) throws JSONException {
        this.section_id = jsonObject.getString("section_id");
        this.seccion = jsonObject.getString("section");
        this.title = jsonObject.getString("title");
        this.doi = jsonObject.getString("doi");
        this.date_published = jsonObject.getString("date_published");
        this.keywords = obtenerPalabrasClaves(jsonObject.getJSONArray("keywords"));
        this.galeys = Galey.JsonObjectsBuild(jsonObject.getJSONArray("galeys"));
        this.authors = Autor.JsonObjectsBuild(jsonObject.getJSONArray("authors"));
    }

    public static ArrayList<Articulo> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Articulo> ltArticulo = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            ltArticulo.add(new Articulo(datos.getJSONObject(i)));
        }
        return ltArticulo;
    }

    public  List<String> obtenerPalabrasClaves(JSONArray datos) throws JSONException {
        ArrayList<String> ltPalabras = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            ltPalabras.add(datos.getJSONObject(i).getString("keyword"));
        }
        return ltPalabras;
    }
}

