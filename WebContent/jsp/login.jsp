<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Internet Banking</title>
<style>
body {
background-color: brown;
color: black;
}
.fm {
left: 50%;
color: white;
}
a {
color: yellow;
}
</style>
</head>
<body>
<p>Sign in page</p>
<p>Enter user id and the password</p>
<div class="fm">
<form method="post" action="intbank">
User Id:<input type="text" name="id"><br/>
Password:<input type="password" name="ps"><br/>
<input type="submit" value="Login">
</form>
<p><a href="">Forgot password?</a></p>
<p><a href="">Forgot user id?</a></p>
</div>
</body>
</html>