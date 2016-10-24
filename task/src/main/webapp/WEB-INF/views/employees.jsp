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
        <script src="../../resources/js/jquery.js"></script>
        <script src="../../resources/js/main.js"></script>
    </head>
    <body>
        <nav>
            <ul>
                <li><a class="select" href="./"><spring:message code="label.main.menu.employee"/></a></li>
                <li><a href="../post/"><spring:message code="label.main.menu.post"/></a></li>
                <li><a href="../department/"><spring:message code="label.main.menu.departmen"/></a></li>
                <li><a href="../company/"><spring:message code="label.main.menu.company"/></a></li>
            </ul>
        </nav>
        <div class="filtr">
            <div>
                <spring:message code="label.title.table.employee.room"/>
                <select id="room" name="room">
                    <option value="0">All</option>
                    <c:forEach var="room" items="${rooms}">
                        <option>${room.getNumberRoom()}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <spring:message code="label.title.table.employee.department"/>
                <select name="department">
                    <option value="0">All</option>
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
