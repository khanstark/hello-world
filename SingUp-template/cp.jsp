<%@ page import="java.sql.*" %>
<%@ include file="header.jsp" %>
<body>

<style>
p.a{
	font-size:26;
	font-family:Tahoma;
}
</style></body><br><br><br>
<%
out.println("<p align=center class=a><font color=#3b5998>welcome</font></p>"+"<p align=center class=a>"+session.getAttribute("uname")+"</p>");


%>
<form action="update.jsp" method="post">
<p align="center">Enter New Password
<input type="password" name="pass"><br><br>
Re-type New Password<input type="password" name="pass2">
</p><br>
<p align="center"><input type="submit" value="Change Password">
</form>
