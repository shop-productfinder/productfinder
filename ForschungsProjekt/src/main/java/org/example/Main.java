package org.example;

import org.example.helper.MongoDBconnectionHandler;
import org.example.helper.WebScraper;
import org.example.implementation.Category;
import org.example.implementation.Product;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        /*

        ***

         test zum einfügen der ersten produkte und kategorien der rewe webseite

         (Problem: beim abrufen der klassen aus der DB wierden die Klassen Strukturen die man abrufen
         kann als null dargestellt)

         ***

        MongoDBconnectionHandler m = new MongoDBconnectionHandler();
        WebScraper w = new WebScraper();

        List<Product> products = w.getAllItems();
        List<Category> categories = w.getCategories();

        m.deleteProduct(products.get(0).getID());
        m.createProdukts(products);
        m.createCategorys(categories);

         */


    }

}
