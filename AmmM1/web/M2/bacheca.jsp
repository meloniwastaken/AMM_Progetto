

<head>
<title>Bacheca</title>
<meta charset="UTF-8">
<meta name="keywords" content="social, nerd, nerdbook, videogames, anime, bacheca">
<meta name="author" content="Marco Meloni">
<meta name="description" content="Bacheca di Nerdbook">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" type="text/css" href="style.css" media="screen">
</head>

        <c:set var="var" value="Marco" scope="request"/>
        <jsp:include page="header.jsp"/>

<div id="sidebar" class="white_border">
	<div id="persone">
		<p class="side_titolo">Persone</p>
		<p class="amico">Pinco Pallino</p>
		<p class="amico">Riccardo Rossi</p>
		<p class="amico">Mario Bianchi</p>
	</div>
	
	<div id="gruppi">
		<p class="side_titolo">Gruppi</p>
		<p id="mongolfieristi" class="amico">Molgolfieristi</p>
		<p id="ritardatari" class="amico">Ritardatari</p>
	</div>
</div>

<div id="div_body">
	<div id="stato" class="white_border">
		Marco Meloni: GODLIKE!
	</div>

	<div id="post1" class="post white_border">
		<div class="propic">
			<img src="img/propic1.jpg" alt="pro_pic" title="pro_pic">
		</div>
		<div class="name">
			Kermit The Frog
		</div>
		<div class="post_cont">
			I just got called from Sony to appear in a brand new videogame: Knack 2.
		</div>
	</div>

	<div id="post2" class="post white_border">
		<div class="propic">
			<img src="img/propic1.jpg" alt="pro_pic" title="pro_pic">
		</div>
		<div class="name">
			Kermit The Frog
		</div>
		<div class="post_cont">
			<img src="img/post_2.gif" alt="post2_image" id="post2_image">
		</div>
	</div>

	<div id="post3" class="post white_border">
		<div class="propic">
			<img src="img/propic1.jpg" alt="pro_pic" title="pro_pic">
		</div>
		<div class="name">
			Kermit The Frog
		</div>
		<div class="post_cont">
			<a href="https://www.youtube.com/watch?v=F44HRvn8tiA">I'm so damn good.</a>
		</div>
	</div>
</div>

