<%-- 
    Document   : newtask
    Created on : May 25, 2016, 4:58:37 PM
    Author     : firsov
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:tiles="http://www.thymeleaf.org">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><spring:message code="label.login.title"/></title>
		<link href="<c:url value="resources/css/login.css" />" rel="stylesheet">
	</head>
	<body>
		<aside>
			
			<form:form action="/task/login" modelAttribute="user"  method="POST" enctype="utf8">
				
				<h4><spring:message code="label.login.titleLogin"/></h4>
				
				<c:if test="${error != null}">
					<div class="error"><strong>Error</strong> - <spring:message code="label.login.error"/></div>
				</c:if>	
				
				<spring:message code="label.login.username" var="username"/>
				<form:label path="username">${ username }</form:label>
				<form:input path="username" placeholder="${ username }"/>
				
				<spring:message code="label.login.password" var="password"/>
				<form:label path="password">${ password }</form:label>
				<form:password path="password" placeholder="${ password }"/>
				
				<spring:message code="label.login.submitLogin" var="submit"/>
				<form:button>${ submit }</form:button>

			</form:form>
		</aside>
	</body>
</html>
