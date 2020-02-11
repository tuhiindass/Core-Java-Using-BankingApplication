<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success Page</title>
<style>
* {
  box-sizing: border-box;
}
body {
  font-family: Arial, Helvetica, sans-serif;
}
header {
  background-color:#F13241 ;
  padding: 20px;
  text-align: center;
  font-size: 25px;
  color: white;
}
</style>
</head>
<body>
<header>
  <h2>SWISS BANK</h2>
</header>
<body bgcolor=#827E7E >
<font color=white>
	<h1>Dear Customer,</h1>
	<h2>Your Transaction are:</h2>
	<br />
	<h2>Money Credited:</h2>
	<ol>
		<%
			ArrayList<Integer> arrayList = (ArrayList<Integer>) session.getAttribute("arrayList");
			for (Integer x : arrayList) {

				if (x > 0)
					out.println("<li>" + "+" + x + "</li>");
			}
		%>
	</ol>
	<br />
	<h2>Money Debited:</h2>
	<ol>
		<%
			for (Integer x : arrayList) {

				if (x < 0)
					out.println("<li>"  + x + "</li>");
			}
		%>
</font>
	</ol>
</body>
</html>