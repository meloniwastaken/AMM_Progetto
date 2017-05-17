<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="it">

<head>
    <title>Profilo</title>
    <meta charset="UTF-8">
    <meta name="keywords" content="social, nerd, nerdbook, videogames, anime, profilo">
    <meta name="author" content="Marco Meloni">
    <meta name="description" content="Profilo di Nerdbook">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" type="text/css" href="style.css" media="screen">

</head>

<body>

    <c:set var="active" value="Profilo" scope="request" />
    <jsp:include page="header.jsp" />

    <jsp:include page="sidebar.jsp" />

    <c:if test="${loggedIn == true}">
        <div>
            <img src="${utente.URLimmagine}" id="propic">
        </div>

        <div id="div_body">
            <form action="Profilo?update=1" method="post" id="signup">
                <div id="label_div">
                    <div class="row">
                        <label for="nome">Nome</label>
                        <input type="text" name="nome" value="${utente.nome}" id="nome">
                    </div>
                    <div class="row">
                        <label for="cognome">Cognome</label>
                        <input type="text" name="cognome" value="${utente.cognome}" id="cognome">
                    </div>
                    <div class="row">
                        <label for="email">Email</label>
                        <input type="text" name="email" value="${utente.email}" id="email">
                    </div>
                    <div class="row">
                        <label for="propic">URL Immagine del profilo</label>
                        <input type="text" name="profile_imm" value="${utente.URLimmagine}" id="profile_imm">
                    </div>
                    <div class="row">
                        <label for="frase">Frase di presentazione</label>
                        <input type="text" name="frase" value="${utente.frase}" id="frase">
                    </div>
                    <div class="row">
                        <label for="data">Data di nascita</label>
                        <input type="date" name="data" value="${utente.data}" id="data">
                        <!-- utente.data non funziona in <input type="date"> -->
                    </div>
                    <div class="row">
                        <label for="password">Password</label>
                        <input type="password" name="password" value="" id="password">
                    </div>
                    <div class="row">
                        <label for="passwordconf">Conferma Password</label>
                        <input type="password" name="passwordconf" value="" id="passwordconf">
                    </div>
                    <div>
                        <button>Aggiorna</button>
                    </div>
                    <c:if test="${update == true}">
                        <div>
                            Aggiornamento riuscito!
                        </div>
                    </c:if>
                    <c:if test="${update == false}">
                        <div>
                            Aggiornamento fallito! Ricontrolla i campi!
                        </div>
                    </c:if>
                </div>
            </form>
                        <form action="Profilo?delete=1" method="post" id="delete">
                            <button> delete </button>
                        </form>

        </div>
    </c:if>
    <c:if test="${loggedIn == null}">
        <div>
            Accesso Negato
        </div>
    </c:if>
</body>

</html>