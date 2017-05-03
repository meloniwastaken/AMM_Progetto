<%-- 
    Document   : header
    Created on : 30-apr-2017, 19.00.32
    Author     : Marco
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <header>
	<div class="float_right">
		<div>
			<div>
                            ${utente.nome} ${utente.cognome}
			</div>
			<div>
				<a href="Login?logout=1">
                                    <c:if test="${loggedIn!=null}">Logout</c:if>
                                    <c:if test="${loggedIn==null}">Login</c:if>
                                </a>
			</div>
		</div>
	</div>	
	<div id="div1" class="header_writing white_border" <c:if test="${active=='Nerdbook'}">id="current"</c:if> >
		<a href="descrizione.html">Nerdbook</a>
	</div>
	<div class="header_writing div_right white_border" <c:if test="${active=='Profilo'}">id="current"</c:if> >
		<a href="Profilo">Profilo</a>
	</div>
	<div class="header_writing div_right white_border" <c:if test="${active=='Bacheca'}">id="current"</c:if> >
                <a href="Bacheca">Bacheca</a>
	</div>
    </header>

