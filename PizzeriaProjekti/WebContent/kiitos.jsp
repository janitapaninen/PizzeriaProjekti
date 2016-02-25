<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="fi.pizzeriaprojekti.admin.bean.*"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
 <meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title>Fiori e Castello - Kiitos</title>
 <link href="css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
  <body>
<div class="jumbotron">
  <h1>Kiitos tilauksesta!</h1>
  <p>Tilauksesi on vastaanotettu ja sen käsittely aloitetaan mahdollisimman pian.<br>
  Tilauksesi käsittelyyn menee 20-40 minuuttia kiirevarauksella, jonka jälkeen pizzasi ovat noudettavissa.<br>
  Tervetuloa ravintolaamme!</p>
				<form action="ClientController" method="get">
			<input type="submit" value="Takaisin kotisivuille" name="Submit"
				id="frm2_submit" />
		</form>
</div>
<script src="js/jquery-2.1.4.min.js"></script>
	
	<script src="js/bootstrap.min.js"></script>
	
	<script src="js/index.js" type="text/javascript"></script>
  </body>
</html>