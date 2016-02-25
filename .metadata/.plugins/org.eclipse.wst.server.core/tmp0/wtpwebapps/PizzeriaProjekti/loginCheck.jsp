<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/logintyyli.css" rel="stylesheet">
<title>Login Success Page</title>
</head>
<body>
<%
// Tämä sivu näytetään, jos kirjautumis tiedot ovat oikeat, tästä voi jatkaa palveluun
//allow access only if session exists
String user = null;
if(session.getAttribute("user") == null){
    response.sendRedirect("login.jsp");
}else user = (String) session.getAttribute("user");
String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
    if(cookie.getName().equals("user")) userName = cookie.getValue();
    if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}
}
%>
<h2>Hello <%=user %></h2>
<br>
<br>
<form action="Controller" method="get">
<button class="btn btn-success btn-lg gradient" type="submit" value="Proceed">Proceed</button>
</form>
<form action="LogoutServlet" method="post">
<button class="btn btn-primary btn-lg gradient" type="submit" value="Logout" >Logout</button>
</form>
</body>
</html>


