<%-- 
    Document   : _TITRE
    Created on : 17 juin 2016, 10:54:26
    Author     : tom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<a class="menu" href="films_lister">Films</a>
<a class="menu" href="serie_lister">Séries</a>
<a class="menu" href="form">Ajouter film</a>
<a class="menu" href="form_serie">Ajouter Série</a>
<c:if test="${utilConnecte.identifiant!=null}">
                <a href="deconnexion">Déconnexion</a>
            </c:if>