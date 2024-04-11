package org.example.helper;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBconnectionHandler {

    /**
     * stellt verbindung zu MongoDB her
     *
     * Quelle: https://www.mongodb.com/docs/drivers/java/sync/current/quick-start/#add-mongodb-as-a-dependency
     * @author Dominik
     */
    public MongoDBconnectionHandler(){

        // verbindungsstring zu MongoDB
        String connectionURI = "mongodb+srv://" +
                "schmittklink:<Damoj326!>@forschungsprojekt.9e5ooxz.mongodb.net/" +
                "?retryWrites=true&w=majority&appName=ForschungsProjekt";

        try(MongoClient mongoClient = MongoClients.create(connectionURI)){
            MongoDatabase database = mongoClient.getDatabase("ForschungsProjekt");
        }

    }
}
