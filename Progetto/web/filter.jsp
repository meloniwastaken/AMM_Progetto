<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<json:array>
    <c:forEach var="user" items="${ret}">
        <json:object>
            <json:property name="nome" value="${user.nome}"/>
            <json:property name="cognome" value="${user.cognome}"/>
            <json:property name="id" value="${user.id}"/>
        </json:object>
    </c:forEach>
</json:array>