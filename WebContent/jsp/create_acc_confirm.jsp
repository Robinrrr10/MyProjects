<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
background-color: orange;
}
p {
color: brown;
}
span {
color: white;
font-size: 30px;
}
</style>
</head>
<body>
<p style="color: white;">confirmation of the create acccount</p>
<%
String nm = request.getParameter("nm");
String db = request.getParameter("dob");
String adt = request.getParameter("adh_no");
String mb = request.getParameter("mob_no");
%>
<p>Name:<span><%= nm %></span></p>
<p>Date of birth:<span><%= db %></span></p>
<p>Aadthar number:<span><%= adt %></span></p>
<p>Mobile number:<span><%= mb %></span></p>
<form method="post" action="create_accont_confirm">
<input type="hidden" name="name" value="<%= nm %>">
<input type="hidden" name="dob" value="<%= db %>">
<input type="hidden" name="adh" value="<%= adt %>">
<input type="hidden" name="mob" value="<%= mb %>">
Enter new user id<input type="text" name="usd">
Enter password<input type="password" name="passw">
Reenter the password<input type="password" name="passcon">
<input type="submit" value="Create"/>
</form>
</body>
</html>