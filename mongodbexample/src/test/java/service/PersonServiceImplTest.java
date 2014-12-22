package service;

import java.util.List;

import junit.framework.Assert;
import model.Address;
import model.Person;

import org.jongo.MongoCollection;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import config.CollectionNames;
import config.Database;


public class PersonServiceImplTest {
	
	private static PersonServiceImpl service;

	@Before
	public void setUp(){
		service = new PersonServiceImpl();
		
		//store a person into the database (manually) before the tests
		MongoCollection persons = Database.getInstance().getCollection(CollectionNames.PERSONS);
		//create a new person
		Person p = new Person();
		p.setPersonId(1L);
		p.setName("Bob");
		p.setAge(34);
		//create two addresses for this person
		Address a = new Address();
		
		
		a.setHouseNumber("33");
		a.setRoad("Fake Road");
		a.setPostalCode("AB1 2CD");
		a.setTown("Big Town");
		p.addAddress(a);
		
		Address a1 = new Address();
		a1.setHouseNumber("12");
		a1.setRoad("High Street");
		a1.setPostalCode("BC2 3DE");
		a1.setTown("Small Town");
		p.addAddress(a1);
		
		Address a2 = new Address();
		a2.setHouseNumber("55");
		a2.setRoad("Main Street");
		a2.setPostalCode("AB1 2CD");
		a2.setTown("Big Town");
		p.addAddress(a2);
		
		persons.save(p);
	}
	
	@After
	public void tearDown(){
		service = null;
	}
	
	@Ignore
	public void printAddressTest(){
		Address a = new Address();
		a.setHouseNumber("12");
		a.setRoad("High Street");
		a.setPostalCode("BC2 3DE");
		a.setTown("Small Town");
		
		a.print();
	}
	
	@Test
	public void getPersonByIdTest(){
		
		Person p = service.getPersonById(1L);
		
		Assert.assertTrue(p != null);
	}
	
	@Test
	public void getPersonsByAge(){
		
		List<Person> list = service.getPersonsByAge(34);
		for (Person item : list){
			item.print();
		}
		
		Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void getAddressesByPersonIdTest(){
		
		List<Address> list = service.getAddressByPersonId(1L);
		for (Address item : list){
			item.print();
		}
		
		Assert.assertTrue(list.size() > 0);
	}
}
