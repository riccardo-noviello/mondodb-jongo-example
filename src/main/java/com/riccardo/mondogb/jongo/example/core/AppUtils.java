package com.riccardo.mondogb.jongo.example.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.riccardo.mondogb.jongo.example.data.Database;

public class AppUtils {

	private final static Logger logger = Logger.getLogger(Database.class.getName());

	/**
	 * Reads a property from the app.proeprties file
	 * 
	 * @param propertyName
	 * @param type
	 *            the type of object we want to be returned
	 * @return returns a type T object for the given property name
	 */
	public static <T> T readProperty(String propertyName, Class<T> type) {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("src/main/resources/app.properties"));

			// get the property value and cast it to the desired Class
			return (T) castProperty(prop.getProperty(propertyName), type);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param propertyName
	 * @param type
	 * @return
	 */
	private static <T> Object castProperty(String propertyValue, Class<T> type) {
		if (!type.isAssignableFrom(String.class)) {
			try {
				return type.getMethod("valueOf", new Class[] { String.class }).invoke(null, new Object[] { propertyValue });
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				logger.log(Level.SEVERE, "error casting", e);

			}
		}
		return propertyValue;
	}
}
