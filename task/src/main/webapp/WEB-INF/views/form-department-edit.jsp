<%-- 
    Document   : form-department
    Created on : 26.08.2016, 15:43:06
    Author     : firsov
--%>

<%@page import="com.sun.jersey.server.impl.container.servlet.Include"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><spring:message code="label.foma.title.edit.department"/></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="../jspf/map-main-css.jspf"%>
    </head>
    <body>
        <div class="box-form">
        	<div class="page-header">
        		<h2><spring:message code="label.foma.title.edit.department"/></h2>
        	</div>
        	<form:form class="form-horisontal" modelAttribute="modelDepartment" method="POST" action="save" acceptCharset="UTF-8">
            	<div class="form-group">
                	<form:hidden path="id"/>
            	</div>
            	<div class="form-group">
                	<form:label path="name"><spring:message code="label.title.table.department.name"/></form:label>
                	<form:input path="name" required="true" pattern=""/>
            	</div>
            	<div class="form-group">
                	<form:label path="phone"><spring:message code="label.title.table.department.phone"/></form:label>
                	<form:input path="phone" required="true" pattern=""/>
            	</div>
            	<div class="form-group">
                	<form:label path="fax"><spring:message code="label.title.table.department.fax"/></form:label>
                	<form:input path="fax" required="true" pattern=""/>
            	</div>
            	<%@include file="../jspf/button-form.jspf" %>
        	</form:form>
        </div>
        
    </body>
</html>