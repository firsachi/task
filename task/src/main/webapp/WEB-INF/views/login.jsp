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

<link href="<c:url value="/resources/css/foundation.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/form-login.css" />"
	rel="stylesheet">
</head>
<body>
	<div style="display: flex; justify-content: center; align-content: center; padding-top: 15%;">
	
		<div class="grid-x grid-margin-x">
		
			
			<form:form action="/task/login" modelAttribute="user" cssClass="log-in-form" method="POST" enctype="utf8">
				<h4 class="text-center">
					<spring:message code="label.login.titleLogin"/>
				</h4>
				<c:if test = "${ error != null}">
					<div data-closable
						class="callout alert-callout-border alert primary">
						<strong>Error</strong> - <spring:message code="label.login.error"/>
						<button class="close-button" aria-label="Dismiss alert"
							type="button" data-close>
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
      			</c:if>
      			
				<form:label path="username">
					<spring:message code="label.login.username" var="username"/>
					${ username }
					<form:input path="username" placeholder="${ username }"/>
				</form:label>
				<form:label path="password">
					<spring:message code="label.login.password" var="password"/>
					${ password }
					<form:password path="password" placeholder="${ password }"/>
				</form:label>
				<p>	
					<spring:message code="label.login.submitLogin" var="submit"/>
					<input class="button expanded" type="submit" value="${ submit }"> 	
				</p>
			</form:form>
		</div>
	</div>
</body>
</html>
