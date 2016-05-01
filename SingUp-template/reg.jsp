<%@ include file="header.jsp" %>
<html>
<head>
<title>Register Now!</title>
<body>
<form action="register.jsp" method="POST" onsubmit="ok()">
<p align="center"><font size="9" face="Berlin Sans FB" color="#3b5998">Register Here!</font></p><br>
<p align="center"><font face="Tahoma">Your Name<input type="text" name="name" id="n" oninvalid="alert('please fill your name');" required></font></p>
<p align="center"><font face="Tahoma">Your Password<input type="password" name="pass" id="p" oninvalid="alert('please fil your password');" required></font></p>
<br>

<p align="center">
<input type="submit" value="Sign Up!">
</p>
</form>
<script>
function ok(){
	window.alert("Sign up successfull! Login again to continue");
}</script>




</body>
</head>
</html>