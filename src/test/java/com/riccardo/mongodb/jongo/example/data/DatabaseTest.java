package com.riccardo.mongodb.jongo.example.data;

import com.riccardo.mondogb.jongo.example.core.CollectionNames;
import com.riccardo.mondogb.jongo.example.data.Database;
import org.jongo.MongoCollection;
import org.junit.Test;

public class DatabaseTest {

    @Test
    public void MongoDBConnectionTest() {

        MongoCollection persons = Database.getInstance().getCollection(CollectionNames.PERSONS);

    }

}
