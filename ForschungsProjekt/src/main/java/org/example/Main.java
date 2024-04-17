<<<<<<< HEAD
package org.example;

import org.example.helper.WebScraper;
import org.example.implementation.Product;


public class Main {
    public static void main(String[] args) {

        // test umgebung laufe durch alle categorys und deren produkte
        WebScraper ws = new WebScraper();

        for(Product p  : ws.getAllItems()){
            System.out.println(p.toString());
        }
    }
=======
package org.example;

import org.example.helper.WebScraper;
import org.example.implementation.Product;


public class Main {
    public static void main(String[] args) {

        // test umgebung laufe durch alle categorys und deren produkte
        WebScraper ws = new WebScraper();

        for(Product p  : ws.getAllItems()){
            System.out.println(p.toString());
        }
    }
>>>>>>> 25a3f21bc69b6e6aedb220022d38b1417de0891a
}