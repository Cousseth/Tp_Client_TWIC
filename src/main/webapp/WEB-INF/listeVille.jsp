<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>

<meta charset="UTF-8">
<title>Liste Ville</title>

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css" />
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#table").DataTable();
	});
</script>

</head>

<body>
	<h1>Liste des villes</h1>
	<button type="button"
		onclick="window.location.href='http://localhost:8080/TP_ESEO_API_Rest_Client/Home'">Accueil</button>

	<button type="button"
		onclick="window.location.href='http://localhost:8080/TP_ESEO_API_Rest_Client/AjouterVille'">Ajouter
		Ville</button>

	<p />
	<table id="table" class="display">
		<thead>
			<tr>
				<th>code_commune_INSEE</th>
				<th>code_postal</th>
				<th>nom_commune</th>
				<th>libelle_acheminement</th>
				<th>ligne_5</th>
				<th>latitude</th>
				<th>longitude</th>
				<th>Modifier</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="i" begin="0"
				end="${listeVille.size()-1}" step="1">
				<tr>
					<td><c:out value="${listeVille.get(i).code_commune_INSEE}" /></td>
					<td><c:out value="${listeVille.get(i).code_postal}" /></td>
					<td><c:out value="${listeVille.get(i).nom_commune}" /></td>
					<td><c:out value="${listeVille.get(i).libelle_acheminement}" /></td>
					<td><c:out value="${listeVille.get(i).ligne_5}" /></td>
					<td><c:out value="${listeVille.get(i).latitude}" /></td>
					<td><c:out value="${listeVille.get(i).longitude}" /></td>
					<td>
						<form action="ModifierVille" method="post">
							<input name="codeVille" hidden="hidden"
								value="${listeVille.get(i).code_commune_INSEE}" /> <input
								type="submit" value="Modifier" />
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>