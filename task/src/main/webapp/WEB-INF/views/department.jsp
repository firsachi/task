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
        <link rel="stylesheet" type="text/css" href="../../resources/css/page-private.css">
    </head>
    
    <body>
        <div class="topic">
            <a href="../employee/"><spring:message code="label.main.menu.employee"/></a>
            <a href="../post/"><spring:message code="label.main.menu.post"/></a>
            <a class="selected" href="."><spring:message code="label.main.menu.departmen"/></a>
            <a href="../company/"><spring:message code="label.main.menu.company"/></a>
            <a class="add" href="add">+</a>
        </div>
        <div class="table-div">
            <div class="row-div th">
                <div><spring:message code="label.title.table.department.name"/></div>
                <div><spring:message code="label.title.table.department.phone"/></div>
                <div><spring:message code="label.title.table.department.fax"/></div>
            </div>
            <c:forEach var="department" items="${departments}" varStatus="num">
                <div class="row-div td">
                    <div><a href="${department.getId()}">${department.getName()}</a></div>
                    <div><a href="${department.getId()}">${department.getPhone()}</a></div>
                    <div><a href="${department.getId()}">${department.getFax()}</a></div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
