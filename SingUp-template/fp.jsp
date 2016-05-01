<%@ include file="header.jsp" %>
<html>
<body>
<br><br><br>
<form action="fpp.jsp" method="post">
<p align="center"><font size="9pts" face="Tahoma" color="#3b5998">Enter Username</font></p>
<p align="center"><input type="text" name="name" oninvalid="alert('Please fill username');" required><br><br></p>
<p align="center"><input type="submit" value="Change Password"></p>

</form></body>
</html>