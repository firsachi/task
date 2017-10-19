<%-- 
    Document   : form-employee
    Created on : Aug 19, 2016, 10:35:16 AM
    Author     : firsov
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><spring:message code="label.foma.title.edit.employee"/></title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="../jspf/map-main-css.jspf"%>
    </head>
    <body>
    	<div class="box-form">
    		<div class="page-header">
            	<h2><spring:message code="label.foma.title.edit.employee"/></h2>
        	</div>
        	<form:form class="form-horisontal" modelAttribute="modelEmployee" method="POST" action="save" acceptCharset="UTF-8">
        		<%@include file="../jspf/form-employee.jsp" %>
            	<%@include file="../jspf/button-form.jspf" %>
        	</form:form>
    	</div>
    </body>
</html>
