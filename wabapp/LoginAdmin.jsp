<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style> .main{
text-align: center; 
background-color: green;
border-radius: 20px;
width: 500px;
height: 150px;
margin: auto;
position: absolute;
top: 0;
left: 0;
right: 0;
bottom: 0;} 

form{top:100px}
.span{font-color:white}
</style>
</head>

<body background="images/nextlabs.jpg">
	
	<div class="main">
		<span><font color="yellow">NEXTLABS-SKYDRM-RMS 用例管理系统</font></span>
		<form action="/nextlabs/loginPage" method = "POST" align="left">
			&nbsp;<font color="white">username:</font> <input type="text" name ="username"/><font color="white">&nbsp;${userErrorMsg}</font><br/>
			&nbsp;<font color="white">password:</font> &nbsp;<input type="password" name="password"/><font color="white">&nbsp;${passwordErrorMsg}</font><br/>
			<input type="submit" value="login" align="center"/>
		</form>
	</div>

</body>
</html>