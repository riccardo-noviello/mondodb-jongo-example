package service;

import model.Person;

import org.jongo.MongoCollection;
import org.junit.Ignore;
import org.junit.Test;

import config.CollectionNames;
import config.Database;

public class ManualQuery {
	
	@Ignore
	public void savaPersonManuallyTest(){
		
		MongoCollection persons = Database.getInstance().getCollection(CollectionNames.PERSONS);
		//create a new person
		Person p = new Person();
		p.setName("Bob");
		p.setAge(34);
		persons.save(p);
		
		Iterable<Person> all = persons.find("{name: 'Bob'}").as(Person.class);
		Person one = persons.findOne("{name: 'Bob'}").as(Person.class);
		
		System.out.println("I found this person: " + one.getName() + " age:" + one.getAge());
		
	}
}
