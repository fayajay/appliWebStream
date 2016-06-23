<%-- 
    Document   : _STYLESHEET
    Created on : 17 juin 2016, 10:51:03
    Author     : tom
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href='https://fonts.googleapis.com/css?family=Butcherman' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Jolly+Lodger' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Creepster' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Nosifer' rel='stylesheet' type='text/css'>
<link href="CSS/style1.css" rel="stylesheet" type="text/css"/>
<link href="CSS/style2.css" rel="stylesheet" type="text/css"/>

<c:choose>
    <c:when test="${cookie.changeImage.getName()=='fond1'}">
        <c:import url="/css/style1.css"/>
    </c:when>
    <c:when test="${cookie.changeImage.getName()=='fond2'}">
        <c:import url="/css/style2.css"/>
    </c:when>
    <c:otherwise>
        <c:import url="/css/style1.css"/>
    </c:otherwise>
</c:choose>


