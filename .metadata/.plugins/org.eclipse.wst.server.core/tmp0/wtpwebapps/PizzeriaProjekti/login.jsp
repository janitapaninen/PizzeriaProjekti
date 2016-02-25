<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC>
<html>
    <head>
   	 <link href="css/login.css" media="screen" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
    </head>
    <body>  
    <!-- Kirjautumis tieto formi, joka ohjaa login controlleriin -->        
<form action="loginController" method="post">
    <div class="col-xs-12">
                <h1>Login</h1>        
                </div>
    <fieldset>
        <label for="username">Username: 
        </label>
        <input type="text" name="username" />
    </fieldset>
    
    <fieldset>
        <label for="password">Password: 
        </label>
        <input type="password" name="password" />
    </fieldset>
    
    <fieldset style="text-align: right; margin-bottom: 7px;">
        <input type="submit" value="Login" />
    </fieldset>
</form>






            




