package org.example.implementation;

import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.example.interfaces.Product_Interface;

public class Product implements Product_Interface {
    private String id;
    private String name;
    private String bild;
    private String nan;
    private String categroyName;
    @BsonIgnore
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
        this.categroyName = category.getCategoryName();
        this.price = price;
    }

    /**
     * leerer Konstruktor
     */
    public Product(){

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
     * gibt den namen einer category eines produkts wieder
     *
     * @return categoryName
     * @author Dominik
     */
    @Override
    public String getCategoryName() {
        return categroyName;
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
     * setzt den namen der Category zu dem das produkt gehört
     *
     * @param category
     * @author Dominik
     */
    @Override
    public void setCategoryName(String category) {
        this.categroyName = category;
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
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", bild='" + bild + '\'' +
                ", nan='" + nan + '\'' +
                ", category=" + categroyName +
                ", price=" + price +
                '}';
    }
}
