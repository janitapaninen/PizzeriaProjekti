<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
		// Killing session
        session.removeAttribute("username");
        session.removeAttribute("password");
        session.invalidate();
        %>
        <h1>Logout was done successfully.</h1>
        
    </body>
</html>



