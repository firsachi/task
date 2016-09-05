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
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../../resources/css/page-private.css">
    </head>
    <body>
        <div class="topic">
            <a href="../employee/"><spring:message code="label.main.menu.employee"/></a>
            <a href="../post/"><spring:message code="label.main.menu.post"/></a>
            <a href="../department/"><spring:message code="label.main.menu.departmen"/></a>
            <a class="selected" href="."><spring:message code="label.main.menu.company"/></a>
            <a class="add" href="add">+</a>
        </div>
        <div class="table-div">
            <div class="row-div th">
                <div><spring:message code="label.title.table.companu.id"/></div>
                <div><spring:message code="label.title.table.companu.name"/></div>
            </div>
            <c:forEach var="enterprise" items="${company}" varStatus="loop">
                <div class="row-div td">
                    <div><a href="edit${enterprise.getId()}">${loop.index+1}</a></div>
                    <div><a href="edit${enterprise.getId()}">${enterprise.getName()}</a></div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>