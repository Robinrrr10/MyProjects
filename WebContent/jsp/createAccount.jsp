<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"-->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
background-color: orange;
}
</style>
</head>
<body>
<p>Open new account</p>
<p>Enter the details</p>
<form method="post" action="addnewacc">
<br/>Enter your name:<input type="text" name="nm"/>
<br/>Enter your date of birth:<input type="date" name="dob"/>
<br/>Enter your Aadhaar no:<input type="number" name="adh_no"/>
<br/>Enter your mobile number:<input type="number" name="mob_no">
<br/><input type="submit"/>
</form>
</body>
</html>