<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Films</title>
</head>
<body>
<h2>${titre }</h2>
<table>
	<c:forEach items="${films }" var="film">
	<form action="CaddyServlets" METHOD="POST">
		    <tr><td><input id="id" name="id" type="hidden" value=${film.id }></input></td>
		    <td>${film.titre }</td>
			<td>${film.realisateur }</td>
			<td>${film.dateSortie }</td>
			<td>${film.duree }</td>
			<td>${film.prixHT }</td>
			<td><input type="submit" value ="Ajouter au panier"></input></td>
		</tr>
		</form>
	</c:forEach>
</table>
<a href="Caddy.jsp">Voir le panier</a>
<a href="index.jsp">Retour</a>
</body>
</html>