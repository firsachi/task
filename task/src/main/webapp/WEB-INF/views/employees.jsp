<%-- 
    Document   : employee
    Created on : Aug 20, 2016, 9:08:04 AM
    Author     : firsachi
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <title><spring:message code="label.main.menu.employee"/></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="../jspf/map-file.jspf" %>
        <script src="../../resources/js/main.js"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/filtr-emloyee.js"/>"></script>
    </head>
    <body>
		<%@include file="../jspf/main-menu.jsp" %>
    	<div id="menu"><%@include file="../jspf/menu-employee.jsp" %></div>
        <div class="filtr">
            <div>
                <spring:message code="label.title.table.employee.room"/>
                <select id="room" name="room">
                    <option value="0"> All </option>
                    <c:forEach var="room" items="${listRoom}">
                        <option><c:out value="${room.numberRoom}"></c:out></option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <spring:message code="label.title.table.employee.department"/>
                <select id="department" name="department">
                    <option value="0"> All </option>
                    <c:forEach var="department" items="${listDepartment}">
                        <option><c:out value="${department.name}"></c:out></option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <spring:message code="label.title.table.employee.company"/>
                <select name="conpany">
                    <option value="0">All</option>
                </select>
            </div>     
        </div>
        <div class="container-fluid">
        	<table class="table">
        		<col>
        		<col>
        		<col>
        		<col>
        		<col>
        		<col>
        		<col>
        		<col width=180px>
        		<tr>
        			<th><spring:message code="label.title.table.employee.number"/></th>
        			<th><spring:message code="label.title.table.employee.room"/></th>
        			<th><spring:message code="label.title.table.employee.fullName"/></th>
        			<th><spring:message code="label.title.table.employee.company"/></th>
        			<th><spring:message code="label.title.table.employee.department"/></th>
        			<th><spring:message code="label.title.table.employee.post"/></th>
        			<th><spring:message code="label.title.table.employee.email"/></th>
        			<th>
    					<button class="button-add" onclick="self.location.href='add';">
    						<spring:message code="label.button.add"/>
    					</button>
    				</th>
        		</tr>
        		<c:forEach var="employee" items="${employees}">
        			<tr>
        				<td><c:out value="${employee.phone}"/></td>
        				<td><c:out value="${employee.room}"/></td>
        				<td>
        					<c:out value="${employee.surname}"/>
                        	<c:out value="${employee.name}"/>
                        	<c:out value="${employee.patronymic}"/>
                        </td>
                        <td><c:out value="${ employee.enterprise }"/></td>
                        <td><c:out value="${ employee.department }"/></td>
                        <td><c:out value="${employee.post}"/></td>
                        <td><c:out value="${employee.email}"/></td>
                        <td>
        					<button onclick="self.location.href='edit${employee.getId()}';">
    							<spring:message code="label.button.edit"/>
    						</button>
    						<button onclick="self.location.href='delete${employee.getId()}';">
    							<spring:message code="label.button.delete"/>
    						</button>
        				</td>
                    </tr>
        		</c:forEach>
        	</table>
        </div>
    </body>
</html>
