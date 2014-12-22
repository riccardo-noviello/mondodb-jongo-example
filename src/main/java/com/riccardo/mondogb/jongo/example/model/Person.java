package com.riccardo.mondogb.jongo.example.model;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.jongo.marshall.jackson.oid.Id;

public class Person {
	
	@Id
	private Long personId;
	private String name;
	private Integer age;
	private List<Address> addresses;

	public Person() {
		addresses = new ArrayList<Address>();
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		StringWriter stringWriter = new StringWriter();
		stringWriter.append("### Person:" + this.personId);
		stringWriter.append(" Name:" + this.name);
		stringWriter.append(" Age:" + this.age).append("\n");
		
		if (hasAddress()) {
			for (Address item : addresses) {
				stringWriter.append(item.toString());
			}
		}
		return stringWriter.toString();		
	}

	public boolean hasAddress() {
		return (this.addresses.size() > 0) ? true : false;
	}

	public void addAddress(Address a) {
		this.addresses.add(a);
	}
}
