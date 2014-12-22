package com.riccardo.mondogb.jongo.example.service;

import java.util.List;

import com.riccardo.mondogb.jongo.example.model.Address;
import com.riccardo.mondogb.jongo.example.model.Person;

public interface PersonService {

	public abstract void addPerson(Person p);

	public abstract Person getPersonById(long id);

	public abstract List<Person> getPersonsByAge(int age);

	public abstract List<Address> getAddressByPersonId(long id);
}
