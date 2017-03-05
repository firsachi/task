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
        <title><spring:message code="label.foma.title.add.employee"/></title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="../jspf/map-main-css.jspf"%>
    </head>
    <body>
    	<div class="box-form">
    		<div class="page-header">
            	<h2><spring:message code="label.foma.title.add.employee"/></h2>
        	</div>
        	<form:form class="form-horisontal" modelAttribute="modelEmployee" method="POST" action="save" acceptCharset="UTF-8">
            	<div class="form-group">
                	<form:hidden path="id"/>
            	</div>
            	<div class="form-group">
                	<form:label path="surname"><spring:message code="label.form.employee.surname"/></form:label>
                	<form:input path="surname" required="true" pattern=""/>
            	</div>
            	<div class="form-group">
                	<form:label path="name"><spring:message code="label.from.employee.name"/></form:label> 
                	<form:input path="name" required="true" pattern=""/>
            	</div>
            	<div class="form-group">
                	<form:label path="patronymic"><spring:message code="label.form.employee.patronymic"/></form:label> 
                	<form:input path="patronymic" required="true" pattern=""/>
            	</div>
           		<div class="form-group">
               		<form:label path="idEnterprise"><spring:message code="label.title.table.employee.company"/></form:label>
                	<form:select path="idEnterprise" items="${listCompany}" itemValue="id" itemLabel="name"/> 
            	</div>
            	<div class="form-group">
                	<form:label path="idDepartment"><spring:message code="label.title.table.employee.department"/></form:label>
                	<form:select path="idDepartment"  items="${listDepartment}" itemValue="id" itemLabel="name" />
            	</div>         	
            	<div class="form-group">
            		<form:label path="idPost"><spring:message code="label.title.table.employee.post"/></form:label>
                	<form:select path="idPost" items="${listPost}" itemValue="id" itemLabel="name"/>
            	</div>
            	<div class="form-group">
                	<form:label path="idRoom"><spring:message code="label.title.table.employee.room"/></form:label> 
                	<form:select path="idRoom" items="${listRoom}" itemValue="id" itemLabel="numberRoom"/>
            	</div>
            	<div class="form-group">
                	<form:label path="idPhone"><spring:message code="label.title.table.employee.number"/></form:label>
                	<form:select path="idPhone" items="${listPhone}" itemValue="id" itemLabel="number"/>
            	</div>
            	<div class="form-group">
                	<form:label path="email"><spring:message code="label.title.table.employee.email"/></form:label> 
                	<form:input path="email"/>
            	</div>
            <%@include file="../jspf/button-form.jspf" %>
        </form:form>
    	</div>
    </body>
</html>
