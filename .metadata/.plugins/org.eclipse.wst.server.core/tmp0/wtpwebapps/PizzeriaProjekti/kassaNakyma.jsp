<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="fi.pizzeriaprojekti.admin.bean.*"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Fiori e Castello - Kassa</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<style>
#seuraava {
	background: lightgreen;
	font-size: 1.2em;
	border: 1px solid grey;
	padding: 8px 15px;
	width: 115px;
}

#frm3_submit {/*takaisin nappi*/
	background: #E74C3C;
	font-size: 1.2em;
	border: 1px solid grey;
	padding: 8px 15px;
	width: 115px;
	color: #fff;
}
</style>
</head>
<body>


	<!---------------------------------------tilausyhteenveto begins here -------------------------------->
	<%
	Locale locale  = new Locale("fi", "FI");
	String pattern = "##0.00";
	DecimalFormat desi = (DecimalFormat) NumberFormat.getNumberInstance(locale);
	desi.applyPattern(pattern);
	%>
	<div class="container">
		<div class="row">
			<div class="col-sm-12 col-md-12">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Tuote</th>
							<th>Lukumäärä</th>
							<th class="text-center">Hinta/kpl</th>
							<th class="text-center">Summa</th>

							<th> </th>
						</tr>
					</thead>
					<tbody>
					
					

						<%
						double maksyht = 0;
							if(session != null && session.getAttribute("kori")!=null ) {
							            	ArrayList<ostoskoriPizza> ostoskoriPizzat = (ArrayList<ostoskoriPizza>)session.getAttribute("kori");
							            	
						                
						                for (int i = 0; i< ostoskoriPizzat.size(); i++){
						%>

						<tr>
							<td class="col-sm-8 col-md-6">
								<div class="media">
									<a class="thumbnail pull-left" href="#"> <img
										class="media-object" src="img/minipizza.png"></a>
									<div class="media-body">
										<h4 class="media-heading">
											<a href="#">
												<%
													out.print(ostoskoriPizzat.get(i).getNimi());
												%>
											</a>
										</h4>
									</div>
								</div>
							</td>
							
								
								<td class="col-sm-1 col-md-1 text-center"><strong><%out.print(ostoskoriPizzat.get(i).getLkm()); %></strong></td>
								
								<td class="col-sm-1 col-md-1 text-center"><strong><%out.print(desi.format(ostoskoriPizzat.get(i).getHinta()));%> €</strong></td>
								 
								<% double summa = ostoskoriPizzat.get(i).getLkm() * ostoskoriPizzat.get(i).getHinta(); %>
								<td class="col-sm-1 col-md-1 text-center"><strong><%out.print(desi.format(summa));%> €</strong>
									
						
						
									
									
							</strong></td>
							<td class="col-sm-1 col-md-1">

								<form action="ostoskoriController" method="post">

									<input type="hidden" class="btn btn-xs btn-danger pull-right"
										name="action2" value="poistakorista" /> <input type="hidden"
										name="pizzanumero"
										value="<%out.print(ostoskoriPizzat.get(i).getId());%>" />
									<button class="btn btn-xs btn-danger pull-right" type="submit">
										x
										</button>
										
									
								</form>
						</tr>

						<%
						maksyht = maksyht + summa;
						
							}
						%>

							<%
								}
							%>




						<tr>
							<td><h1>Tarkista tuotteet:</h1>
							<p>Poista tuotteita painamalla punaista ruksia tai palaa takaisin lisäämään puuttuvat tuotteet.</p>
							<p>Kun olet tyytyväinen tilauksen sisältöön, niin jatka tilausta painamalla "Seuraava". </p>
							</td>
							<td> </td>
							<td> </td>
							<td>
							<td>Yhteensä:
							
							<form action="ostoskoriController" method="get">

					<b> <% out.print(desi.format(maksyht)); %>€</b>
					<input type="hidden" name="action" value="jatka" />
					<input type="hidden" name="maksyht" value="<% out.print(maksyht);%>">
					<button type="submit" id="seuraava">Seuraava</button>

				</form>
				<form action="TilausController" method="get">
									<input type="submit" value="Takaisin" name="Submit"
										id="frm3_submit" /> 
								</form> 
							
						</tr>
					</tbody>
				</table>
			</div>
		</div>

	</div>
	<!----------------------------tilausyhteenveto ends here ------------------------------------------->
	<script src="js/jquery-2.1.4.min.js"></script>

	<script src="js/bootstrap.min.js"></script>

	<script src="js/index.js" type="text/javascript"></script>

</body>

</html>