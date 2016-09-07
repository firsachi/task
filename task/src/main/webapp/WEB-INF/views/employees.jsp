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
        <link rel="stylesheet" type="text/css" href="../../resources/css/page-private.css">
    </head>
    <body>
        <div class="topic">
            <a class="selected" href="./"><spring:message code="label.main.menu.employee"/></a>
            <a href="../post/"><spring:message code="label.main.menu.post"/></a>
            <a href="../department/"><spring:message code="label.main.menu.departmen"/></a>
            <a href="../company/"><spring:message code="label.main.menu.company"/></a>
            <a class="add" href="add">+</a>
        </div>
        ${isUserInRole}
        <div class="table-div">
            <div class="row-div th">
                <div><spring:message code="label.title.table.employee.number"/></div>
                <div><spring:message code="label.title.table.employee.room"/></div>
                <div><spring:message code="label.title.table.employee.fullName"/></div>
                <div><spring:message code="label.title.table.employee.company"/></div>
                <div><spring:message code="label.title.table.employee.department"/></div>
                <div><spring:message code="label.title.table.employee.post"/></div>
                <div><spring:message code="label.title.table.employee.email"/></div>
            </div>
            <c:forEach var="employee" items="${employees}">
                <div class="row-div td">
                    <div><a href="edit${employee.getId()}">${employee.getPhone().getNumber()}</a></div>
                    <div><a href="edit${employee.getId()}">${employee.getRoom().getNumberRoom()}</a></div>
                    <div>
                        <a href="edit${employee.getId()}">
                            ${employee.getSurname()} 
                            ${employee.getName()} 
                            ${employee.getPatronymic()}
                        </a>
                    </div>
                    <div>
                        <a href="edit${employee.getId()}">${employee.getEnterprise().getName()}</a>
                    </div>
                    <div>
                        <a href="edit${employee.getId()}">${employee.getDepartment().getName()}</a>
                    </div>
                    <div>
                        <a href="edit${employee.getId()}">${employee.getPost().getName()}</a>
                    </div>
                    <div>
                        <a href="edit${employee.getId()}">${employee.getEmail()}</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
