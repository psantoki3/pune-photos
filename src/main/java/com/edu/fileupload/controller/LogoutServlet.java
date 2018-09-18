package com.edu.fileupload.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException{
			
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			
			//req.getRequestDispatcher("WEB-INF/static/topNavigation.jsp").include(req, res);
			
			HttpSession session = req.getSession(false);
			
			if(session!=null) {
				session.invalidate();
				out.print("You have successfully Logged out!");
				req.getRequestDispatcher("index.jsp").include(req, res);
			}
			else {
				res.sendRedirect("WEB-INF/jsp/upload.jsp");
			}
			
			
			out.close();
		}
		
}
