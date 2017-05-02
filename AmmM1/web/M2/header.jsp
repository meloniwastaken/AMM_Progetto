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
				${var}
			</div>
			<div>
				<a href="login.html">Logout</a>
			</div>
		</div>
	</div>	
	<div id="div1" class="header_writing white_border">
		<a href="descrizione.html">Nerdbook</a>
	</div>
	<div class="header_writing div_right white_border">
		<a href="profilo.html">Profilo</a>
	</div>
	<div id="current" class="header_writing div_right white_border">
		Bacheca
	</div>
    </header>

