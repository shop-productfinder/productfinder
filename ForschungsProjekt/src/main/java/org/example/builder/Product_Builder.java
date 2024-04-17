package org.example.builder;

import org.example.implementation.Category;
import org.example.implementation.Product;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Product_Builder {
    private Product product;

    /**
     * filtert alle produktinformationen heraus und erzeugt ein produkt
     *
     * @param produkt
     * @author Dominik
     */
    public Product_Builder(JSONObject produkt, Category category){
        // Filtere alle relevanten produktinformationen
        String id = produkt.getString("id");
        String name = produkt.getString("productName");
        String nan = produkt.getString("nan");
        String bild = produkt.getJSONObject("media")
                .getJSONArray("images")
                .getJSONObject(0)
                .getJSONObject("_links")
                .getJSONObject("self")
                .getString("href");
        double price = produkt.getJSONObject("_embedded")
                .getJSONArray("articles")
                .getJSONObject(0)
                .getJSONObject("_embedded")
                .getJSONObject("listing")
                .getJSONObject("pricing")
                .getDouble("currentRetailPrice")/100;

        // erstelle ein Produkt
        Product product = new Product(id, name, bild, nan, category, price);

        this.product = product;
    }

    /**
     * gibt das erzeugte Prdukt zurück
     *
     * @return product
     * @author Dominik
     */
    public Product getProduct(){
        return product;
    }
}
