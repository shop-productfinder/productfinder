package org.example.interfaces;

import org.example.implementation.Product;

import java.util.List;

public interface Category_Interface {
    /**
     * gibt alle produkte einer kategorie wieder
     * @return products
     * @author Dominik
     */
    List<Product> getProducts();

    /**
     * gibt den namen der kategorie eines produkts wieder
     * @return name
     * @author Dominik
     */
    String getCategoryName();

    /**
     * setzt den namen der Kategorie
     * @param name
     * @author Dominik
     */
    void setCategoryName(String name);

    /**
     * fügt ein produkt einer category hinzu
     * @param produkte
     * @author Dominik
     */
    void addProducts(List<Product> produkte);

    /**
     * gibt String inhalt der klasse wieder
     * @return string
     * @author Dominik
     */
    String toString();
}
