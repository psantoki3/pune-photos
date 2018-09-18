package com.edu.fileupload.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ViewImages extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String,Integer> imageMap = new HashMap<String, Integer>();
		
		int i = 0;
		for (File f: new File(request.getServletContext().getRealPath("/")+ "static/images").listFiles()) {
			String imageName = f.getName();
			imageMap.put(imageName, ++i);
		}
		request.setAttribute("imageMap", imageMap);
		request.getRequestDispatcher("WEB-INF/jsp/displayImages.jsp").forward(request, response);
	}

}
