<%-- 
    Document   : form-company
    Created on : Aug 21, 2016, 10:31:57 PM
    Author     : firsachi
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
    	<spring:message code="label.company.new.title" var="companyTitle"/>
        <title>${ companyTitle }</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="../jspf/map-main-css.jspf"%>   
    </head>
    <body>
    	<div class="box-form">
    		<div class="page-header">
            	<h2>${ companyTitle }</h2>
        	</div>
        	<form:form class="form-horisontal" modelAttribute="enterprise" method="POST" action="save" acceptCharset="UTF-8">
            	<%@include file="../jspf/main-company.jsp" %>
				<%@include file="../jspf/button-form.jspf" %>
        	</form:form>
    	</div>
    </body>
</html>