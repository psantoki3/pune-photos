package com.edu.fileupload.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		
		String password = req.getParameter("password");
		String userName = req.getParameter("username");
		
		//System.out.println("Inside LoginServlet");			
		if(password.equalsIgnoreCase("PuneTrip")) {
			out.println("Welcome" +userName);
			HttpSession session1 = req.getSession();
			session1.setAttribute("user", userName);
			req.getRequestDispatcher("WEB-INF/jsp/upload.jsp").forward(req, res);
		}
		else {
			out.print("Password Incorrect! Please enter Correct Password " );
			req.getRequestDispatcher("index.jsp").include(req, res);
		}
		out.close();
	} 
}