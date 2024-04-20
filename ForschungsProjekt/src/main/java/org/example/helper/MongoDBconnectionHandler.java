package org.example.helper;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.example.implementation.Category;
import org.example.implementation.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoDBconnectionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MongoDBconnectionHandler.class);
    private static final String connectionString = "mongodb+srv://damoj:7,L=QhrK!TUan&h" +
            "@produktfinder.qzp5liy.mongodb.net" +
            "/?retryWrites=true&w=majority&appName=Produktfinder";
    private final MongoDatabase database;
    private final MongoClient client;
    private final MongoCollection<Product> produktCollection;
    private final MongoCollection<Category> categoryCollection;


    /**
     * stellt verbindung zu MongoDB her
     *
     * Quelle: https://www.mongodb.com/docs/drivers/java/sync/current/quick-start/#add-mongodb-as-a-dependency
     * @author Dominik
     */
    public MongoDBconnectionHandler() {

        MongoClient client = MongoClients.create(settings());
        MongoDatabase database = client.getDatabase("ProduktFinder");
        MongoCollection<Product> produktCollection = database.getCollection("Produkte", Product.class);
        MongoCollection<Category> categoryCollction = database.getCollection("Kategorie", Category.class);

        LOGGER.info("Anmeldung an der Datenbank {} mit dem Benutzer {}. Vorhandene Collections {} {}",
                "ProduktFinder", "damoj", produktCollection.getNamespace(), categoryCollction.getNamespace());

        this.client = client;
        this.produktCollection = produktCollection;
        this.categoryCollection = categoryCollction;
        this.database = database;
    }

    /**
     * übergibt die Einstellungen für mongoDB wie es meine klassen darzustellen hatt
     *
     * @return MongoClientSettings
     * Quelle: https://www.mongodb.com/developer/languages/java/java-mapping-pojos/
     * @author Dominik
     */
    private MongoClientSettings settings(){
        ConnectionString connect = new ConnectionString(connectionString);
        CodecRegistry pojoCodecRegestry = fromProviders(PojoCodecProvider.builder()
                .register(Category.class)
                .register(Product.class)
                .automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegestry);

        return MongoClientSettings.builder().applyConnectionString(connect).codecRegistry(codecRegistry).build();
    }

    /**
     * gibt alle Produkte aus der Datenbank wieder
     *
     * @return produkte
     * @author Dominik
     */
    public List<Product> readProducts(){
        List<Product> produkte = produktCollection.find().into(new ArrayList<>());

        LOGGER.info("{} Produkte aus Collection geholt", produkte.size());

        return produkte;
    }

    /**
     * sucht nach einem Produkt in DB
     *
     * @param id
     * @return Product
     * @author Dominik
     */
    public Product readProduct(String id){
        // dokument mit filter parameter
        Bson query = Filters.eq("iD", id);

        // suche in datenbank dan allen elementen die diesem filter ensprechen
        List<Product> produkte = produktCollection.find(query).into(new ArrayList<>());

        LOGGER.info("{} Produkte mit ID {} aus Collection {} geholt",
                produkte.size(),
                id,
                produktCollection.getNamespace());

        if(!produkte.isEmpty()){
            return produkte.get(0);
        }
        else{
            return null;
        }
    }

    /**
     * fügt ein Produkt in MongoDB hinzu
     *
     * @param product
     * @author Dominik
     */
    public void createProdukt(Product product){
        produktCollection.insertOne(product);
        LOGGER.info("Produkt {} in Collection {} hinzugefügt.", product, produktCollection.getNamespace());
    }

    /**
     * fügt eine Liste von Produkten in MongoDB hinzu
     *
     * @param products
     * @author Dominik
     */
    public void createProdukts(List<Product> products){
        produktCollection.insertMany(new ArrayList<>(products));
        LOGGER.info("Produkte {} in Collection {} hinzugefügt.", products.size(), produktCollection.getNamespace());
    }

    /**
     * sucht ein Product und fügt das geupdatete product hinzu
     *
     * @param product
     * @return long
     * @author Dominik
     */
    public int updateProdukt(Product product){
        if (product != null){

            // filter parameter
            Bson query = Filters.eq("iD", product.getID());

            UpdateResult result = produktCollection.replaceOne(query, product);
            long anzahl = result.getModifiedCount();

            LOGGER.info("{} Produkt wurde geupdated", anzahl);
        }
        return 0;
    }

    /**
     * sucht und löscht das gewünschte produkt, falls nicht gefunden wird 0 zurückgegeben
     *
     * @param productID
     * @return long
     * @author Dominik
     */
    public long deleteProduct(String productID){

        // filter
        Bson query = Filters.eq("iD", productID);

        // anzahl der gelöschten produkte
        long anzahl = produktCollection.deleteOne(query).getDeletedCount();

        LOGGER.info("{} Produkte mit id: {} aus der Datenbank gelöscht", anzahl, productID);

        return anzahl;
    }

    /**
     * gibt alle Kategorien aus der Datenbank wieder
     *
     * @return categories
     * @author Dominik
     */
    public List<Category> readCategorys(){
        List<Category> categories = categoryCollection.find().into(new ArrayList<>());

        LOGGER.info("{} Kategorien aus Collection geholt", categories.size());

        return categories;
    }

    /**
     * sucht nach einer Kategorie in DB
     *
     * @param name
     * @return category
     * @author Dominik
     */
    public Category readCategory(String name){
        // dokument mit filter parameter
        Bson query = Filters.eq("name", name);

        // suche in datenbank dan allen elementen die diesem filter ensprechen
        List<Category> categories = categoryCollection.find(query).into(new ArrayList<>());

        LOGGER.info("{} Kategorien mit name {} aus Collection {} geholt",
                categories.size(),
                name,
                categoryCollection.getNamespace());

        if(!categories.isEmpty()){
            return categories.get(0);
        }
        else{
            return null;
        }
    }

    /**
     * fügt eine Liste von Kategorien in MongoDB hinzu
     *
     * @param categories
     * @author Dominik
     */
    public void createCategorys(List<Category> categories){
        categoryCollection.insertMany(new ArrayList<>(categories));
        LOGGER.info("Kategorien {} in Collection {} hinzugefügt.", categories.size(), categoryCollection.getNamespace());
    }

    /**
     * fügt eine Kategorie in MongoDB hinzu
     *
     * @param category
     * @author Dominik
     */
    public void createCategory(Category category){
        categoryCollection.insertOne(category);
        LOGGER.info("Category {} in Collection {} hinzugefügt.", category, categoryCollection.getNamespace());
    }

    /**
     * sucht eine Kategorie und fügt die neue version hinzu
     *
     * @param category
     * @return long
     * @author Dominik
     */
    public int updateCategory(Category category){
        if (category != null){

            // filter parameter
            Bson query = Filters.eq("name", category.getCategoryName());

            UpdateResult result = categoryCollection.replaceOne(query, category);
            long anzahl = result.getModifiedCount();

            LOGGER.info("{} Kategorie wurde geupdated", anzahl);
        }
        return 0;
    }

    /**
     * sucht und löscht die gewünschte kategorie, falls nicht gefunden wird 0 zurückgegeben
     *
     * @param categoryName
     * @return long
     * @author Dominik
     */
    public long deleteCategory(String categoryName){

        // filter
        Bson query = Filters.eq("name", categoryName);

        // anzahl der gelöschten produkte
        long anzahl = categoryCollection.deleteOne(query).getDeletedCount();

        LOGGER.info("{} Kategorien mit namen: {} aus der Datenbank gelöscht", anzahl, categoryName);

        return anzahl;
    }

    /**
     * Liefert die Namen aller Collections (Tabellen) der Datenbank
     *
     * @return collections
     * @author Dominik
     */
    public List<String> getCollections() {;
        return database.listCollectionNames().into(new ArrayList<>());
    }

    /**
     * Schließt die Datenbankverbindung
     *
     * @author Dominik
     */
    public void close() {
        client.close();
    }

    /**
     * Zählt die Dokumente in einer Collection
     *
     * @param collection
     *
     * @return Anzahl der Dokumente in der gesuchten Collection
     * @author Dominik
     */
    public long count(String collection) {
        return database.getCollection(collection).countDocuments();
    }

    /**
     * ACHTUNG!!! Setzt die Datenbank vollständig zurück, löscht den Inhalt aller Tabellen
     *
     * @author Dominik
     */
    public void reset(){
        produktCollection.drop();
        categoryCollection.drop();
    }
}

