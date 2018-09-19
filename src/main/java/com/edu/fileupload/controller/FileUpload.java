package com.edu.fileupload.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	response.setContentType("text/html");
    	PrintWriter out = response.getWriter();
    	
    	try {
    		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> files = sf.parseRequest(request);
			
//			System.out.println("request.getContextPath()-"+request.getContextPath());
//			System.out.println(request.getServletContext().getRealPath("/")+ "images");
			
			for (FileItem item : files) {
				item.write(new File(request.getContextPath()+File.separator+"static/images"+File.separator+item.getName()));
				//item.write(new File("/java/workspace/UploadedImages"+File.separator+item.getName()));
			}
			
			out.println("Your Files uploaded successfully!");
			
			request.getRequestDispatcher("WEB-INF/jsp/upload.jsp").include(request, response);
		
    	} catch (Exception e) {
			out.println(e);
		e.printStackTrace();
		}
	}

}
