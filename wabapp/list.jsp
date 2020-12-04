<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF_8">
<title>table list</title>
</head>
<body>
	<p align="left"><a href="/nextlabs/menu.jsp">首页</a></p>
	<p align="center">${tableName}</p>
	<p align="center"><a href="/nextlabs/createInsert?insert=${insert}&tableName=${tableName}">添加</a>  &nbsp; &nbsp; &nbsp;<a href="/nextlabs/download?tableName=${tableName}">下载</a></p>
	<table border="1"  align="center">	
		<thead>
			<tr>
				<c:forEach items ="${tableHeader}" var="ele">
				<th>${ele}</th>
				</c:forEach>
				
			</tr>
		</thead>
		
		<tbody>		
			<c:forEach items = "${user}" var="ele">
			<tr>
				<c:forEach items ="${ele}" var="subEle">			
				<td>${subEle}</td>
				</c:forEach>
				
				<c:forEach items="${ele}" var="ele_id" begin="0" end="0">
				<td><a href="/nextlabs/updateReady?id=${ele_id}&update=${update}&tableName=${tableName}">修改</a></td>				
				<td><a href="/nextlabs/${delete}?id=${ele_id}">删除</a></td>		
				</c:forEach>		
			</tr>
			</c:forEach>				
		</tbody>
	</table>

</body>
</html>