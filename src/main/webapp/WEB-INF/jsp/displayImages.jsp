<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="java.io.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pune Trip Photographs</title>
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
	<%-- <%
	Map<String, String> testMap = new HashMap<String, String>();
	testMap.put("1", "Sushant");
	testMap.put("2", "Mona");
	session.setAttribute("testMap", testMap);
	%> --%>
	
	<div class="topnav">
	  <a href="ViewImages">Download</a>
	  <a href="LogoutServlet">Logout</a>
	  <c:out value="${welcomeNote}"></c:out>
	 </div>
	
	 <form action="DownloadZipFile" method="post">
	<% 
	
		Map<String, Integer> imageMap = (Map<String, Integer>) request.getAttribute("imageMap");
		for(Map.Entry<String, Integer> image : imageMap.entrySet()){
		System.out.print(image.getKey());
		String imageName = image.getKey();
		//pageContext.setAttribute("imagePageContext", imageMap);
	%>
	<input type="checkbox" name="imageDownload" value="<%=imageName%>" >
	<img src="<%=request.getContextPath()+File.separator+"uploadedImages"+File.separator+imageName%>" height=100  width=100>
	
	<%
		}
	%>
	<p>
	<input style="align-self : center; align-items: center;" type="submit" value="Download Images">
	</p>
	</form>
	<p>
		<input type="button" onclick='selectAll()' value="Select All"/>
		<input type="button" onclick='UnSelectAll()' value="Unselect All"/>
	</p>
	
	<script type="text/javascript">
			function selectAll(){
				var items=document.getElementsByName('imageDownload');
				for(var i=0; i<items.length; i++){
					if(items[i].type=='checkbox')
						items[i].checked=true;
				}
			}
			
			function UnSelectAll(){
				var items=document.getElementsByName('imageDownload');
				for(var i=0; i<items.length; i++){
					if(items[i].type=='checkbox')
						items[i].checked=false;
				}
			}			
		</script>
		
	
	<%-- <form action="DownloadZipFile" method="post">
		<c:forEach var="entry" items="${testMap}">
		JSTL : ${entry.key}
		<input type="checkbox" name="imageDownload" value="${image.key}" >
		<img src="<%=request.getContextPath()+File.separator%>${image.key}" height=100  width=100>
		</c:forEach>
		
		<input type="submit" value="Download Images">
	</form> --%>

	
</body>
</html>
