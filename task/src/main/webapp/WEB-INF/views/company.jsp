<%-- 
    Document   : company
    Created on : Aug 21, 2016, 11:27:22 AM
    Author     : firsachi
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><spring:message code="label.main.menu.company"/></title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<%@include file="../jspf/map-file.jspf" %>
    </head>
    
    <body>
    	<%@include file="../jspf/main-menu.jspf" %>
    	<div id="menu"><%@include file="../jspf/employees-menu.jspf" %></div>
    	<div class="container-fluid">
    		<table class="table">
    			<col>
    			<col>
    			<col width="175px">
    			<tr>
    				<th><spring:message code="label.title.table.companu.id"/></th>
    				<th><spring:message code="label.title.table.companu.name"/></th>
    				<th>
    					<button class="button-add" onclick="self.location.href='add';">
    						<spring:message code="label.button.add"/>
    					</button>
    				</th>
    			</tr>
    			<c:forEach var="enterprise" items="${company}" varStatus="loop">
    				<tr>
    					<td>${loop.index+1}</td>
    					<td>${enterprise.getName()}</td>
    					<td>
    						<button onclick="self.location.href='edit${enterprise.getId()}';" data-toggle="dropdown">
    							<spring:message code="label.button.edit"/>
    						</button>
    						<button onclick="show( this )" data-toggle="dropdown">
    							<spring:message code="label.button.delete"/>
    						</button>
    					</td>
    				</tr>
    			</c:forEach>
			</table>
		</div>
    </body>
</html>