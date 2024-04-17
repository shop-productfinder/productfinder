package org.example.implementation;

import org.example.interfaces.Product_Interface;

public class Product implements Product_Interface {
    private String id;
    private String name;
    private String bild;
    private String nan;
    private Category category;
    private double price;

    /**
     * konstruktor erstellt ein produkt
     * @param id
     * @param name
     * @param bild
     * @param nan
     * @param category
     */
    public Product(String id, String name, String bild, String nan, Category category, double price){
        this.id = id;
        this.name = name;
        this.bild = bild;
        this.nan = nan;
        this.category = category;
        this.price = price;
    }

    /**
     * gibt den preis des produkts an
     *
     * @return price
     * @author Dominik
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * gibt die id des produkts wieder
     *
     * @return id
     * @author Dominik
     */
    @Override
    public String getID() {
        return id;
    }

    /**
     * gibt den namen eines produkts wieder
     *
     * @return name
     * @author Dominik
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * gibt das bild des produkts wieder
     *
     * @return bild
     * @author Dominik
     */
    @Override
    public String getBild() {
        return bild;
    }

    /**
     * gibt die NAN eines produkts wieder
     *
     * @return nan
     * @author Dominik
     */
    @Override
    public String getNAN() {
        return nan;
    }

    /**
     * gibt die category eines produkts wieder
     *
     * @return category
     * @author Dominik
     */
    @Override
    public Category getCategory() {
        return category;
    }

    /**
     * setzt die id eines produkts
     *
     * @param id
     * @author Dominik
     */
    @Override
    public void setID(String id) {
        this.id = id;
    }

    /**
     * setzt den namen eines produkts
     *
     * @param name
     * @author Dominik
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setzt das bild des produkts
     *
     * @param url
     * @author Dominik
     */
    @Override
    public void setBild(String url) {
        this.bild = url;
    }

    /**
     * setzt die nan des produkts
     *
     * @param nan
     * @author Dominik
     */
    @Override
    public void setNAN(String nan) {
        this.nan = nan;
    }

    /**
     * setzt die kategorie zu dem das produkt gehört
     *
     * @param category
     * @author Dominik
     */
    @Override
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * setzt den Preis des produkts
     *
     * @param price
     * @author Dominik
     */
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * gibt den inhalt der Klasse als String zurück
     * @return string
     * @author Dominik
     */
    @Override
    public String toString(){
        return "Artikel: " + id + "\n" +
                "Name: " + name + "\n" +
                "Preis: " + price + "\n" +
                "Bild: " + bild + "\n" +
                "NAN-Code: " + nan + "\n" +
                "Kategorie: " + category.getCategoryName() + "\n";
    }

}
