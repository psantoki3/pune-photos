package com.edu.fileupload.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DownloadZipFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    List<File> fileList = new ArrayList<File>();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.setContentType("text/html");  
		
		
		String [] downloadFile = request.getParameterValues("imageDownload");
		
		for (String fileName : downloadFile) {
			
			File file = new File(request.getServletContext().getRealPath("/")+ "/uploadedImages"+File.separator+fileName);
			fileList.add(file);
		}
		
		
		response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment; filename=\"allImages.zip\"");

        ServletOutputStream out = response.getOutputStream();
		ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(out));

		for (File file : fileList) {

			System.out.println("Adding " + file.getName());
			zos.putNextEntry(new ZipEntry(file.getName()));

			// Get the file
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(file);

			} catch (FileNotFoundException fnfe) {
				// If the file does not exists, write an error entry instead of
				// file
				// contents
				zos.write(("ERRORld not find file " + file.getName())
						.getBytes());
				zos.closeEntry();
				System.out.println(fnfe);
				continue;
			}

			BufferedInputStream fif = new BufferedInputStream(fis);

			// Write the contents of the file
			int data = 0;
			while ((data = fif.read()) != -1) {
				zos.write(data);
			}
			fif.close();

			zos.closeEntry();
			System.out.println("Finishedng file " + file.getName());
		}

		zos.close();
		
		
	}

}
