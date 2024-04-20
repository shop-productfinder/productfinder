package org.example.implementation;


import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.example.interfaces.Category_Interface;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Category implements Category_Interface {
    private List<String> produktIDs;
    @BsonIgnore
    private List<Product> products;
    private String name;

    /**
     * erstellt eine categroy mit all ihren parametern
     *
     * @param products
     * @param name
     * @author Dominik
     */
    public Category(List<Product> products, String name){
        this.products = products;
        this.name = name;
    }

    /**
     * leerer konstruktor
     */
    public Category(){

    }


    /**
     * gibt alle produkt IDs einer kategorie wieder
     *
     * @return produktIDs
     * @author Dominik
     */
    @Override
    public List<String> getProductIDs() {
        return produktIDs;
    }

    /**
     * gibt alle produkte einer kategorie wieder
     *
     * @return products
     * @author Dominik
     */
    @Override
    public List<Product> getProducts() {
        return products;
    }

    /**
     * gibt den namen der kategorie eines produkts wieder
     *
     * @return name
     * @author Dominik
     */
    @Override
    public String getCategoryName() {
        return name;
    }

    /**
     * setzt den namen der Kategorie
     *
     * @param name
     * @author Dominik
     */
    @Override
    public void setCategoryName(String name) {
        this.name = name;
    }

    /**
     * fügt ein produkt einer category hinzu
     *
     * @param produkte
     * @author Dominik
     */
    @Override
    public void addProducts(List<Product> produkte) {
        if(products == null){
            products = new ArrayList<>();
        }
        products.addAll(produkte);
        this.produktIDs = products.stream().map(Product::getID).collect(Collectors.toList());
    }

    /**
     * fügt eine id einer category hinzu
     *
     * @param productID
     * @author Dominik
     */
    @Override
    public void addProductIDs(String productID){
        if(produktIDs == null){
            produktIDs = new ArrayList<>();
        }
        produktIDs.add(productID);
    }


    /**
     * gibt String inhalt der klasse wieder
     *
     * @return string
     * @author Dominik
     */
    @Override
    public String toString() {
        return "Category{" +
                "products=[" + products.stream().map(Product::getID).collect(Collectors.joining(",")) + "]" +
                ", name='" + name + '\'' +
                '}';
    }

}
