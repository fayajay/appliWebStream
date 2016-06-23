<%-- 
    Document   : _TEMPLATE
    Created on : 17 juin 2016, 10:50:04
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
            
        </div>
        <div class="contenu">
            <h2>Inscription</h2>
                <form method="POST">
                    Identifiant : <input type="text" name="identifiant"/><br/>
                    Mot de Passe : <input type="password" name="login"/><br/>
                    Mot de Passe : <input type="password" name="login"/><br/>
                    Email : <input type="text" name="email"/></br>
                    <input type="submit" value="connexion"/>
                    <input type="reset" value="annuler"/>
                </form>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>
