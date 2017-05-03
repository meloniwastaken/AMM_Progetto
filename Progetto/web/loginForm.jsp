<%-- 
    Document   : loginForm
    Created on : 2-mag-2017, 11.02.42
    Author     : Marco
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
<head>
<title>Login</title>
<meta charset="UTF-8">
<meta name="keywords" content="social, nerd, nerdbook, videogames, anime, login">
<meta name="author" content="Marco Meloni">
<meta name="description" content="Login di Nerdbook">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" type="text/css" href="style.css" media="screen">

</head>
<body>

<div id="divBody">
	<div id="header_login" class="row">
		<div style="display: table-cell">
			<img src="img/n.png" class="logo">
		</div>
		<div id="login_title" style="display: table-cell">
			<h1> Nerdbook </h1>
		</div>
	</div>
        <c:if test="${invalidData == true}">
            <div> Username o Password errati </div>
        </c:if>
	<form action="Login" method="post" id="form_login">
		<div id="login_form" class="center">
			<div class="row">
				<label for="username">
					Username
				</label>
				<input type="text" name="username" value="Username" id="username" class="input_row">
			</div>
			<div class="row">
				<label for="password">
					Password
				</label>
				<input type="password" name="password" value="" id="password" class="input_row">
			</div>
			<div>
				<button>
					Login
				</button>
			</div>
		</div>
    </form>

</div>

</body>
</html>