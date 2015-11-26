<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h2>Hello World!</h2>
	<c:if test="${not empty food}">
		<h3>Food: ${food.foodName}</h3>
		<h4>Avatar link: ${food.avatarLink}</h4>
		<img src="${food.avatarLink}" />
	</c:if>
</body>
</html>
