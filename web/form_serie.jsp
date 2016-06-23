<%-- 
    Document   : form
    Created on : 17 juin 2016, 09:37:40
    Author     : tom
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
                    <h2>Formulaire</h2>
        <form method="post">
            Titre: <input type="text" name="titre"/>
            <br/>
            Synopsis: <textarea name="synopsis"></textarea>
            <br/>
            Nombre de saisons: <input type="text" name="saison"/>
            Nombre d'épisodes: <input type="text" name="episode"/>
            <br/>
            Genre:
            <select name="genre">
                <c:forEach items="${genre}" var="genre" >
                    <option value="${genre.id}">${genre.nom}</option>
                </c:forEach>
            </select>
            <br/>
            Pays:
            <select name="pays">
                <option>FR</option>
                <option>UK</option>
                <option>USA</option>
            </select>
            <br/>
            <input type="submit"/>
        </form>
            
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>
