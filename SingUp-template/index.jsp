


<%@ include file="header.jsp" %>

<html>
<head>
<title>Welcome</title>
<body link="#3b5998">


<br><br><br>
<form action="main.jsp" method="POST" accept="image/jpeg">
<p align="center"><font size="11" face="Tahoma" color="#3b5998">Login to get connected...</font></p>
<br><br>
<p align="center">
<font  face="Berlin Sans FB">Username</font><input type="text" name="name" oninvalid="alert('please fill your name');" required>
<br><br>
<font  face="Berlin Sans FB">Password</font><input type="password" name="pass" oninvalid="alert('please fill your  password');" required>
</br></br>
<%@ page import="java.util.*" %>

<p class="c" align="center">
<%
Random r=new Random();
Integer i=(int)r.nextInt(99999);
String v=i.toString();

out.println(v);

session.setAttribute("val",v);

%>
<input type="button" value="Refresh" name="r" onclick="go()">
<script>
function go()
{
	window.location.assign("index.jsp");
}</script>


</p>

<p align="center">
<font  face="Berlin Sans FB">Enter the value above:</font><input type="text" name="cap" id="cap"></p>
<p align="center"><input type="submit" value="Sign in!"></p>
</form>

<style>
a{

font-size:19;
font-family:Tahoma;
}
p.b{

font-size:19;
font-family:Tahoma;
color:#3b5998;
}
p.c{
	font-size:35;
	font-family:AR Destine;
	color:#3b5998;
}
</style><br><br>
<table class="a" align="center">
<tr><td>
<a href="reg.jsp" >Register</a>  </td> <td> </td><td> </td><td></td><td></td><td></td><td></td><td>  <a href="fp.jsp">Forgot Password?</a></td></tr></table>
<br>
<marquee>A Kaif Khan Creation  &copy;2015</marquee><br><br>
<p class="b" align="center">
<%  out.println(request.getLocale());%>

</p></body>
</head>
</html>

