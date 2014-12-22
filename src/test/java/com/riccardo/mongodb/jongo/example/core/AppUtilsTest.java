package com.riccardo.mongodb.jongo.example.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.riccardo.mondogb.jongo.example.core.AppUtils;

public class AppUtilsTest {
	
	@Test
	public void readProperty_string(){
		
		String result = AppUtils.readProperty("db.name", String.class);
		assertEquals("mongodbexample", result);
	}
	
	@Test
	public void readProperty_integer(){
		
		Integer result = AppUtils.readProperty("db.password", Integer.class);
		assertTrue(1234 == result);
	}
}
