<%-- 
    Document   : post
    Created on : Aug 23, 2016, 12:06:44 PM
    Author     : firsov
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><spring:message code="label.main.menu.post"/></title>
        <meta charset="UTF-8">
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
    			<col>
    			<col width="175px">
        		<tr>
        			<th><spring:message code="label.title.table.post.number"/></th>
        			<th><spring:message code="label.title.table.post.name"/></th>
        			<th><spring:message code="label.title.table.post.heft"/></th>
        			<th>
    					<button class="button-add" onclick="self.location.href='add';">
    						<spring:message code="label.button.add"/>
    					</button>
    				</th>
        		</tr>
            	<c:forEach var="value" items="${position}" varStatus="number">
                	<tr>
                		<td>${number.index + 1}</td>
                		<td>${value.getName()}</td>
						<td>${value.getHeft()}</td>
						<td>
							<button onclick="self.location.href='edit${value.getId()}';" data-toggle="dropdown">
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
