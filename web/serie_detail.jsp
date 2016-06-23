<%-- 
    Document   : serie_detail
    Created on : 20 juin 2016, 09:57:15
    Author     : admin
--%>
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
                <h2>${serie.titre}</h2>
                <p>${serie.synopsis}</p>
                <p>Réalisé par : 
                    <c:forEach items="${serie.realisateurs}" var="real">
                        ${real.prenom} ${real.nom}
                    </c:forEach>
                </p>
                <p>Acteurs : 
                    <c:forEach items="${serie.acteurs}" var="act">
                        ${act.prenom} ${act.nom},
                    </c:forEach>
                </p>
                <p> <c:forEach items="${serie.saisons}" var="saison">
                        <br/>Saison : ${saison.numSaison}<br/>
                        <c:forEach items="${saison.episodes}" var="epi">
                            <a href="${lien.url}"># ${epi.numEpisode} /</a>
                        </c:forEach>
                    </c:forEach>
                </p>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>