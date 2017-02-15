<%-- 
    Document   : department
    Created on : Aug 23, 2016, 3:15:11 PM
    Author     : firsov
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><spring:message code="label.main.menu.departmen"/></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="../jspf/map-file.jspf"%>
    </head>
    
    <body>
		<%@include file="../jspf/main-menu.jspf" %>
    	<div id="menu"><%@include file="../jspf/employees-menu.jspf" %></div>
        <div class="container-fluid">
        	<table class="table">
        		<tr>
        			<th><spring:message code="label.title.table.department.name"/></th>
        			<th><spring:message code="label.title.table.department.phone"/></th>
        			<th><spring:message code="label.title.table.department.fax"/></th>
        			<th><button>Додати</button></th>
        		</tr>
        		<c:forEach var="department" items="${departments}" varStatus="num">
        			<tr>
        				<td>${department.getName()}</td>
        				<td>${department.getPhone()}</td>
        				<td>${department.getFax()}</td>
        				<td>
        					<button onclick="self.location.href='edit${department.getId()}';">Редагувати</button>
        					<button>Видалити</button>
        				</td>
        			</tr>
        		</c:forEach>	
        	</table>
        </div>
    </body>
</html>
