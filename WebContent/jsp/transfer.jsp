<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.database.com.ExecuteInDatabase" %>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
a {
text-decoration: none;
color: blue;
border: 1px solid red;
background-color: orange;
padding: 10px;
cursor: pointer;
}
a:hover {
background-color: brown;
color: white;
}
</style>
</head>
<body>
<%
String nm = "1000110001";
String query = "SELECT nick_name FROM benificary_account_detail where add_by='"+nm+"';";
ResultSet rs = null;
try {
	rs = ExecuteInDatabase.executeit(query);
}catch(Exception e){
	
}
%>
<p>Transfer detail</p>
<form method="post" action="" >
Select the account:<select name="sec_a">
<%
while(rs.next()){
	%>
	<option><%=rs.getString(1) %></option>
<%	
}
%>
</select>
<input type="submit" value="select"/>
</form>
<br/><br/>
<a href="to_new_acc.jsp">To New Account</a>
</body>
</html>