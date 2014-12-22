package service;

import java.util.List;

import model.Address;
import model.Person;

public abstract class PersonService {
	
	public abstract void addPerson(Person p);
	
	public abstract Person getPersonById(long id);
	
	public abstract List<Person> getPersonsByAge(int age);
	
	public abstract List<Address> getAddressByPersonId(long id);
}
