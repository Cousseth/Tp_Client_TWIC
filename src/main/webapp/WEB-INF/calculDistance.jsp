<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page d'acceuil</title>
</head>
<body>
	<h1>Calcul de distance entre deux villes</h1>


	<p>
		<button type="button"
			onclick="window.location.href='http://localhost:8080/TP_ESEO_API_Rest_Client/Home'">Accueil</button>
	</p>

	<div id="container">
		<form method="post" action="CalculDistance">

			<p>
				<label id="labelVille1" for="ville1">Ville n°1 :</label> <input
					list="villes1" name="ville1" id="ville1" required="required">
				<datalist id="villes1">

					<c:forEach var="ville" items="${listeVille}">
						<option label="${ville.code_commune_INSEE}"
							value="${ville.nom_commune}" />
					</c:forEach>

				</datalist>
			</p>
			<br>
			<p>
				<label id="labelVille2" for="ville2">Ville n°2 :</label> <input
					list="villes2" name="ville2" id="ville2" required="required">
				<datalist id="villes2">

					<c:forEach var="ville" items="${listeVille}">
						<option label="${ville.code_commune_INSEE}"
							value="${ville.nom_commune}" />
					</c:forEach>

				</datalist>
			</p>
			<br> <input id="valid" type="submit"
				value="Calcul de la distance">

		</form>
	</div>
	<div>
		<c:if test="${distance != null}">
			<p>
				<c:out value="La distance entre ${nom1} et ${nom2} " />
				<c:if test="${distance <= 0}">
					<c:out value="n'a pas pu être calculée. " />
				</c:if>
				<c:if test="${distance > 0}">
					<c:out value="est de ${distance} kms." />
				</c:if>
			<p>
		</c:if>

	</div>

</body>
</html>