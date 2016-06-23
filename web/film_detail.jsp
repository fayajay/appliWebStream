

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <c:import url="_STYLESHEET.jsp"/>
    </head>
    <body>
        <div class="titre">
            <c:import url="_TITRE.jsp"/>
        </div>
        <div class="menu">
            <c:import url="_MENU.jsp"/>
        </div>
        <div class="contenu">
                <h2>${film.titre}</h2>
                <p>${film.synopsis}</p>
                <p>Réalisé par : 
                    <c:forEach items="${film.realisateurs}" var="real">
                        ${real.prenom} ${real.nom}
                    </c:forEach>
                </p>
                <table border='1'>
                    <tr>
                        <th>ANNEE</th>
                        <th>GENRE</th>
                        <th>PAYS</th>
                    </tr>
                    <tr>
                        <td>${film.annee}</td>
                        <td>${film.genre.nom}</td>
                        <td><c:forEach items="${film.pays}" var="p">${p.nom}</c:forEach></td>
                    </tr>
                
                </table>
                <p>Liens : 
                    <c:forEach items="${film.liens}" var="lien">
                        ${lien.langue} ${lien.qualite} <a href="${lien.url}">Voir le film</a>
                    </c:forEach>
                </p>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>
