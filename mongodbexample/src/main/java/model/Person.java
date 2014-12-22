package model;

import java.util.ArrayList;
import java.util.List;

import org.jongo.marshall.jackson.oid.Id;

public class Person {
	@Id
	private long personId;
	private String name;
	private int age;
	private List<Address> addresses;
	
	public Person(){
		addresses = new ArrayList<Address>();
	}
	
	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public void print() {
		System.out.println("### Person:"+this.personId+ " Name:"+this.name+ " Age:"+ this.age + " ###");
		if (hasAddress()){
			for(Address item: addresses){ item.print(); }
		}
	}
	
	public boolean hasAddress(){
		return (this.addresses.size() > 0) ? true : false;
	}

	public void addAddress(Address a) {
		this.addresses.add(a);		
	}
}
