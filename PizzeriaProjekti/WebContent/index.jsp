<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="fi.pizzeriaprojekti.admin.bean.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC>
<html>
<head>

<script>
function readCookie(name){
return(document.cookie.match('(^|; )'+name+'=([^;]*)')||0)[2]
}
</script>

<title>Ravintola - FIORI e CASTELLO</title>
<meta name="viewport"
	content="user-scalable=no, initial-scale=1, maximum-scale=1, minimum-scale=1, width=320, height=device-height, target-densitydpi=medium-dpi" />
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1" name="viewport">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" media="screen" rel="stylesheet">
<!-- Omat tyylit -->
<link href="css/default.css" media="screen" rel="stylesheet">
<link href="css/default_max768.css" media="screen and (max-width: 768px)" rel="stylesheet">
<!-- link href="css/scrolling-nav.css" media="screen" rel="stylesheet" -->


<link href='https://fonts.googleapis.com/css?family=Josefin+Sans:600'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Hammersmith+One'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Capriola'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Lobster'
	rel='stylesheet' type='text/css'>	

<link href='https://fonts.googleapis.com/css?family=Caveat'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Quando'
	rel='stylesheet' type='text/css'>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"
	rel="stylesheet">

<!--script src="scrollfix.js" type="text/javascript"></script-->

</head>
<body onScroll="document.cookie='ypos=' + window.pageYOffset" onLoad="window.scrollTo(0,readCookie('ypos'))">

	<!-- pääsivun taustakuva -->
	<div id="bg">
		<div class="container-fluid">
			<header>
				<!-- TODO: h1&p logot poistoon -->
				<h1 class="logo hidden-xs">
					FIORI e<br> CASTELLO
				</h1>
				<br>
				<p class="logo2 hidden-xs">Restaurant & bar</p>
				<p class=headerTxt>Lorem ipsum dolor sit amet. Lorem ipsum!</p>
				<!-- TODO: YLEMPI TXTLOGO KORVATAAN ALEMMALLA KUVALOGOLLA-->
				<!--img id="LOGO" title="TITLE" alt="logo" src="img/logotähän.png"></img-->
				<!--div class="row">
                    <div class="col-md-12 col-xs-12" style="background:black;color:white"></div>
                </div-->
				<!--/div-->
				<div class="row bottom">
					<p class=headerTxtSm>Tutustu meihin lisää</p>
				</div>
			</header>
		<div id="customerBtnWrap">
			<div class="row">
				<div class="col-md-12">
				<div class="hidden-xs hidden-sm col-md-2 col-lg-2"></div>
					<div class="col-sm-6 col-md-4 col-lg-4">
						<div class="customerBtnContainer">
						<form action="TilausController" method="get">
							<button id="onlineBtn" class="customerBtn" type="submit" value="OnlineTilausnäkymä" name="Submit"
							id="frm3_submit"> <p>Tilaa noutopizzasi netistä</p> </button>
						</form>
						</div>
					</div>
					<div class="col-sm-6 col-md-4 col-lg-4">
						<div class="customerBtnContainer">
						
<!-- Button trigger modal -->
<button id="varausBtn" class="customerBtn" data-toggle="modal" data-target="#myModal"><p>Tee pöytävaraus</p></button>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="vertical-alignment-helper">
        <div class="modal-dialog vertical-align-center">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span>

                    </button>
                     <h5 class="modal-title" id="myModalLabel">Pöytävaraukset</h5>

                </div>
                <div class="modal-body">
                	<div class="row">
                		<div class="col-md-12">
                			<p>Varaa ravintolastamme pöytä 2-6 hengen seurueelle.</p>
                			<h4>Puh. +358 12312312</h4>
                		</div>
                	</div>
                
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Palaa takaisin</button>
                    <!-- button type="button" class="btn btn-primary">Save changes</button-->
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End Button trigger modal -->

						</div>
					</div>
					<div class="hidden-xs hidden-sm hidden-md col-lg-2"></div>
				</div>
			</div>
		</div>
		
			
			<!--a href="#" id="onlineBtn" class="customerBtn">
   				 <p>Tilaa noutopizzasi netistä</p>
   			</a-->
   			<!--a href="#" id="varausBtn" class="customerBtn">
   				 <p>Tee pöytävaraus</p>
   			</a-->
		</div>
	</div>
	<!-- navigointipalkki -->
	<!--  todo: http://www.bootply.com/kD5wiG5udv-->
	<div id="nav-wrap">
		<nav class="navbar navbar-default navbar-static-top shadow" id="nav"
			data-spy="affix">
			<!-- todo1: korjaa-->

			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button aria-expanded="false" class="navbar-toggle collapsed"
					data-target="#bs-example-navbar-collapse-1" data-toggle="collapse"
					type="button">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand visible-xs" href="#">Fiori e Castello</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<!--li class="active"><a href="#">LINKKI</a></li><span class="sr-only">(aktiivinen)</span-->
					<!-- aktiivinen linkki+screenreader class-->
					<li><a class="page-scroll" data-scroll-nav="0" href="#info">Tarinamme</a></li>
					<li><a class="page-scroll" data-scroll-nav="1" href="#ravintola">Ravintola</a> <!-- kokit,puhtaus,tuoreus&laatu...--></li>
					<li><a class="page-scroll" data-scroll-nav="2" href="#ruoka">Ruoka</a></li>
					<li><a class="page-scroll" data-scroll-nav="3" href="#sijainti">Sijainti</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->

		</nav>
		<!-- START PAGE 1, tietoa meistä -->
	</div>
	<div class="content-wrap content-bg">
		<!--  TODO: korvaa poistetut padding-top-## classit vakiotyyleillä contentwrappiin + TITLE -class pienellä, borders class pois ja integroi se otsikkoon(h2?) -->
		<!--id="tietoa meistä"-->
		<div data-scroll-index="0" class="container-fluid" id="info">
			<!-- JS-scroll -viittaaja -->
			<div class="row">
				<div class="col-md-12">
					<h2 class="subhead">TARINAMME</h2>
					<!-- todo: subhead == otsikon muotoilu -->
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<h3>FIORI e CASTELLO - LOREM IPSUM</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="col-md-2 hidden-xs"></div>
					<!-- todo: testaa tyhjän col:n hidden toimivuus -->
					<div class="col-md-4">
						<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
							Sed posuere interdum sem. Quisque ligula eros ullamcorper quis,
							lacinia quis facilisis sed sapien. Mauris varius diam vitae arcu.
							Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</p>
					</div>
					<div class="col-md-4">
						<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
							Sed posuere interdum sem. Quisque ligula eros ullamcorper quis,
							lacinia quis facilisis sed sapien. Mauris varius diam vitae arcu.</p>
					</div>
					<div class="col-md-2 hidden-xs"></div>
					<!-- todo: testaa tyhjän col:n hidden toimivuus -->
				</div>
			</div>
		</div>
	</div>
	<!-- END PAGE 1 -->
	<!-- DIVIDER BACKGROUND 1: BASIL -->
	<section class="bg-1" id="basil"></section>
	<!-- END DIVIDER BACKGROUND 1: BASIL -->
	
	<!-- START PAGE 2, ravintola info -->
	<div class="content-wrap content-bg">
		<div data-scroll-index="1" class="container-fluid" id="ravintola">
			<!-- JS-scroll -viittaaja -->
			<div class="row">
				<div class="col-md-12">
					<h2 class="subhead">RAVINTOLA</h2>
					<!-- todo: subhead == otsikon muotoilu -->
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<h3>FIORI e CASTELLO - HÄMEENLINNAN PIZZAMESTARIT</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="col-md-2 hidden-xs"></div>
					<!-- todo: testaa tyhjän col:n hidden toimivuus -->
					<div class="col-md-4">
						<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
							Sed posuere interdum sem. Quisque ligula eros ullamcorper quis,
							lacinia quis facilisis sed sapien. Mauris varius diam vitae arcu.
							Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</p>
					</div>
					<div class="col-md-4">
						<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
							Sed posuere interdum sem. Quisque ligula eros ullamcorper quis,
							lacinia quis facilisis sed sapien. Mauris varius diam vitae arcu.</p>
					</div>
					<div class="col-md-2 hidden-xs"></div>
					<!-- todo: testaa tyhjän col:n hidden toimivuus -->
				</div>
			</div>
		</div>
	</div>
	<!-- END PAGE 2 -->
	
	<!-- DIVIDER BACKGROUND 2: MOZZARELLA -->	
	<section class="bg-2" id="mozzarella"></section>
	<!-- END DIVIDER BACKGROUND 2: MOZZARELLA -->	
	
	<!-- START PAGE 3, ruoka+ruokalista -->
	<div class="content-wrap content-bg">
		<div data-scroll-index="2" class="container" id="ruoka" data-scroll-index="2">
			<!-- JS-scroll -viittaaja -->
			<h2 class="subhead">RUOKA</h2>
			<div class="row">
				<div class="col-md-12">
					<div class="col-md-2 hidden-xs"></div>
					<div class="col-md-8">
						<p>
							Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Sed
							posuere interdum sem. Quisque ligula eros ullamcorper quis,
							lacinia quis facilisis sed sapien. Mauris varius diam vitae arcu.<br>
							<br> Lorem ipsum dolor sit amet, consectetuer adipiscing
							elit.
						</p>
						<form action="TilausController" method="get">
							<button id="onlineBtn" class="customerBtn" type="submit" value="OnlineTilausnäkymä" name="Submit"
							id="frm3_submit"> <p>Tilaa noutopizzasi netistä</p> </button>
						</form>
					</div>
					<div class="col-md-2 hidden-xs"></div>
				</div>
			</div>



<!--  start menu-accordion  -->
		<div id="menuTop" style="height: 63px;"></div>
			<!-- TODO: muut menun osiot kuntoon-->
			<div aria-multiselectable="true" class="panel-group" id="accordion"
				role="tablist">
				<div class="panel panel-default">
					<div class="panel-heading" id="headingOne" role="tab">
						<h4 class="panel-title accordionhead">
							<a class="menuTopBtn" aria-controls="collapseOne" aria-expanded="true"
								data-parent="#accordion" data-toggle="collapse"
								href="#collapseOne" role="button">Pizzat</a>
						</h4>
						
					</div>
					<div aria-labelledby="headingOne"
						class="panel-collapse collapse" id="collapseOne"
						role="tabpanel">
						<div class="panel-body">
							<!--  
                            
                            <form action="ClientController" method="get">
                            
                            <button id="jarjestaHinta" type="submit" name="action" value="jarjestaHinta" onunload="unloadP('UniquePageNameHereScroll')" onload="loadP('UniquePageNameHereScroll')">Hintajärjestykseen</button>
							<input type="hidden" name="index" value="jarjestaHinta"/>
							
							<button id="jarjestaNimi" type="submit" name="action" value="jarjestaNimi">Aakkosjärjestykseen</button>
							<input type="hidden" name="index" value="jarjestaNimi"/>
							
							</form>
						-->
							
						<!-- toimivat napit, poistoon? 
						<form action="ClientController" method="get">
							<button class="orderByBtn" id="jarjestaHinta" type="submit" name="action"
								value="jarjestaHinta">Hintajärjestykseen</button>
							<input type="hidden" name="index" value="jarjestaHinta" />

							<button class="orderByBtn" id="jarjestaNimi" type="submit" name="action"
								value="jarjestaNimi">Aakkosjärjestykseen</button>
							<input type="hidden" name="index" value="jarjestaNimi" />
						</form>-->

						<!-- div id="jarjestabox"> <!-- oma testausbutton, ei toimi vielä -->
								
							<!-- div class="row">
								<div class="col-xs-12">
									<div class="dropdown jarjestabox">
										<form action="ClientController" method="get" class="jarjestabox">
										<button class="btn btn-default dropdown-toggle jarjestabox" type="button"
											id="dropdownMenu1" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="true">
											Hintajärjestykseen <span class="caret"></span>
										</button>
										<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
											<li><a data-value="jarjestaHinta">Hintajärjestykseen</a></li>
											<li><a data-value="jarjestaNimi">Aakkosjärjestykseen</a></li>
										</ul>
										</form>
									</div>
								</div>
							</div-->		
									<!--  div class="dropdown">
    									<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Järjestys:
  										<span class="caret"></span></button>
   						 				<ul class="dropdown-menu">
    										<li><a href="#" data-value="action">Hintajärjestykseen</a></li>
											<li><a href="#" data-value="another action">Aakkosjärjestykseen</a></li>
    									</ul>
  									</div-->

<!--  desktopMenu -tulostus -->			
<div id="desktopMenu" class="hidden">							</div-->
	<div class="row">

<!--  TODO TODO: JAVAN SISÄLLÄ PUUTTUVIA/YLIMÄÄRÄISIÄ DIVEJÄ/DIVSULKUJA JOTKA RIKKOO SIVUN ACCORDIONIN JA DIVIDERIN(tomato) -->
							<%
								ArrayList<Pizza> pizzat = (ArrayList<Pizza>)request.getAttribute("pizzat");
							Locale locale  = new Locale("fi", "FI");
							String pattern = "##0.00";
							DecimalFormat desi = (DecimalFormat) NumberFormat.getNumberInstance(locale);
							desi.applyPattern(pattern);

	

																	                			
																	                      
							out.println("<div class=\"col-xs-6\">");
                      		 
                      		 for(int i=0; i < pizzat.size(); i+=2) {
               				out.print("<form action=\"Controller\" method=\"get\">");
               				
               				out.println("<div class=\"menuitembox\">");
               				
               				out.println("<tr>");
               				out.println("<td> <p class=\"lead menuitemhead\">" + pizzat.get(i).getNimi().toUpperCase() + " </p></td>");
               				out.println("<td> <p class=\"menufilling\">" + pizzat.get(i).getTaytteet() + " </p></td>");

               				out.println("<td> <p class=\"menuitemprice\">" + desi.format(pizzat.get(i).getHinta()) + "€</p></td>");			

               				out.println("</tr>");

               				out.println("</div>");
               				
           					out.println("<br>");
               				out.print("</form>");
               				out.println("<p class=\"lead dividerFlower\">❀</p>");
               			}
                      		
                      		out.println("</div>");
                      	
                      		
                     
                      		out.println("<div class=\"col-xs-6\">");
               			
               			for(int i=1; i < pizzat.size(); i+=2) {
               				out.print("<form action=\"Controller\" method=\"get\">");
               				out.println("<div class=\"menuitembox\">");
               					out.println("<tr>");
               					out.println("<td> <p class=\"lead menuitemhead\">" + pizzat.get(i).getNimi().toUpperCase() + " </p></td>");
               					out.println("<td> <p class=\"menufilling\">" + pizzat.get(i).getTaytteet() + " </p></td>");

               					out.println("<td> <p class=\"menuitemprice\">" + desi.format(pizzat.get(i).getHinta())+ "€</p></td>");
               					out.println("</tr>");
               				out.println("</div>");
               				
               				out.println("<br>");
               				out.print("</form>");
               				out.println("<p class=\"lead dividerFlower\">❀</p>");
               			}    
               			
               			out.println("</div>");
																	                		
																	                			
%>




	</div>
</div>

<!-- end menu -->


						</div>
					</div>
					
					
					
					
				</div>
				<div class="panel panel-default">
					<div class="panel-heading" id="headingTwo" role="tab">
						<h4 class="panel-title accordionhead">
							<a class="menuTopBtn" aria-controls="collapseTwo" aria-expanded="false"
								class="collapsed" data-parent="#accordion"
								data-toggle="collapse" href="#collapseTwo" role="button">Virvoitusjuomat</a>
						</h4>
					</div>
					<div aria-labelledby="headingTwo" class="panel-collapse collapse"
						id="collapseTwo" role="tabpanel">
						<div class="panel-body">Anim pariatur cliche reprehenderit,
							enim eiusmod high life accusamus terry richardson ad squid. 3
							wolf moon officia aute, non cupidatat skateboard dolor brunch.
							Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon
							tempor, sunt aliqua put a bird on it squid single-origin coffee
							nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica,
							craft beer labore wes anderson cred nesciunt sapiente ea
							proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat
							craft beer farm-to-table, raw denim aesthetic synth nesciunt you
							probably haven't heard of them accusamus labore sustainable VHS.
						</div>
					</div>
				</div>
					<div class="panel panel-default">
						<div class="panel-heading" id="headingThree" role="tab">
							<h4 class="panel-title accordionhead">
								<a class="menuTopBtn" aria-controls="collapseThree" aria-expanded="false"
									class="collapsed" data-parent="#accordion"
									data-toggle="collapse" href="#collapseThree" role="button">Viinit</a>
							</h4>
						</div>
						<div aria-labelledby="headingThree"
							class="panel-collapse collapse" id="collapseThree"
							role="tabpanel">
							<div class="panel-body">Anim pariatur cliche reprehenderit,
								enim eiusmod high life accusamus terry richardson ad squid. 3
								wolf moon officia aute, non cupidatat skateboard dolor brunch.
								Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon
								tempor, sunt aliqua put a bird on it squid single-origin coffee
								nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica,
								craft beer labore wes anderson cred nesciunt sapiente ea
								proident. Ad vegan excepteur butcher vice lomo. Leggings
								occaecat craft beer farm-to-table, raw denim aesthetic synth
								nesciunt you probably haven't heard of them accusamus labore
								sustainable VHS.</div>
						</div>
					</div>
				<div class="panel panel-default">
					<div class="panel-heading" id="headingFour" role="tab">
						<h4 class="panel-title accordionhead">
							<a class="menuTopBtn" aria-controls="collapseFour" aria-expanded="false"
								class="collapsed" data-parent="#accordion"
								data-toggle="collapse" href="#collapseFour" role="button">Jälkiruoat</a>
						</h4>
					</div>
					<div aria-labelledby="headingFour" class="panel-collapse collapse"
						id="collapseFour" role="tabpanel">
						<div class="panel-body">Anim pariatur cliche reprehenderit,
							enim eiusmod high life accusamus terry richardson ad squid. 3
							wolf moon officia aute, non cupidatat skateboard dolor brunch.
							Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon
							tempor, sunt aliqua put a bird on it squid single-origin coffee
							nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica,
							craft beer labore wes anderson cred nesciunt sapiente ea
							proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat
							craft beer farm-to-table, raw denim aesthetic synth nesciunt you
							probably haven't heard of them accusamus labore sustainable VHS.
						</div>
					</div>
				</div>
			</div>
		<!-- end menu-accordion -->


<!-- acc end testing comment (remove) -->	
		</div>
	</div>
	<!-- ENG PAGE 3 -->
		
	<!-- DIVIDER BACKGROUND 3: TOMATO -->	
	<section class="bg-3" id="tomato"></section>
	<!-- END DIVIDER BACKGROUND 3: TOMATO -->
	
	<!-- START PAGE 4, sijainti/location -->
	<div class="content-wrap content-bg lastbg">
		<div data-scroll-index="3" class="container-fluid" id="sijainti">
			<div class="row">
				<div class="col-md-12">
					<h2 class="subhead">YHTEYSTIEDOT</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<h4>Ravintolamme sijaitsee aivan Hämeenlinnan keskustassa</h4>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12">
					<p class="br"> Hämeenlinnankatu 2</p>
							
<!-- google map -->
<script src="https://maps.googleapis.com/maps/api/js?sensor=false" type="text/javascript"></script>
<script src="js/googlemap.js"></script>
<style type="text/css">
/* Set a size for our map container, the Google Map will take up 100% of this container */
#map {
	width: 70%;
	height: 360px;
	margin: 0 auto;
}
</style>
					<div id="map"></div>
	

				</div>
			</div>
		
		</div>

		<!-- FOOTER -->
		
		<!-- TODO: muokkaa uudenlainen, copyright ihan alas, collapsekäyttäytyminen uusiks napeille(md vs xs)-->
		<div id="footer">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-2"></div>
						<div class="col-md-4">
							<h4 class="underline">YHTEYSTIEDOT</h4>
							<div class="inner">
								<h4>KÄYNTIOSOITE:</h4>
								<p class="br"> Hämeenlinnankatu 2</p>
								<h4>PUHELIN:</h4>
								<p class="br">+358 12312312</p>
								<h4>SÄHKÖPOSTI:</h4>
								<p class="br">info@fioriecastello.fi</p>
							</div>
						</div>
						<div class="col-md-4">
							<h4 class="underline"> AUKIOLOAJAT </h4>
							<div class="inner">
								<h4>MA-PE:</h4>
								<p class="br">9-23</p>
								<h4>LAUANTAI:</h4>
								<p class="br">11-23</p>
								<h4>SUNNUNTAI:</h4>
								<p class="br">11-21</p>
							</div>
						</div>
						<div class="col-md-2"></div>
						
					</div>
				</div>
			</div>
			
			<div class="footerBottom container">	
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-4>">
							<h4 class="underline">SEURAA MEITÄ</h4>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 inner">
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
			
			
			
			
	</div>
	<!-- END PAGE 4 -->
	
	<ul class="nav pull-right scroll-top hidden">
  		<li><a href="#" title="Takaisin alkuun"><i class="glyphicon glyphicon-chevron-up"></i></a></li>
	</ul>
	
	<!-- SCRIPT INCLUDE -->
	<script src="js/jquery-2.1.4.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scrollit.min.js"></script>
	<script src="js/jquery.easing.min.js"></script>
	<script src="js/scrolling-nav.js"></script>
	<!-- END SCRIPT INCLUDE -->
	
	
	<script>

    /* affix the navbar after scroll below header
$('#nav').affix({
      offset: {
        top: $('header').height()-$('#nav').height()
      }
});	
 */
 /*hinta/aakkosjärjestysnappi
 $(".dropdown-menu li a").click(function(){
	  $(this).parents(".dropdown").find('.btn').html($(this).text() + ' <span class="caret"></span>');
	  $(this).parents(".dropdown").find('.btn').val($(this).data('value'));
	});
 */
 /*accordion ruokalista-kohdistus*/ 
 $(".menuTopBtn").click(function() {
     $('html, body').animate({
         scrollTop: $("#MenuTop").offset().top
     }, 2000);
 });
  
  
 /*navbar script /w width detect */
 jQuery(document).ready(function(){

		var width2 = jQuery(window).width();

		if(width2 > 768)
			
			$(function(){
			    $('#nav-wrap').height($(".navbar").height());

			    $('.navbar').affix({
			        offset: { top: $('.navbar').offset().top }
			    });
			});
	});
 
 
/*navbar script
$(function(){
    $('#nav-wrap').height($(".navbar").height());

    $('.navbar').affix({
        offset: { top: $('.navbar').offset().top }
    });
});
*/

/*scroll to top*/
$(document).scroll(function () {
    var y = $(this).scrollTop();
    if (y > 60) {
    	$('.scroll-top').removeClass( "hidden" );
     	$('.scroll-top').addClass( "visible" );
    } else {
    	$('.scroll-top').removeClass( "visible" );
        $('.scroll-top').addClass( "hidden" );
    }
});

$('.scroll-top').click(function(){
    $("html, body").animate({ scrollTop: 0 }, 800);
    return false;
});


 
/**
 * Author: Heather Corey
 * jQuery Simple Parallax Plugin
 *
 */
 
(function($) {
 
    $.fn.parallax = function(options) {
 
        var windowHeight = $(window).height();
 
        // Establish default settings
        var settings = $.extend({
            speed        : 0.15
        }, options);
 
        // Iterate over each object in collection
        return this.each( function() {
 
        	// Save a reference to the element
        	var $this = $(this);
 
        	// Set up Scroll Handler
        	$(document).scroll(function(){
 
    		        var scrollTop = $(window).scrollTop();
            	        var offset = $this.offset().top;
            	        var height = $this.outerHeight();
 
    		// Check if above or below viewport
			if (offset + height <= scrollTop || offset >= scrollTop + windowHeight) {
				return;
			}
 
			var yBgPosition = Math.round((offset - scrollTop) * settings.speed);
 
                 // Apply the Y Background Position to Set the Parallax Effect
    			$this.css('background-position', 'center ' + yBgPosition + 'px');
                
        	});
        });
    }
}(jQuery));

$('.bg-1,.bg-3').parallax({
	speed :	0.25
});	
	
$('.bg-2').parallax({
	speed :	0.35
});		
	
	
/* detect mobile/desktop resolution & switch menutypes accordingly */	
jQuery(document).ready(function(){

	var width = jQuery(window).width();

	if(width < 480)
	{
		jQuery('#desktopMenu').removeClass('visible');
		jQuery('#desktopMenu').addClass('hidden');
		jQuery('#mobileMenu').removeClass('hidden');
		jQuery('#mobileMenu').addClass('visible');
	}
	else
	{
		jQuery('#desktopMenu').removeClass('hidden');
		jQuery('#desktopMenu').addClass('visible');
		jQuery('#mobileMenu').removeClass('visible');
		jQuery('#mobileMenu').addClass('hidden');
	}
});



/* highlight the top nav as scrolling occurs 
$('body').scrollspy({ target: '#nav' })
*/
/* smooth scrolling for scroll to top
$('.scroll-top').click(function(){
  $('body,html').animate({scrollTop:0},1000);
})
 */
 
/* smooth scrolling for nav sections 
$('#nav .navbar-nav li>a').click(function(){
  var link = $(this).attr('href');
  var posi = $(link).offset().top;
  $('body,html').animate({scrollTop:posi},700);
});
*/
 

  /*   
            $(function(){
    $('#nav-wrap').height($(".navbar").height());

    $('.navbar').affix({
        offset: { 
		top:  $('.navbar').offset().top 
		}
    });
    });
*/
/*
    $(function(){
    $.scrollIt();
    });
	*/

	
/*<!-- bs-kuvacarousel -->
            <div class="carousel slide" data-ride="carousel" id="myCarousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li class="active" data-slide-to="0" data-target=
                    "#myCarousel"></li>
                    <li data-slide-to="1" data-target="#myCarousel"></li>
                    <li data-slide-to="2" data-target="#myCarousel"></li>
                    <li data-slide-to="3" data-target="#myCarousel"></li>
                </ol><!-- Wrapper for slides --><!-- TODO: poista(?) html stylet -->
                <div class="carousel-inner" role="listbox"><!--TODO: muuta style="height: 100%;"-->
                    <div class="item active"><img alt="PIZZA" class="slide"
                    src="img/1x.jpg" style="height: 55em;"></div>
                    <div class="item"><img alt="PIZZA" class="slide" src=
                    "img/2x.jpg" style="height: 55em;"></div>
                    <div class="item"><img alt="PIZZA" class="slide" src=
                    "img/3x.jpg" style="height: 55em;"></div>
                    <div class="item"><img alt="PIZZA" class="slide" src=
                    "img/4x.jpg" style="height: 55em;"></div>
                </div><!-- Left and right controls -->
                <a class="left carousel-control" data-slide="prev" href=
                "#myCarousel" role="button"><span aria-hidden="true" class=
                "glyphicon glyphicon-chevron-left"></span> <span class=
                "sr-only">Edellinen</span></a> <a class=
                "right carousel-control" data-slide="next" href="#myCarousel"
                role="button"><span aria-hidden="true" class=
                "glyphicon glyphicon-chevron-right"></span> <span class=
                "sr-only">Seuraava</span></a>
            </div>*/	
	
	
	
	
    </script>
</body>
</html>