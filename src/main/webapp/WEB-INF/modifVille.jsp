<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification des Villes</title>
</head>
<body>
	<h1>Modification des Villes</h1>


	<form action="ListeVille" method="post">

		<label>Code Commune INSEE : </label>
		<c:out value="${codeVille}" />
		<input type="text" hidden="hidden" name="code_commune_insee"
			id="code_commune_insee" value="${codeVille}" required="required" />

		<div>
			<label>Code postal : </label> <input type="text" name="code_postal"
				id="code_postal" />
		</div>
		<div>
			<label>Nom Commune : </label> <input type="text" name="nom_commune"
				id="nom_commune" />
		</div>
		<div>
			<label>Libelle Acheminement : </label> <input type="text"
				name="libelle_acheminement" id="libelle_acheminement" />
		</div>
		<div>
			<label>ligne 5 : </label> <input type="text" name="ligne_5"
				id="ligne_5" />
		</div>
		<div>
			<label>Latitude : </label> <input type="text" name="latitude"
				id="latitude" />
		</div>
		<div>
			<label>Longitude : </label> <input type="text" name="longitude"
				id="longitude" />
		</div>

		<input type="submit" value="Envoyer">

	</form>

	<p>
		<button type="button"
			onclick="window.location.href='http://localhost:8080/TP_ESEO_API_Rest_Client/Home'">Accueil</button>
	</p>
	<p>
		<button type="button"
			onclick="window.location.href='http://localhost:8080/TP_ESEO_API_Rest_Client/ListeVille'">Retour</button>
	</p>
</body>
</html>