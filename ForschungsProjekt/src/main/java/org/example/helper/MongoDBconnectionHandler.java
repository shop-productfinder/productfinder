package org.example.helper;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBconnectionHandler {
    private MongoDatabase database;


    /**
     * stellt verbindung zu MongoDB her
     *
     * Quelle: https://www.mongodb.com/docs/drivers/java/sync/current/quick-start/#add-mongodb-as-a-dependency
     * @author Dominik
     */
    public MongoDBconnectionHandler() {

        String connectionString = "mongodb+srv://<damoj>:<Garro326!>" +
                "@produktfinder.qzp5liy.mongodb.net" +
                "/?retryWrites=true&w=majority&appName=Produktfinder";

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        // Create a new client and connect to the server
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                // Send a ping to confirm a successful connection
                MongoDatabase database = mongoClient.getDatabase("admin");
                database.runCommand(new Document("ping", 1));
                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }

}
