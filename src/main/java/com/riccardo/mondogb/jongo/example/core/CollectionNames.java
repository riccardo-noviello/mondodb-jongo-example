package com.riccardo.mondogb.jongo.example.core;

/**
 * This class stores all the collection names
 * 
 * @author riccardo
 *
 */
public enum CollectionNames {

	PERSONS("persons"),
	ORDERS("orders");

	private String name;

	private CollectionNames(String inName) {
		name = inName;
	}

	public String getName() {
		return name;
	}
}
