package com.pruebacorte2.Modelos;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class ArticuloMain {
    private String categoriaArticulo;
    private List<Articulo> lstArticulo;

    public String getCategoriaArticulo() {
        return categoriaArticulo;
    }

    public void setCategoriaArticulo(String categoriaArticulo) {
        this.categoriaArticulo = categoriaArticulo;
    }

    public List<Articulo> getLstArticulo() {
        return lstArticulo;
    }

    public void setLstArticulo(List<Articulo> lstArticulo) {
        this.lstArticulo = lstArticulo;
    }

    public ArticuloMain(String categoriaArticulo, List<Articulo> lstArticulo) {
        this.categoriaArticulo = categoriaArticulo;
        this.lstArticulo = lstArticulo;
    }

//    public static ArrayList<ArticuloMain> JsonObjectsBuild(String categoria,JSONArray datos) throws JSONException {
//        ArrayList<ArticuloMain> ltArticuloMain = new ArrayList<>();
//        for (int i = 0; i < datos.length(); i++) {
//            ltArticuloMain.add(new ArticuloMain(categoria,Articulo.JsonObjectsBuild(datos.getJSONArray(i))));
//        }
//        return ltArticuloMain;
//    }
}
