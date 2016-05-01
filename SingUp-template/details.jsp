<%@ page import="java.sql.*" %>
<%@ include file="header.jsp" %>
<%
String id=request.getParameter("uid");

Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","kaifkhan");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from login");

ResultSetMetaData rsmd=rs.getMetaData();
int n=rsmd.getColumnCount();
while(rs.next())
{
	for(int i=1;i<n+1;i++)
	out.println(rs.getString(i));
out.println("<br>");
}

rs.close();
st.close();
con.close();
%> 
<p align="center"> 
<a href="index.jsp"  align="center">Home</a>
</p>