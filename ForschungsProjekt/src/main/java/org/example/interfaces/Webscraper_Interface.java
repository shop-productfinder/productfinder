package org.example.interfaces;

import org.example.implementation.Category;
import org.example.implementation.Product;

import java.util.List;

public interface Webscraper_Interface {

    /**
     * gibt Alle inhalte der Rewe webseite wieder
     * @return items
     * @author Dominik
     */
    List<Product> getAllItems();

    /**
     * gibt alle Kategorien wieder
     * @return categories
     * @author Dominik
     */
    List<Category> getCategories();

}
