package com.edu.service.testcase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.edu.fileupload.service.AddNumber;



public class AddNumberTestCase {

	@Test
	public void testAddNumber() {
		
		AddNumber addNumber = new AddNumber();
		int abc = addNumber.addNumericValue(10, 5);
		
		assertEquals(abc,15);
		assertTrue(abc > 12 ?true:false);
	}
	
	@Test
	public void testAddNumber1() {
		
		AddNumber addNumber = new AddNumber();
		int abc = addNumber.addNumericValue(10, 5);
		
		junit.framework.Assert.assertEquals(abc,15);
	}
	
	@Before
	public void before() {
		
		System.out.println("Before");
	}
	@BeforeClass
	public static void beforeClass() {
		
		System.out.println("BeforeClass");
	}
	@After
	public void after() {
		
		System.out.println("@After");
	}
	@AfterClass
	public static void afterClass() {
		
		System.out.println("@AfterClass");
	}
}
