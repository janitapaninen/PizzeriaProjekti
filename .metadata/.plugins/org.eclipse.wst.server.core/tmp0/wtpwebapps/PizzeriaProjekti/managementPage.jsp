<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fi.pizzeriaprojekti.admin.bean.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta name="Takarivi" content="Takarivi">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap -->
	   <script src="js/jquery-2.1.4.min.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
	<script src="js/bootstrap.min.js"></script>
  <link href="css/styles.css"   rel="stylesheet"   type="text/css">
<script src="js/admin.js"></script>
<script>
<!-- 1-osa. T�ll� functiolla sivu s�ilytt�� p�ivityksen j�lkeen sijainnin -->
function readCookie(name){
return(document.cookie.match('(^|; )'+name+'=([^;]*)')||0)[2]
}
</script>
  
<title>Pizzat</title>
</head>
<link rel="stylesheet" type="text/css" href="css/styles.css" />


<!-- 2. osa. T�m� on jatke sivun sijainnin l�yt�miseen p�ivitt�misen j�lkeen. -->
<body onScroll="document.cookie='ypos=' + window.pageYOffset" onLoad="window.scrollTo(0,readCookie('ypos'))">
 <%
//allow access only if session exists
if(session.getAttribute("user") == null){
    response.sendRedirect("login.jsp");
}
String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
    if(cookie.getName().equals("user")) userName = cookie.getValue();
}
}

if(request.getParameter("added") != null && request.getParameter("added").equals("true")) {
	out.println("Lis�ys onnistui");		
} else if (request.getParameter("added") != null && request.getParameter("added").equals("false")){
	%>
	<!-- Alert, jos k�ytt�j� yritt�� lis�t� pizzan ilman t�ytteit� -->
	<script>
	alert("V\u00E4hint\u00E4\u00E4n yksi t\u00E4yte!")
	</script>
	<%
}
%>

<ul class="nav navbar-default nav-tabs navbar-fixed-top">

 <!----------------------------Nav bar--------------------------------> 

  <li class="active">  
    <a href="http://proto293:8080/PizzeriaProjekti/Controller">Admin</a>
  </li>
  <li><a href="http://proto293:8080/PizzeriaProjekti/kokkiController">Tilausn�kym�</a> </li> 
  <li><a href="http://proto293:8080/PizzeriaProjekti/ClientController" target="_blank">Asiakasn�kym�</a> </li>
  <li><a href="http://proto293:8080/PizzeriaProjekti/TilausController" target="_blank">OnlineTilausn�kym�</a> </li>  
  
  <li><div class="kokki">
		<form action="LogoutServlet" method="post">
		<input type="submit" value="Kirjaudu ulos" id="logout">
		</form>
		
	</div> 
	</li>
</ul>
 <!----------------------------End Nav bar--------------------------------> 	
 
  <!----------------------------Pizzan lis�ys--------------------------------> 
	<h1>Pizzojen hallinnointi</h1>
<div id="pizza_lisays" class="col-md-8">	
<!-- Pizzan lis�ys lomake -->
	<form action="Controller" method="post">

		<b>Lis�� Pizzan Tiedot</b>
		<br><br>

		<b>Pizzan nimi:</b> <br> 
		<input type="text" name="pizzan_nimi" required placeholder="Nimi"><br><br>
		<b>Pizzan hinta:</b> <br> 
		<input type="number"name="pizzan_hinta" step="0.01" max="100"min="6" required placeholder="Hinta"> <br> <br> <br> <br>
		<b>Pizzan t�ytteet:</b> <br>
		
		<div class="col-md-12">
                
                <div class="col-md-3">
                    <div class="checkbox">
                        <label><input type="checkbox" name="tayte" value="Ananas ">Ananas</label>
                    </div>
                    <div class="checkbox">
                        <label><input type="checkbox" name="tayte" value="Aurajuusto ">Aurajuusto</label>
                    </div>
                    <div class="checkbox">
                        <label><input type="checkbox" name="tayte" value="Avokado ">Avokado</label>
                    </div>
                    <div class="checkbox">
                        <label><input type="checkbox" name="tayte" value="Fetajuusto ">FetaJuusto</label>
                    </div>
                    <div class="checkbox">
                        <label><input type="checkbox" name="tayte" value="Jalapeno ">Jalape�o</label>
                    </div>
					 <div class="checkbox">
                        <label><input type="checkbox" name="tayte" value="Herkkusieni ">Herkkusieni</label>
                    </div>
					 <div class="checkbox">
                        <label><input type="checkbox" name="tayte" value="Jauheliha ">Jauheliha</label>
                    </div>
					 <div class="checkbox">
                        <label><input type="checkbox" name="tayte" value="Kananmuna ">Kananmuna</label>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="checkbox">
                        <label><input type="checkbox" name="tayte" value="Kanttarelli ">Kanttarelli</label>
                    </div>
                    <div class="checkbox">
                        <label><input type="checkbox" name="tayte" value="Katkarapu ">Katkarapu</label>
                    </div>
                    <div class="checkbox">
                        <label><input type="checkbox" name="tayte" value="Kebab ">Kebab</label>
                    </div>
                    <div class="checkbox">
                        <label><input type="checkbox" name="tayte" value="Kinkku ">Kinkku</label>
                    </div>
                    <div class="checkbox">
                        <label><input type="checkbox" name="tayte" value="Kirsikkatomaatti ">Kirsikkatomaatti</label>
                    </div>
					<div class="checkbox">
                        <label><input type="checkbox" name="tayte" value="Tuplajuusto ">Tuplajuusto</label>
                    </div>
                    <div class="checkbox">
                        <label><input type="checkbox" name="tayte" value="Oliivi ">Oliivi</label>
                    </div>
                    <div class="checkbox">
                        <label><input type="checkbox" name="tayte" value="Paprika ">Paprika</label>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="checkbox">
                        <label><input type="checkbox" name="tayte" value="Kana ">Kana</label>
                    </div>
                    <div class="checkbox">
                        <label><input type="checkbox" name="tayte" value="Parmesan ">Parmesan</label>
                    </div>
                    <div class="checkbox">
                        <label><input type="checkbox" name="tayte" value="Pekoni ">Pekoni</label>
                    </div>
                    <div class="checkbox">
                        <label><input type="checkbox" name="tayte" value="Pepperoni ">Pepperoni</label>
                    </div>
                    <div class="checkbox">
                        <label><input type="checkbox" name="tayte" value="Punasipuli ">Punasipuli</label>
                    </div>
					<div class="checkbox">
                        <label><input type="checkbox" name="tayte" value="Rucola ">Rucola</label>
                    </div>
                    <div class="checkbox">
                        <label><input type="checkbox" name="tayte" value="Salami ">Salami</label>
                    </div>
                    <div class="checkbox">
                        <label><input type="checkbox" name="tayte" value="Tonnikala ">Tonnikala</label>
                    </div>
                </div>
            </div> <!-- col12 -->
			
		<br>
		<br>
		<br>
		<br>
		
			<button id="lisaa" type="submit" name="action" value="lisaa">Lis�� Pizza</button>
		<input type="hidden" name="managementPage" value="lisaa"/>
		
												
		<br><br><br><br><br>
	
	
	
	</form>
	
	<%
	%>
	
	
</div> 
<!---------------------------End pizza_lisays -------------------------------------->




	<!-- Pizzalistan tulostus sek� muokkaus ja poisto buttonit -->
	
	
	
<div class="col-md-12">

	<h1>Pizzalista</h1>
	
	<form action="Controller" method="get">
                            
            <button id="jarjestaHinta" type="submit" name="action" value="jarjestaHinta" onunload="unloadP('UniquePageNameHereScroll')" onload="loadP('UniquePageNameHereScroll')">Hintaj�rjestykseen</button>
			<input type="hidden" name="index" value="jarjestaHinta"/>
							
			<button id="jarjestaNimi" type="submit" name="action" value="jarjestaNimi">Aakkosj�rjestykseen</button>
			<input type="hidden" name="index" value="jarjestaNimi"/>
							
	</form>

	<table>
		
		<caption>N�kyvyys 1 = esill�, n�kyvyys 2 = piilossa.</caption>
		<thead>
			<tr>
				<td>ID</td>
				<td>NIMI</td>
				<td>HINTA</td>
				<td>T�YTTEET</td>
				<td>N�KYVYYS</td>
				<td>HALLINNOI</td>
			</tr>
		</thead>
		<tbody>
			
		
		
		
		<%
			// Pizzojen listaus
			DecimalFormat desi = new DecimalFormat("0.00");
		
		@SuppressWarnings("unchecked")
		ArrayList<Pizza> pizzat = (ArrayList<Pizza>)request.getAttribute("pizzat");
		for(int i=0; i < pizzat.size(); i++) {
			out.print("<form action=\"Controller\" method=\"get\">");
			out.println("<tr>");
			out.println("<td>" + pizzat.get(i).getId() + "</td>");
			out.println("<td>" + pizzat.get(i).getNimi() + "</td>");
			out.println("<td><input type=\"decimal\" size=\"10\" name=\"uushinta\" step=\"0.01\" max=\"100\"min=\"6\" value= " + desi.format(pizzat.get(i).getHinta()) +"></td>");
			out.println("<td>" + pizzat.get(i).getTaytteet() + "</td>");
			
			out.println("<td><input type=\"number\" size=\"10\" name=\"nakyvyys\" max=\"2\"min=\"1\" value= " + pizzat.get(i).getNakyvyys() +"></td>");
			out.println("<input type=\"hidden\" name=\"action\" value=\"muokkaa\"/>");
			out.println("<input type=\"hidden\" name=\"pizzanumero\" value=\""+pizzat.get(i).getId()+"\"/>");
			
			out.println("<td><button class=\"nappi\" type=\"submit\">Muokkaa</button></td>");		
			out.println("</tr>");
			out.print("</form>");
		}
			
			%>

			<c:if test="${not empty param.added}">Pizzan lis�sys onnistui! </c:if>
		</tbody>
	</table>
</div> <!-- col12 tulostus -->

 <!----------------------------End Pizzojen tulostus--------------------------------> 
	<!-- T�ll� funktiolla pakotetaan max 5 t�ytett� alerttia -->
	<script>$('input[type=checkbox]').change(function(e){
		   if ($('input[type=checkbox]:checked').length > 5) {
		        $(this).prop('checked', false)
		        alert("Max. 5 t\u00E4ytett\u00E4."); // \u00E4 �-koodi
		   }
		})
		
		$('input[type=text]').change(function(e){
			if ($('input[type=text]:')){
				
			}

		}) 
		
	
		</script>


</body>
</html>