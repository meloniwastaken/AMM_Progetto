<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
    <title>Bacheca</title>
    <meta charset="UTF-8">
    <meta name="keywords" content="social, nerd, nerdbook, videogames, anime, bacheca">
    <meta name="author" content="Marco Meloni">
    <meta name="description" content="Bacheca di Nerdbook">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" type="text/css" href="style.css" media="screen">
</head>

<body>
    <c:set var="active" value="Bacheca" scope="request" />
    <jsp:include page="header.jsp" />

    <jsp:include page="sidebar.jsp" />

    <c:if test="${loggedIn!=null && titolarebacheca!=null}">
        <div id="div_body">

            <jsp:include page="frase.jsp" />
            <div class="post white_border">
                <form action="Bacheca?revision=1&bachecaid=${titolarebacheca.id}" method="post" id="post_form">
                    <div class="row">
                        <label for="text" class="cell">
                            Testo
                        </label>
                        <input type="text" name="text" value="" id="text" class="cell">
                    </div>
                    <div class="row">
                        <label for="img" class="cell">
                            Immagine
                        </label>
                        <input type="text" name="img" value="" id="img" class="cell">
                    </div>
                    <button>
                        Post
                    </button>
                </form>
            </div>

            <c:if test="${revision == true}">
                <form action="Bacheca?confirm=1&bachecaid=${titolarebacheca.id}" method="post" id="confirm_form">
                    <div class="post white_border">
                        <div class="propic">
                            <img src="${utente.URLimmagine}" alt="pro_pic" title="pro_pic">
                        </div>
                        <c:if test="${utente.id != titolarebacheca.id}">
                            <div class="name">
                                ${utente.nome} ${utente.cognome} a ${titolarebacheca.nome} ${titolarebacheca.cognome}
                            </div>
                        </c:if>
                        <c:if test="${utente.id == titolarebacheca.id}">
                            <div class="name">
                                ${utente.nome} ${utente.cognome}
                            </div>
                        </c:if>
                        <c:if test="${post_r.image != ''}">
                            <div class="post_cont">
                                <img src="${post_r.image}">
                            </div>
                        </c:if>
                        <c:if test="${post_r.text != ''}">
                            <div class="post_cont">
                                ${post_r.text}
                            </div>
                        </c:if>
                        <div>
                            <button>
                                Conferma
                            </button>
                        </div>
                    </div>
                </form>
            </c:if>
            <c:if test="${confirm == true}">
                <c:if test="${titolarebacheca.id != utente.id}">
                    <div class="post white_border">
                        Hai scritto sulla bacheca di ${titolarebacheca.nome} ${titolarebacheca.cognome}
                    </div>
                </c:if>
                <c:if test="${titolarebacheca.id == utente.id}">
                    <div class="post white_border">
                        Hai scritto sulla tua bacheca
                    </div>
                </c:if>
                <div class="post white_border">
                    <div class="propic">
                            <img src="${post_r.creatorUser.URLimmagine}" alt="pro_pic" title="pro_pic">
                    </div>
                        <div class="name">
                            <a href="Bacheca?bachecaid=${post_r.creatorUser.id}">${post_r.creatorUser.nome} ${post_r.creatorUser.cognome}</a>
                        </div>
                    <c:if test="${post_r.image != ''}">
                        <div class="post_cont">
                            <img src="${post_r.image}">
                        </div>
                    </c:if>
                    <c:if test="${post_r.text != ''}">
                        <div class="post_cont">
                            ${post_r.text}
                        </div>
                    </c:if>
                </div>
            </c:if>

            <c:forEach var="post" items="${posts}">
                <div class="post white_border">
                    <div class="propic">
                            <img src="${post.creatorUser.URLimmagine}" alt="pro_pic" title="pro_pic">
                    </div>
                        <div class="name">
                            <a href="Bacheca?bachecaid=${post.creatorUser.id}">${post.creatorUser.nome} ${post.creatorUser.cognome}</a>
                        </div>
                    <c:if test="${post.image != ''}">
                        <div class="post_cont">
                            <img src="${post.image}">
                        </div>
                    </c:if>
                    <c:if test="${post.text != ''}">
                        <div class="post_cont">
                            ${post.text}
                        </div>
                    </c:if>
                </div>
            </c:forEach>

        </div>
    </c:if>
    <c:if test="${loggedIn == null || titolarebacheca == null}">
        <div>
            Accesso Negato
        </div>
    </c:if>
</body>

</html>