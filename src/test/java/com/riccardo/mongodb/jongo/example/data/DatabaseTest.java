package com.riccardo.mongodb.jongo.example.data;

import static org.junit.Assert.assertNotNull;

import com.riccardo.mondogb.jongo.example.data.CollectionNames;
import com.riccardo.mondogb.jongo.example.data.Database;

import org.jongo.MongoCollection;
import org.junit.Test;

public class DatabaseTest {

    @Test
    public void MongoDBConnectionTest() {
        Database.getInstance();
		MongoCollection persons = Database.getCollection(CollectionNames.PERSONS);
        assertNotNull(persons);
    }

}
