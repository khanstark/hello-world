
<%@ page import="java.sql.*" %>
<%
String uname=request.getParameter("name");
String passw=request.getParameter("pass");
String x=request.getParameter("cap");
if((session.getAttribute("val")).equals(x))
{

session.setAttribute("urname",uname);

try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","kaifkhan");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from login where name='"+uname+"' and pass='"+passw+"'");
if(rs.next())
{
response.sendRedirect("success.jsp");
}
else
{
%>
<script>
window.alert("Invalid user.Please check the credentials again");
</script>

<%
response.sendRedirect("index.jsp");
}

rs.close();
st.close();
con.close();
}
catch(Exception e)
{
	out.println(e.getMessage());
}
}
else{
	%>
	<script>
	alert("Wrong captcha entry!");
	</script>
	<%
}



%>