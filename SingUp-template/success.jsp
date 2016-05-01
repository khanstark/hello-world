<%@ page import="java.sql.*" %>
<%@ include file="header.jsp" %>
<%

out.println("Welcome"+" "+"<b>"+session.getAttribute("urname")+"</b>");
out.println("<br><br><br>");

Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","kaifkhan");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select  name from login");
String uid;
out.println("<table>");
while(rs.next())
{
	out.println("<tr>");
	out.println("<td>");
	String s=rs.getString("name");
	out.println(s);
	out.println("</td>");
	out.println("<td>");
	out.println("<a href=details.jsp?uid="+s+">View</a>");
	
	out.println("</td>");
	out.println("</tr>");
}
out.println("<table>");
rs.close();
st.close();
con.close();



%>