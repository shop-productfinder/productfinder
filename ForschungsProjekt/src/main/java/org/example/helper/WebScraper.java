<<<<<<< HEAD
package org.example.helper;

import org.example.builder.Category_Builder;
import org.example.implementation.Category;
import org.example.implementation.Product;
import org.example.interfaces.Webscraper_Interface;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

import java.util.ArrayList;
import java.util.List;

public class WebScraper implements Webscraper_Interface {
    private static final String GET_URL = "https://shop.rewe.de/api/products?";
    private static final String URL_PARAMETER =
            "&search=%2A&sorting=" +
            "RELEVANCE_DESC&serviceTypes" +
            "=DELIVERY&market=240583&debug=false&autocorrect=true";
    private List<Product> items = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();

    /**
     * konstruktor verbindet sich mit dem api endpunkt der rewe webseite und zieht relevante daten heraus
     * Quelle: https://www.youtube.com/watch?v=5MmlRZZxTqk&t=
     * Quelle: https://www.baeldung.com/java-http-request
     */
    public WebScraper(){

        try{
            // url zur verbindung des API endpunkts
            URL url = new URL(GET_URL + "objectsPerPage=40&page=1" + URL_PARAMETER);

            // verbindung zur URL öffnen
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Lesen der Antwort von der Verbindung
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

            // response der api in json format abfangen
            JSONObject jsonResponse = new JSONObject(new JSONTokener(reader));

            // alle prdouktinformationen filtern
            JSONArray produktInformationen =
                    jsonResponse.getJSONObject("_embedded")
                    .getJSONArray("products");

            // erstelle alle Produkte einer Seite
            Category_Builder cb = new Category_Builder(produktInformationen);

            // füge alle listen hier hinzu
            items.addAll(cb.getAlleProdukte());
            categories.addAll(cb.getCategories());

            // ergänze was bei Category noch fehlt
            updateCategories();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * gibt Alle inhalte der Rewe webseite wieder
     *
     * @return items
     * @author Dominik
     */
    @Override
    public List<Product> getAllItems() {
        return items;
    }

    /**
     * gibt alle Kategorien wieder
     *
     * @return categories
     * @author Dominik
     */
    @Override
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * ergänzt die liste aller Produkte die zu einer Kategorie gehören
     *
     *  @author Dominik
     */
    public void updateCategories(){
        // laufe durch alle Kategorien
        for (Category category : categories){

            // holle alle produkte der Kategorie
            List<Product> produkte = getProductsOfCategory(category.getCategoryName());

            // füge die liste aller produkte zu der category hinzu
            category.addProducts(produkte);
        }
    }

    /**
     * hollt alle produkte aus einer kategorie zusammen
     *
     * @param name
     * @return allProductsOfCategory
     * @author Dominik
     */
    private List<Product> getProductsOfCategory(String name){
        List<Product> allProductsOfCategory = new ArrayList<>();

        // laufe durch alle produkte und suche nach denen mit denen die aus dieser category sind
        for (Product product : items){
            if (product.getCategory().getCategoryName().equals(name)){
                allProductsOfCategory.add(product);
            }
        }
        return allProductsOfCategory;
    }
}
=======
package org.example.helper;

import org.example.builder.Category_Builder;
import org.example.implementation.Category;
import org.example.implementation.Product;
import org.example.interfaces.Webscraper_Interface;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

import java.util.ArrayList;
import java.util.List;

public class WebScraper implements Webscraper_Interface {
    private static final String GET_URL = "https://shop.rewe.de/api/products?";
    private static final String URL_PARAMETER =
            "&search=%2A&sorting=" +
            "RELEVANCE_DESC&serviceTypes" +
            "=DELIVERY&market=240583&debug=false&autocorrect=true";
    private List<Product> items = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();

    /**
     * konstruktor verbindet sich mit dem api endpunkt der rewe webseite und zieht relevante daten heraus
     * Quelle: https://www.youtube.com/watch?v=5MmlRZZxTqk&t=
     * Quelle: https://www.baeldung.com/java-http-request
     */
    public WebScraper(){

        try{
            // url zur verbindung des API endpunkts
            URL url = new URL(GET_URL + "objectsPerPage=40&page=1" + URL_PARAMETER);

            // verbindung zur URL öffnen
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Lesen der Antwort von der Verbindung
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

            // response der api in json format abfangen
            JSONObject jsonResponse = new JSONObject(new JSONTokener(reader));

            // alle prdouktinformationen filtern
            JSONArray produktInformationen =
                    jsonResponse.getJSONObject("_embedded")
                    .getJSONArray("products");

            // erstelle alle Produkte einer Seite
            Category_Builder cb = new Category_Builder(produktInformationen);

            // füge alle listen hier hinzu
            items.addAll(cb.getAlleProdukte());
            categories.addAll(cb.getCategories());

            // ergänze was bei Category noch fehlt
            updateCategories();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * gibt Alle inhalte der Rewe webseite wieder
     *
     * @return items
     * @author Dominik
     */
    @Override
    public List<Product> getAllItems() {
        return items;
    }

    /**
     * gibt alle Kategorien wieder
     *
     * @return categories
     * @author Dominik
     */
    @Override
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * ergänzt die liste aller Produkte die zu einer Kategorie gehören
     *
     *  @author Dominik
     */
    public void updateCategories(){
        // laufe durch alle Kategorien
        for (Category category : categories){

            // holle alle produkte der Kategorie
            List<Product> produkte = getProductsOfCategory(category.getCategoryName());

            // füge die liste aller produkte zu der category hinzu
            category.addProducts(produkte);
        }
    }

    /**
     * hollt alle produkte aus einer kategorie zusammen
     *
     * @param name
     * @return allProductsOfCategory
     * @author Dominik
     */
    private List<Product> getProductsOfCategory(String name){
        List<Product> allProductsOfCategory = new ArrayList<>();

        // laufe durch alle produkte und suche nach denen mit denen die aus dieser category sind
        for (Product product : items){
            if (product.getCategory().getCategoryName().equals(name)){
                allProductsOfCategory.add(product);
            }
        }
        return allProductsOfCategory;
    }
}
>>>>>>> 25a3f21bc69b6e6aedb220022d38b1417de0891a
