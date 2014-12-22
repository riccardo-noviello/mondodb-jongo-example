package config;

import org.jongo.MongoCollection;
import org.junit.Test;

public class DatabaseTest {
	
	@Test
	public void MongoDBConnectionTest(){
		
		MongoCollection persons = Database.getInstance().getCollection(CollectionNames.PERSONS);
		
	}
	
}
