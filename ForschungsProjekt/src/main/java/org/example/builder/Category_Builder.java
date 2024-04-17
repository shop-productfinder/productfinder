package org.example.builder;

import org.example.implementation.Category;
import org.example.implementation.Product;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Category_Builder {
    private List<Category> categories = new ArrayList<>();
    private List<Product> alleProdukte = new ArrayList<>();

    public Category_Builder(JSONArray products){

        // laufe durch alle produkte
        for (int i = 0; i < products.length() ; i++) {
            // holle ein produkt aus allen produkten raus
            JSONObject produkt = products.getJSONObject(i);

            // filter gewünschten parameter
            String name = produkt.getJSONObject("_embedded").getString("categoryPath");

            // hollen der category falls vorhanden und erzeugen eines Prdouct_Builder objects
            Category category = CategroyExists(name);
            Product_Builder pb;

            // prüfen ob category exestiert
            if (category != null){
                // wenn sie exestiert Produkt mit seiner Kategorie erstellen
                pb = new Product_Builder(produkt, category);
            }
            else {
                // wenn nicht vorher eine Category erstellen und dann das Produkt
                category = new Category(null, name);
                pb = new Product_Builder(produkt, category);

                // zur liste der categorys tun
                categories.add(category);
            }

            // füge alle Produkte zu liste hinzu
            alleProdukte.add(pb.getProduct());
        }
    }

    /**
     * prüft ob category bereits exestiert
     *
     * @param name
     * @return category
     * @author Dominik
     */
    private Category CategroyExists(String name){
        for (Category category : categories){
            if (category.getCategoryName().equals(name)){
                return category;
            }
        }
        return null;
    }

    /**
     * gibt Liste aller Kategorien zurück
     *
     * @return categories
     * @author Dominik
     */
    public List<Category> getCategories(){
        return categories;
    }

    /**
     * gibt liste aller Produkte wieder
     *
     * @return alleProdukte
     * @author Dominik
     */
    public List<Product> getAlleProdukte(){
        return alleProdukte;
    }
}
