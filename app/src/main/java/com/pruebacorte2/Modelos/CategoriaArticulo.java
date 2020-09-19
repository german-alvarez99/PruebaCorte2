package com.pruebacorte2.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CategoriaArticulo {
    private String section_id;
    private String section;

    public String getSection_id() {
        return section_id;
    }

    public void setSection_id(String section_id) {
        this.section_id = section_id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public CategoriaArticulo(String section_id, String section) {
        this.section_id = section_id;
        this.section = section;
    }

    public CategoriaArticulo(JSONObject jsonObject) throws JSONException {
        this.section_id = jsonObject.getString("section_id");
        this.section = jsonObject.getString("section");
    }

    public static ArrayList<CategoriaArticulo> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<CategoriaArticulo> ltCategoriaArticulo = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            ltCategoriaArticulo.add(new CategoriaArticulo(datos.getJSONObject(i)));
        }
        return ltCategoriaArticulo;
    }
}
