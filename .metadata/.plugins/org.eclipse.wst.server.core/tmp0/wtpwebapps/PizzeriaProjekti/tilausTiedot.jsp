<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="fi.pizzeriaprojekti.admin.bean.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Fiori e Castello - Tilaus</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/tilausTiedotTyyli.css" rel="stylesheet">
</head>
<body>

	<!---------------------------------------tilauslomake begins here-------------------------------->
	<%
	Locale locale  = new Locale("fi", "FI");
	String pattern = "##0.00";
	DecimalFormat desi = (DecimalFormat) NumberFormat.getNumberInstance(locale);
	desi.applyPattern(pattern);
	
   if(session != null && session.getAttribute("kori")!=null ) {
   	ArrayList<ostoskoriPizza> ostoskoriPizzat = (ArrayList<ostoskoriPizza>)session.getAttribute("kori");
  
  }
   	%>

	<div class="container">
		<div class="row">
			<div class="col-sm-12 col-md-12">


				<h3>Loppusumma:</h3>
				<h3>
					<strong>
						<% 
						String strmaksyht = request.getParameter("maksyht");
						double maksyht = Double.parseDouble(strmaksyht);
						out.print(desi.format(maksyht)); %>
						&#128;
					</strong>
				</h3>
				<p>Annathan tietosi tilausta varten. Tilaus
					noudetaan ravintolasta ja maksetaan kassalla. Pakolliset tiedot merkitty *</p>
				<!--   <form action="ostoskoriController" method="post" role="form">
    <div class="form-group">
      <label for="etunimi">Etunimi:</label>
      <input type="text" class="form-control" value="etunimi">
    </div>
    <div class="form-group">
      <label for="sukunimi">Sukunimi:</label>
      <input type="text" class="form-control" value="sukunimi">
    </div>
	    <div class="form-group">
      <label for="puhnumero">Puhelinnumero:</label>
      <input type="text" class="form-control" value="puhnumero">
    </div>
	    <div class="form-group">
      <label for="kommentti">Muuta huomioitavaa:</label>
      <input type="text" class="form-control" value="kommentti">
    </div>
	 <a class="btn btn-default" href="kassaNakyma.jsp">
                           <span class="glyphicon glyphicon-menu-left"></span> Takaisin
                        </a>
     <input type="hidden" name="action" value="laheta"/>
    <a type="submit" id="laheta" class="btn btn-success" href="kiitos.jsp">Lähetä</a>
  </form>-->

				<form action="ostoskoriController" method="post" class="tilaajaLomake">
				<ul>
					<li><label id="etunimi">Etunimi*:</label> <input type="text" name="etunimi" pattern="{1,19}" placeholder="Maija" required /> </li>
					<li><label id="sukunimi">Sukunimi*: </label> <input type="text" name="sukunimi" pattern="{1,19}" placeholder="Malinen" required /> </li>
					<li><label id="puh">Puh.nro*: </label><input type="text" name="puhnumero" pattern="^((90[0-9]{3})?0|\+358\s?)(?!(100|20(0|2(0|[2-3])|9[8-9])|300|600|700|708|75(00[0-3]|(1|2)\d{2}|30[0-2]|32[0-2]|75[0-2]|98[0-2])))(4|50|10[1-9]|20(1|2(1|[4-9])|[3-9])|29|30[1-9]|71|73|75(00[3-9]|30[3-9]|32[3-9]|53[3-9]|83[3-9])|2|3|5|6|8|9|1[3-9])\s?(\d\s?){4,19}\d$" placeholder="+3581234567" required /></li>
					<li><label id="kommentti">Kommentti: </label><textarea class="kommentti" type="text" placeholder="Muuta huomoutettavaa. Esim. Ruoka-aineallergiat, gluteenittomuus" name="kommentti"></textarea></li>
					<li><input type="hidden" name="action" value="laheta" />
					<input type="hidden" name="maksyht" value="<% out.print(maksyht);%>">
					<button type="submit" href="kiitos.jsp">Tilaa</button>
					</li>
					
				</ul>
    

				</form>
				
				  
				<button type="submit" href="kassaNakyma.jsp"><a href="kassaNakyma.jsp">Takaisin</a></button>
				
				<!--<form action="TilausController" method="get">
									<input type="submit" value="Takaisin" name="Submit"
										id="frm3_submit" /> 
								</form> -->
			</div>
		</div>
	</div>
	<!----------------------------tilauslomake ends here ------------------------------------------->
	<script src="js/jquery-2.1.4.min.js"></script>

	<script src="js/bootstrap.min.js"></script>

	<script src="js/index.js" type="text/javascript"></script>
</body>
</html>