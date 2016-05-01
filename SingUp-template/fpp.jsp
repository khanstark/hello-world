<%@ page import="java.sql.*" %>
<%
String uname=request.getParameter("name");

int i=0;
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","kaifkhan");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select name  from login");
while(rs.next())
{
	String un=rs.getString("name");
	if(uname.equals(un))
	{
		i=1;
		session.setAttribute("uname",uname);
		 response.sendRedirect("cp.jsp");
		break;
	}
	
}
	if(i==0)
	{
	%>
		<script>
		window.alert("user doesn't exists in our records");
		</script>
		<%
		
	}


%>