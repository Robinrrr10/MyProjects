<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>bank of bank</title>
<style>
* {
margin: 0;
}
body {
background-color: orange;

}
#titlebar {
background-color: brown;
padding: 15px;
}
#titlebar li {

display: inline;
padding: 15px;
}

#titlebar li a {
text-decoration: none;
color: white;
padding: 15px;
}
#titlebar li a:hover {
background-color: grey;
color: yellow;
}
</style>
</head>
<body>
<ul id="titlebar">
<li style="color:skyblue;">Home</li>
<li><a href="jsp/account_profile.jsp">My Account</a></li>
<li><a href="jsp/transfer.jsp">Transfer</a></li>
<li><a href="">Loan</a></li>
<li><a href="">Services</a></li>
<li><a href="">Log out</a></li>
</ul>
</body>
</html>