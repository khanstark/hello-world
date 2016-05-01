<%@ page import="java.sql.*" %>
<%
String uname=request.getParameter("name");
String pass=request.getParameter("pass");


Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","kaifkhan");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("insert into login values('"+uname+"','"+pass+"')");
response.sendRedirect("index.jsp");
session.setAttribute("urname",uname);


%>