<%-- 
    Document   : sidebar
    Created on : 2-mag-2017, 10.36.05
    Author     : Marco
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="sidebar" class="white_border">
	<div id="persone">
		<p class="side_titolo">Amici</p>                
                <c:forEach var="amico" items="${friends}">
                    <p>
                        <img src="${amico.URLimmagine}" class="smallpic"> <a href="Bacheca?bachecaid=${amico.id}">${amico.nome} ${amico.cognome}</a>
                    </p>
                </c:forEach>
	</div>
	
	<div id="gruppi">
		<p class="side_titolo">Gruppi</p>
                <c:forEach var="gruppo" items="${groups}">
                    <p>
                       <img src="${gruppo.URLimmagine}" class="smallpic"> ${gruppo.nome}
                    </p>
                </c:forEach>
	</div>
</div>
