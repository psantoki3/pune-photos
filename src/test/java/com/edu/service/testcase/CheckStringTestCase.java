package com.edu.service.testcase;


import org.junit.Test;

import com.edu.fileupload.service.AddNumber;

public class CheckStringTestCase {

	@Test
	public void testStringlength() {
		
		AddNumber addNumber = new AddNumber();
		String greetingMessage = addNumber.getMessage("Sushant");
		
		org.junit.Assert.assertTrue(greetingMessage.length() >40 ?false:true);
	}
}
