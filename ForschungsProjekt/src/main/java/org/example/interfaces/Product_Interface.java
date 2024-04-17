package org.example.interfaces;

import org.example.implementation.Category;

public interface Product_Interface {
    /**
     * gibt den preis des produkts an
     * @return price
     * @author Dominik
     */
    double getPrice();

    /**
     * gibt die id des produkts wieder
     * @return id
     * @author Dominik
     */
    String getID();

    /**
     * gibt den namen eines produkts wieder
     * @return name
     * @author Dominik
     */
    String getName();

    /**
     * gibt das bild des produkts wieder
     * @return bild
     * @author Dominik
     */
    String getBild();

    /**
     * gibt die NAN eines produkts wieder
     * @return nan
     * @author Dominik
     */
    String getNAN();

    /**
     * gibt die category eines produkts wieder
     * @return category
     * @author Dominik
     */
    Category getCategory();

    /**
     * setzt die id eines produkts
     * @param id
     * @author Dominik
     */
    void setID(String id);

    /**
     * setzt den namen eines produkts
     * @param name
     * @author Dominik
     */
    void setName(String name);

    /**
     * setzt das bild des produkts
     * @param url
     * @author Dominik
     */
    void setBild(String url);

    /**
     * setzt die nan des produkts
     * @param nan
     * @author Dominik
     */
    void setNAN(String nan);

    /**
     * setzt die kategorie zu dem das produkt gehört
     * @param category
     * @author Dominik
     */
    void setCategory(Category category);

    /**
     * setzt den Preis des produkts
     * @param price
     * @author Dominik
     */
    void setPrice(double price);

    /**
     * gibt den inhalt der Klasse als String zurück
     * @return string
     * @author Dominik
     */
    String toString();
}
