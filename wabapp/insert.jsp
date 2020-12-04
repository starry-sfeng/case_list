<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert data</title>

<style> .main{
text-align: center; 
background-color: green;
border-radius: 20px;
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

<body>
	<div class="main">
		<span><font color="yellow">${tableName}</font></span><br/>
		<form action="/nextlabs/${insert}" method = "POST" align="center">
			<c:forEach items ="${tableHeader}" var="ele">
				&nbsp;<font color="white">${ele}:</font> <input type="text" name ="${ele}"/><br/>
			</c:forEach>
		   
		
			<input type="submit" value="add" align="center"/>
		</form>
	</div>
</body>
</html>