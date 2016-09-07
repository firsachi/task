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
        <link rel="stylesheet" type="text/css" href="../../resources/css/page-private.css">
    </head>
    
    <body>
        <div class="topic">
            <a href="../employee/"><spring:message code="label.main.menu.employee"/></a>
            <a class="selected" href="."><spring:message code="label.main.menu.post"/></a>
            <a href="../department/"><spring:message code="label.main.menu.departmen"/></a>
            <a href="../company/"><spring:message code="label.main.menu.company"/></a>
            <a class="add" href="add">+</a>
        </div>
        <div class="table-div">
            <div class="row-div th">
                <div><spring:message code="label.title.table.post.number"/></div>
                <div><spring:message code="label.title.table.post.name"/></div>
                <div><spring:message code="label.title.table.post.heft"/></div>
            </div>
            <c:forEach var="value" items="${position}" varStatus="number">
                <div class="row-div td">
                    <div>${number.index + 1}</div>
                    <div><a href="edit${value.getId()}">${value.getName()}</a></div>
                    <div><a href="edit${value.getId()}">${value.getHeft()}</a></div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
