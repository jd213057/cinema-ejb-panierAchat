<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Panier d'achats</title>
</head>
<body>
<table>
	<c:forEach items="${films }" var="film">

		    <tr>
		    <td>${film.titre }</td>
			<td>${film.realisateur }</td>
			<td>${film.dateSortie }</td>
			<td>${film.duree }</td>
			<td>${film.prixHT }</td>
<td>
		<form action="DeleteFilmServlets" METHOD="GET">
            <input id= "id" name="id" type ="hidden" value="${film.id }"/>
            <button type="SUBMIT">Retirer du panier</button>
             </form></td>
			</tr>
	</c:forEach>
</table> </br>
<h3> Le prix total est de : </h3><h3> ${prixTotal} €</h3>
<form action="FilmServlets">
<button type ="SUBMIT">Retour à la videothèque</button>
</form>
</body>
</html>