<%-- 
    Document   : post
    Created on : 18.10.2017, 12:06:44 PM
    Author     : firsachi
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><spring:message code="label.main.handbook.titleRoom"/></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="../jspf/map-file.jspf" %>
    </head>
    
    <body>
		<%@include file="../jspf/main-menu.jsp" %>
    	<div id="menu"><%@include file="../jspf/menu-handbook.jsp" %></div>
        <div class="container-fluid">
        	<table class="table" style="table-layout: fixed;">
        		<col>
        		<col>
        		<col width=180px>
        		<tr>
        			<th><spring:message code="label.title.table.post.number"/></th>
        			<th><spring:message code="label.room.number"/></th>
        			<th  >
    					<button class="button-add" onclick="self.location.href='add';">
    						<spring:message code="label.button.add"/>
    					</button>
    				</th>
        		</tr>
            	<c:forEach var="value" items="${rooms}" varStatus="number">
                	<tr>
                		<td>${number.index + 1}</td>
                		<td>${value.numberRoom}</td>
						<td>
							<button onclick="self.location.href='edit/${value.id}';">
    							<spring:message code="label.button.edit"/>
    						</button>
    					
    						<button onclick="self.location.href='delete${value.id}';">
    							<spring:message code="label.button.delete"/>
    						</button>
						</td>
                	</tr>
            	</c:forEach>
            </table>
        </div>
    </body>
</html>