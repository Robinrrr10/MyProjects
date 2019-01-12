<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=getServletConfig().getInitParameter("bankname") %></title>
<style type="text/css">
body {
background-color: brown;
color: white;
}
a {
color: yellow;
}
#run {
width: 100%;
height: 50px;
background-color: orange;
padding: 30px;
-webkit-animation-name: ru;
-webkit-animation-duration: 30s;
animation-name: ru;
animation-duration: 30s;
}
@-webkit-keyframes ru {
25% {background-color: red;}
50% {background-color: blue;}
75% {background-color: orange;}
100% {background-color: green;}
}
@keyframes ru {
25% {background-color: red;}
50% {background-color: blue;}
75% {background-color: orange;}
100% {background-color: green;}
}
.rrt {
font-size: 25px;
position: relative;
-webkit-animation-name: ttr;
-webkit-animation-duration: 20s;
-webkit-animation-iteration-count: infinite;
animation-name: ttr;
animation-duration: 20s;
animation-iteration-count: infinite;
}
@-webkit-keyframes ttr {
0% {color: red; left: 0px;}
50%{color: green;left: 90%;}
100%{color: brown;left: 0px;}
}
@keyframes ttr {
0% {color: red;left: 0px;}
50%{color: green;left: 90%;}
100%{color: brown;left: 0px;}
}

</style>
</head>
<body>
<p>Welcome to <%=getServletConfig().getInitParameter("bankname") %></p>
<div id="run"><p class="rrt">Runtext</p></div>
<a href="signin">Internet Banking</a><br/>
<a href="register">Register in Internet Banking</a><br/>
<a href="opennew">Open new Account</a><br/>
</body>
</html>