<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${message}" />
	<p>
		<button type="button"
			onclick="window.location.href='http://localhost:8080/TP_ESEO_API_Rest_Client/Home'">Accueil</button>
	</p>
</body>
</html>