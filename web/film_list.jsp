
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
            
            Choisissez votre fond d'écran : <a href="changeImage?style=style1">Style1</a>//<a href="changeImage?style=style2">Style2</a>
            <h2>Liste des films</h2>
            
                <table>
                    <tr>
                        <th>TITRE</th>
                        <th>ANNEE</th>
                        <th>GENRE</th>
                        <th>PAYS</th>
                    </tr>
                <c:forEach items="${films}" var="f">
                    <tr>
                        <td><a href='film_detail?id=${f.id}'>${f.titre}</a></td>
                        <td>${f.annee}</td>
                        <td>${f.genre.nom}</td>
                        <td><c:forEach items="${f.pays}" var="p">${p.nom}</c:forEach></td>
                        <td><a id="supprimer" href='film_supprimer?id= '>supprimer</a></td>
                    </tr>
                </c:forEach>
                </table>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>
