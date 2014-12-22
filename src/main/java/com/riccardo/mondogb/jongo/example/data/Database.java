package com.riccardo.mondogb.jongo.example.data;

import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoURI;
import com.riccardo.mondogb.jongo.example.core.CollectionNames;

public class Database {

    //Database credentials
    private static final String URL = "mongodb://localhost";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";
    private static final String NAME = "test";

    private static Database instance;
    private static DB mongoDb;
    private static Jongo jongo;

    private final static Logger logger = Logger.getLogger(Database.class.getName());

    /**
     * Singleton
     */
    private Database() {
        connectMongo();
    }

    /**
     * Get instance of Database
     *
     * @return
     */
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    /**
     * This instantiate the MongoDB connection
     *
     * @return
     */
    public boolean connectMongo() {
        try {
            MongoURI mongoUri = new MongoURI(URL);
            Mongo mongo = (new Mongo.Holder()).connect(mongoUri);
            mongoDb = mongo.getDB(NAME);

            if (!mongoDb.authenticate(USERNAME, PASSWORD.toCharArray())) {
                logger.severe("Unable to authenticate for database " + NAME);
                throw new RuntimeException(String.format("Unable to authenticate for database %s", NAME));
            }

            jongo = new Jongo(mongoDb);

            return true;

        } catch (UnknownHostException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    /**
     * Get a collection by passing a parameter enum
     *
     * @param collection
     * @return
     */
    public static MongoCollection getCollection(CollectionNames collection) {
        return jongo.getCollection(collection.getName());
    }

}
