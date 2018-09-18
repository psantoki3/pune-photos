<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload your Pune Trip Images</title>
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}


</style>
</head>
<body>

	<%
		HttpSession session1 = request.getSession(false);
		
		if(session1!=null) {
			String welcomeNote = "Hello, "+"<b>"+session1.getAttribute("user")+"<b>"+" Please upload your Pune trip Images";
		}else {
			out.print("Please Login first");
			response.sendRedirect("login.html");
			//req.getRequestDispatcher("link.html").include(req, res);
		}
	%>
	<div class="topnav">
	  <a href="ViewImages">Download</a>
	  <a href="LogoutServlet">Logout</a>
	  <c:out value="${welcomeNote}"></c:out>
	 </div>
	 
	<center>
	<form action="FileUpload" method="post" enctype="multipart/form-data">
	<tr>
		<td>
		<input type="file" name="file" multiple />
		</td>
		<td>
		<input type="submit" value="Upload Images" />
		</td>
	</tr>
	</form>
	</center>
	<hr>
	
	<center>
	<form action="ViewImages">
	<input type="Submit" value="List All Images">
	</form>
	</center>

</body>
</html>