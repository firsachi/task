<%-- 
    Document   : employee
    Created on : Aug 20, 2016, 9:08:04 AM
    Author     : firsachi
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <title><spring:message code="label.main.menu.employee"/></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="../jspf/map-file.jspf" %>
        <script src="../../resources/js/main.js"></script>
    </head>
    <body>
		<%@include file="../jspf/main-menu.jspf" %>
        <div class="filtr">
            <div>
                <spring:message code="label.title.table.employee.room"/>
                <select id="room" name="room">
                    <option value="0"> All </option>
                    <c:forEach var="room" items="${rooms}">
                        <option>${room.getNumberRoom()}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <spring:message code="label.title.table.employee.department"/>
                <select id="department" name="department">
                    <option value="0"> All </option>
                    <c:forEach var="department" items="${departments}">
                        <option>${department.getName()}</option>
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
        		<tr>
        			<th><spring:message code="label.title.table.employee.number"/></th>
        			<th><spring:message code="label.title.table.employee.room"/></th>
        			<th><spring:message code="label.title.table.employee.fullName"/></th>
        			<th><spring:message code="label.title.table.employee.company"/></th>
        			<th><spring:message code="label.title.table.employee.department"/></th>
        			<th><spring:message code="label.title.table.employee.post"/></th>
        			<th><spring:message code="label.title.table.employee.email"/></th>
        		</tr>
        		<c:forEach var="employee" items="${employees}">
        			<tr>
        				<td><a href="edit${employee.getId()}">${employee.getPhone().getNumber()}</a></td>
        				<td><a href="edit${employee.getId()}">${employee.getRoom().getNumberRoom()}</a></td>
        				<td>
        					<a href="edit${employee.getId()}">
                                ${employee.getSurname()} 
                                ${employee.getName()} 
                                ${employee.getPatronymic()}
                            </a>
                        </td>
                        <td><a href="edit${employee.getId()}">${employee.getEnterprise().getName()}</a></td>
                        <td><a href="edit${employee.getId()}">${employee.getDepartment().getName()}</a></td>
                        <td><a href="edit${employee.getId()}">${employee.getPost().getName()}</a></td>
                        <td><a href="edit${employee.getId()}">${employee.getEmail()}</a></td>
                    </tr>
        		</c:forEach>
        	</table>
        </div>
    </body>
</html>
