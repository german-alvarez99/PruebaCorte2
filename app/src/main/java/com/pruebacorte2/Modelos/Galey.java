package com.pruebacorte2.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Galey {
    private String label;
    private String UrlViewGalley;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUrlViewGalley() {
        return UrlViewGalley;
    }

    public void setUrlViewGalley(String urlViewGalley) {
        UrlViewGalley = urlViewGalley;
    }

    public Galey(String label, String urlViewGalley) {
        this.label = label;
        UrlViewGalley = urlViewGalley;
    }

        public Galey(JSONObject jsonObject) throws JSONException {
        label=jsonObject.getString("label");
        UrlViewGalley=jsonObject.getString("UrlViewGalley");
    }

    public static ArrayList<Galey> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Galey> ltGaley = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            ltGaley.add(new Galey(datos.getJSONObject(i)));
        }
        return ltGaley;
    }
}
