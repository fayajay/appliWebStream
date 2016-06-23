<%-- 
    Document   : home
    Created on : 16 juin 2016, 17:01:53
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
    <body id="home">
        <div class="titre">
            <c:import url="_TITRE.jsp"/>
        </div>
        <div class="menu">
            
            <!-- méthode 1-->
            <c:if test="${cookie.identifiant==null}">
                <a class="menu" href="connexion">Connexion</a>
            </c:if>
            <c:if test="${cookie.identifiant!=null}">
                <a href="deconnexion">Déconnexion</a>
            </c:if>

            <!-- méthode 2-->   
            <c:choose>
                <c:when test="${cookie.identifiant==null}">
                    <a href="connexion">Connexion</a>
                </c:when>
                <c:otherwise>
                    <a href="deconnexion">Déconnexion</a>
                </c:otherwise>
            </c:choose>
                    
            <a class="menu" href="inscription">Inscription</a>
        </div>
        <div class="contenu">
            <img src="img/jason2.jpg" width=400 height=400/>
            <img src="img/chucky.jpg" width=400 height=400/>
            <img src="img/freddy.jpg" width=400 height=400/>
            <img src="img/jasonGif.gif" width=400 height=400/>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>
