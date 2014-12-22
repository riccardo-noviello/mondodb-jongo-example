package com.riccardo.mondogb.jongo.example.service;

import java.util.List;

import org.jongo.MongoCollection;

import com.riccardo.mondogb.jongo.example.core.CollectionNames;
import com.riccardo.mondogb.jongo.example.data.Database;
import com.riccardo.mondogb.jongo.example.model.Address;
import com.riccardo.mondogb.jongo.example.model.Person;

public class PersonServiceImpl implements PersonService {

	private static final MongoCollection persons = Database.getCollection(CollectionNames.PERSONS);

	@Override
	public void addPerson(Person p) {
		persons.save(p);
	}

	@Override
	public Person getPersonById(long l) {
		Person one = persons.findOne("{_id: #}", l).as(Person.class);
		return one;
	}

	@Override
	public List<Person> getPersonsByAge(int age) {		
		List<Person> all = persons.aggregate("{$project:{name:1, age:1}}").and("{$match:{age:#}}",age).and("{$limit:10}").as(Person.class);		
		return all;
	}

	@Override
	public List<Address> getAddressByPersonId(long id) {
		List<Person> list = persons.aggregate("{$match:{_id:#}}",id).and("{$project: {addresses: 1, _id: 0}}")
			    .as(Person.class);		
		return list.get(0).getAddresses();
	}

}
