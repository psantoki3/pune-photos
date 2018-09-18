package com.edu.fileupload.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
		
		String [] downloadFile = request.getParameterValues("imageDownload");
		
		if(downloadFile != null) {
			
			for(String file : downloadFile) {
				String fileName = file;
				System.out.println(file);
				response.setContentType("APPLICATION/OCTET-STREAM");   
				response.setHeader("Content-Disposition","attachment; filename=\"" + fileName + "\"");   
				  
				FileInputStream fileInputStream = new FileInputStream(request.getServletContext().getRealPath("/")+ "static/images"+File.separator + fileName);  
				            
				int i = 0;   
				while ((i=fileInputStream.read()) != -1) {  
				out.write(i);   
				}   
				fileInputStream.close();   
			}
			out.close(); 
		}
		
	}

}
