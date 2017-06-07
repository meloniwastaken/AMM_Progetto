<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div id="sidebar" class="white_border">
    <div>
        <input id="ricerca" type="text" placeholder="Cerca"/>
        <button id="ricercaConferma">Cerca</button>
    </div>
    <div class="side_titolo">Amici</div>
    <div id="persone">
        <c:forEach var="amico" items="${friends}">
            <p>
                <img src="${amico.URLimmagine}" class="smallpic"> <a href="Bacheca?bachecaid=${amico.id}">${amico.nome} ${amico.cognome}</a>
            </p>
        </c:forEach>
    </div>

    <div class="side_titolo">Gruppi</div>
    <div id="gruppi">
        
        <c:forEach var="gruppo" items="${groups}">
            <p>
                <img src="${gruppo.URLimmagine}" class="smallpic"> ${gruppo.nome}
            </p>
        </c:forEach>
    </div>
    <div class="side_titolo">Ricerca</div>
    <div id="research">
        <ul>
            
        </ul>
    </div>
</div>