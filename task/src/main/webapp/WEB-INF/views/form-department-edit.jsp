<%-- 
    Document   : form-department
    Created on : 26.08.2016, 15:43:06
    Author     : firsov
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    	<spring:message code="label.foma.title.edit.department" var="departmentTitle"/>
        <title>${ departmentTitle }</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="../jspf/map-main-css.jspf"%>
    </head>
    <body>
        <div class="box-form">
        	<div class="page-header">
        		<h2>${ departmentTitle }</h2>
        	</div>
        	<form:form class="form-horisontal" modelAttribute="modelDepartment" method="POST" action="save" acceptCharset="UTF-8">
            	<%@include file="../jspf/main-department.jsp" %>
            	<%@include file="../jspf/button-form.jspf" %>
        	</form:form>
        </div>
        
    </body>
</html>