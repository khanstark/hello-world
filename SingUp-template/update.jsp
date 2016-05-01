<%@ page import="java.sql.*" %>
<%
String pass=request.getParameter("pass");

Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","kaifkhan");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("update login set pass='"+pass+"' where name='"+session.getAttribute("uname")+"'");
%>
<script>window.alert("Password changed!");</script>
<a href="index.jsp"> Login</a>