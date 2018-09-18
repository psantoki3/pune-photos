package com.edu.fileupload.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.edu.fileupload.model.*;

public class CheckboxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Student s = new Student();
		s.setName("Pratik");
		s.setRollno(1);
		s.setCity("Baroda");
		
		Teacher t = new Teacher();
		t.setName("Sushant");
		t.setSubject("Java");
		
		String[] checkboxModel = request.getParameterValues("CheckboxModel");
		
		System.out.println("Pratik"+checkboxModel);
		if(checkboxModel != null) {
			for(String model : checkboxModel) {
				System.out.println(model);
			}
			
		}
		
	}

}
