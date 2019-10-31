<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Films</title>
</head>
<body>
<h2>Rechercher un film</h2>
<form action="FilmServlets">
<button type ="SUBMIT">Afficher tous les films</button>
</form>
<form action="FilmLikeServlets">
Titre: <input name="titre" id="titre" size="8"> <button>Rechercher</button>
</form>
</body>
</html>