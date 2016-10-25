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
        <link rel="stylesheet" type="text/css" href="../../resources/css/page-private.css">
    </head>
    <body>
        <nav>
            <ul>
                <li><a href="../employee/"><spring:message code="label.main.menu.employee"/></a></li>
                <li><a href="../post/"><spring:message code="label.main.menu.post"/></a></li>
                <li><a href="../department/"><spring:message code="label.main.menu.departmen"/></a></li>
                <li><a class="select" href="."><spring:message code="label.main.menu.company"/></a></li>
                <li class="add"><a href="add">+</a></li>
            </ul>
        </nav>
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