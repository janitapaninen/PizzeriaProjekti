<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fi.pizzeriaprojekti.admin.bean.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="IE=edge" http-equiv="X-UA-Compatible">
<meta content="width=device-width, initial-scale=1" name="viewport">
<title>Ravintola - FIORI e CASTELLO - Onlinetilaus</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/tyyli.css" rel="stylesheet">

<link href='https://fonts.googleapis.com/css?family=Josefin+Sans:600'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Hammersmith+One'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Capriola'
	rel='stylesheet' type='text/css'>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"
	rel="stylesheet">

<script>
function readCookie(name){
return(document.cookie.match('(^|; )'+name+'=([^;]*)')||0)[2]
}


//takaisin etusivulle alert	
function pois() {
	
	var go = "http://proto293:8080/PizzeriaProjekti/ClientController";
	 

	answer = confirm("Olet poistumassa OnlineTilauksesta. Oletko varma?")

	if (answer !=0){
		window.location = go; 
	} 
}

	
	

</script>

</head>



<body onScroll="document.cookie='ypos=' + window.pageYOffset" onLoad="window.scrollTo(0,readCookie('ypos'))">


	<%
	Locale locale  = new Locale("fi", "FI");
	String pattern = "##0.00";
	DecimalFormat desi = (DecimalFormat) NumberFormat.getNumberInstance(locale);
	desi.applyPattern(pattern);
	%>


	<!--navbar beginning----------------------------------------------------------------------------->

	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

			<a class="navbar-brand" id="poispois" href="http://localhost:8080/PizzeriaProjekti/ClientController" onClick="pois();return false;">Takaisin etusivulle</a>

		</div> 
<!-- -----------------------------------------------------ostoskori beginning----------------------- -->

						<%
							if(session != null && session.getAttribute("kori")!=null ) {
										            	ArrayList<ostoskoriPizza> ostoskoriPizzat = (ArrayList<ostoskoriPizza>)session.getAttribute("kori");
										            	
										            	%>		
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown" id="ostosKori"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false"> <span
						class="glyphicon glyphicon-shopping-cart"></span>Tuotteet<span
						class="caret"></span></a>
					<ul class="dropdown-menu dropdown-cart" role="menu">
										            	
										            	<%		            	
										            	for(int i=0; i< ostoskoriPizzat.size(); i++) {
						%>
						
						<li><span class="item"> <span class="item-left">
									<img src="img/minipizza.png" alt="" /> <span class="item-info">
										<span><%=ostoskoriPizzat.get(i).getNimi()%></span> <span><%=desi.format(ostoskoriPizzat.get(i).getHinta())%></span>
								<span><%=ostoskoriPizzat.get(i).getLkm() %></span></span>
							</span>

								<form action="TilausController" method="post">
									<span class="item-right"> 
									<input type="hidden" class="btn btn-xs btn-danger pull-right" name="action" value="poistakorista" /> 
									<input type="hidden" name="pizzanumero" value="<%out.print(ostoskoriPizzat.get(i).getId()); %>" />
										<button class="btn btn-xs btn-danger pull-right" type="submit">
											x
											</button></span>
						</form>
					</span>
					</li>
						<%
							}
										            }
						%>
						<%
							if(session != null && session.getAttribute("kori")!=null ) {
						%>
						<form action="TilausController" method="post">
						
						<input type="hidden" name="action2" method="post" value="tyhjaa"/>
						<button type="submit" class="text-center">Tyhjää kori</button>
						</form>
						<li><a class="text-center" href="kassaNakyma.jsp">Siirry kassalle</a></li>
						<%
							}
						%>
					</ul></li>
			</ul>
		</div>
	</div>
	</nav>



	<!-- beginning of header------------------------------------------------------------------------------------>
<header>

	<div id="header" class="shadow">
		<!-- Logo -->
		<div class="hidden-xs col-sm-4 col-md-4 col-lg-4">
			<img alt="logo" id="logo" src="img/logo_yellow_sm.png">
		</div>

		<!-- Teksti -->
		<div class="col-xs-12 col-sm-8 col-md-8 col-lg-6">
			<div class="intro">
				<h1 class="h1Head">Tervetuloa onlinetilaukseen!</h1>
				<p>

					***Huom! Vain nouto!***<br> Voitte nauttia pizzoista myös
					xxxxkadun ravintolassamme. Pöytävarauksen voit tehdä soittamalla
					numeroon 123456789.
				</p>

				<h1 class="h1Head">Aukioloajat</h1>
				MA-PE 10:30 - 21:00 <br>LAUANTAI 11:30 - 21:00 <br>SUNNUNTAI
				11:30 - 18:00
			</div>
		</div>
		<div class="col-md-2 col-lg-2 hidden-xs hidden-sm"></div>
	</div>


</header>

	<div class="rako">
	<form action="TilausController" method="get">

			<select name='action' onchange='this.form.submit()' class="jarjesta">
				<option>Järjestä</option>
				<option value="jarjestaHinta"><a href="http://localhost:8080/PizzeriaProjekti/TilausController?action=jarjestaHinta&index=jarjestaHinta&index=jarjestaNimi">Hintajärjestykseen</a></option>

				<option value="jarjestaNimi"><a href="http://localhost:8080/PizzeriaProjekti/TilausController?index=jarjestaHinta&action=jarjestaNimi&index=jarjestaNimi">Aakkosjärjestykseen</a></option>
			</select>
			<noscript>
				<input type="submit" value="Submit">
			</noscript>

		</form>	
		</div>
	<!----------------------------------------------------------------end of header--------------------------------->

	<!----------------------------------------------------beginning of pizzas------------------------------------->


<!-- PIZZA CONTAINER  -->							                				
<div class="container-fluid">
			<%
				ArrayList<Pizza> pizzat = (ArrayList<Pizza>)request.getAttribute("pizzat");

						
				for(int i=0; i < pizzat.size(); i++) {
				out.print("<form action=\"TilausController\" method=\"get\">");
						

						/*PIZZA COL*/
						out.println("<div class=\"col-xs-12 col-sm-6 col-md-6 col-lg-4\">");
						
						/*PIZZA CONTAINER*/
						out.println("<div class=\"pizzaContainer\">");
						
							/*PHOTOBOX*/
							out.println("<div class=\"col-xs-12 boxPizzaImg\">");		
								out.println("<img class=\"pizzaPhoto\"alt=\"photo of pizza\" id=\"pizza1\" src=\"img/pizza-b2.png\" >");
							out.println("</div>");
							/*END PHOTOBOX*/
							
							/*TEXTBOX*/
							out.println("<div class=\"col-xs-12 boxPizzaTxt\">");
								/*TEXT*/ 
								out.println("<div class=\"menuitemheadBox\">");
								out.println("<p class=\"lead menuitemhead\">" + pizzat.get(i).getNimi().toUpperCase() + " </p>");
								out.println("</div>");
								out.println("<p class=\"menufilling\">" + pizzat.get(i).getTaytteet() + " </p>");
								
								out.println("<div class=\"row price\">");
									out.println("<div class=\"col-xs-12 center noMarginPadding\">");
										out.println("<h5 class=\"menuitemprice\">" + desi.format(pizzat.get(i).getHinta()) + "€</h5>");
									out.println("</div>");
								out.println("</div>");
								
								/*BUTTON ROW*/	
								out.println("<div class=\"row bottom\">");
									out.println("<div class=\"col-xs-12 center noMarginPadding\">");
									
									/*LKM TXT*/
									out.println("<div class=\"col-xs-5 \">");
										out.println("<p>Lukumäärä:</p>");

									out.println("</div>");
									
									
out.print("</form>");
									
									out.print("<form action=\"TilausController\" method=\"post\">");
									/*LKM*/
									out.println("<div class=\"col-xs-2  center noMarginPadding\">");
									
									out.println("<input class=\"inputSmall\" type=\"number\" size=\"2\" name=\"lkm\" min=\"1\" max=\"25\" value= \"1\">");
									out.println("</div>");
									
									/*BUTTON*/
									out.println("<div class=\"col-xs-5 center noMarginPadding\">");
									
									
									
										out.println("<input type=\"hidden\" name=\"action\" value=\"lisaa\"/>");
										out.println("<input type=\"hidden\" name=\"pizzanumero\" value=\""+pizzat.get(i).getId()+"\"/>");
									
										out.println("<button class=\"btn btn-primary btn-sm outline lisaanappi\" type=\"submit\"><b>Lisää koriin</b></button>");
									out.println("</div>");
									
										
									out.println("</div>");
								/*END CHECKBOX/BUTTON ROW*/	
								out.println("</div>");
							/*END TEXTBOX*/	
							out.println("</div>");
							
						/*END PIZZA CONTAINER*/
						out.println("</div>");	
						
						/*END PIZZA COL*/
						out.println("</div>");
					
						
					
				out.print("</form>");
				}		
						
		
			%>

<!-- END PIZZA CONTAINER  -->
</div>





	<!--end of pizzas----------------------------------------------------------------------------------->
	<div class="rako"></div>
	<!--beginning of footer----------------------------------------------------------------------------->
	<div id="footer">
		<div class="row">
			<div class="col-md-12">
				<div class="col-md-6">
					<p>something something</p>
					<div class="row">
						<div class="col-md-12">
							<p>FIORI e CASTELLO 2015</p>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="col-md-3"></div>
					<div class="col-md-2">
						<i class="fa fa-facebook fa-3x"></i>
					</div>
					<div class="col-md-2">
						<i class="fa fa-pinterest-p fa-3x"></i>
					</div>
					<div class="col-md-2">
						<i class="fa fa-instagram fa-3x"></i>
					</div>
					<div class="col-md-3"></div>
				</div>
			</div>
		</div>
	</div>
	<!--end of footer--------------------------------------------------------------------------------->
	<!--scrollup-------------------------------------------------------------------------------------->
	<ul class="nav pull-right scroll-top hidden">
  		<li><a href="#" title="Takaisin alkuun"><i class="glyphicon glyphicon-chevron-up"></i></a></li>
	</ul>
	<!--/scrollup------------------------------------------------------------------------------------->
	<script src="js/jquery-2.1.4.min.js"></script>

	<script src="js/bootstrap.min.js"></script>

	<script src="js/index.js" type="text/javascript">
		
	</script>
</body>
</html>