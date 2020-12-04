<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>

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
		<form action="/nextlabs/${update}" method = "POST" align="center">
		   
			<c:forEach items ="${message}" var="ele">
				<c:forEach items="${ele}" var = "subEle" begin="0" end="0">
				&nbsp;<font color="white">${subEle}:</font> 
					<c:forEach items="${ele}" var = "subEle2" begin="1" end="1">
					<input type="text" name ="${subEle}" value="${subEle2}"/><br/>
					</c:forEach>
				</c:forEach>
				
			</c:forEach>
		
			<input type="submit" value="update" align="center"/>
		</form>
	</div>
</body>
</html>