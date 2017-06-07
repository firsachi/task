<%-- 
    Document   : newtask
    Created on : May 25, 2016, 4:58:37 PM
    Author     : firsov
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns:tiles="http://www.thymeleaf.org">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
		<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
    </head>
    <body>
		<aside>
			<header>
				<!-- <img alt="logo" src="<c:url value="/resources/img/logo.png" />"> -->
				Київреклама ${param.error}
			</header>
			<c:if test="${error != null}">
				<div class="error">Невірний лoгін або пароль</div>
			</c:if>
                <!-- j_security_check -->
			<form action="/login" method="post">
				login 
				<input type="text" name="username" placeholder="Введіть логін користувча" required> 
				Password 
				<input type="password" name="password" placeholder="Введіть пароль користувча" required> 
				<input id="button" type="submit" value="Увійти">
		</form>
		<footer>
			<a href="/task/">Повернутися назад</a>
		</footer>
	</aside>
	
</body>
</html>
