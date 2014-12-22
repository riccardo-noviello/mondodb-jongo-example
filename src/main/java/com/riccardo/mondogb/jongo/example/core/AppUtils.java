package com.riccardo.mondogb.jongo.example.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppUtils {

	/**
	 * Reads a property from the app.proeprties file
	 * 
	 * @param propertyName
	 * @param type the type of object we want to be returned 
	 * @return returns a type T object for the given property name
	 */
	public static <T> T readProperty(String propertyName, Class<T> type) {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("app.properties"));

			// get the property value and cast it to the desired Class
			return type.cast(prop.getProperty(propertyName));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
