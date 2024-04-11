package org.example;

import org.example.helper.WebScraper;
import org.example.implementation.Category;
import org.example.implementation.Product;


public class Main {
    public static void main(String[] args){

        // test umgebung laufe durch alle categorys und deren produkte
        WebScraper ws = new WebScraper();

        for (Category c : ws.getCategories()){
            System.out.println("**** alle Produkte der Kategorie ****\n");
            for (Product p : ws.getAllItems()){
                if(p.getCategory().getCategoryName().equals(c.getCategoryName())){
                    System.out.println(p);
                }
            }
        }
        System.out.println("Kategorie Anzahl: " + ws.getCategories().size() + " Produkte Anzahl: " + ws.getAllItems().size());
    }
}
