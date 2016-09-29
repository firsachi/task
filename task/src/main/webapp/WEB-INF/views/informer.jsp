<%-- 
    Document   : informer
    Created on : 29.09.2016, 17:09:41
    Author     : firsov
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.css">
        <script src="../resources/js/jquery.js"></script>
        <script src="../resources/js/main.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid" role="navigation">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="http://www.kievreklama.kiev.ua/">Brand</a>
                    </div>
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <c:forEach var="enterprise" items="${company}" varStatus="loop">
                                <li><a href="1">${enterprise.getName()}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        <div class="container-fluid">
            <div class="row">
                <div class="col-xs-12 col-sm-6 col-md-8">
                    <div id="infoDepartment" class="jumbotron">
                            <h2 id="nameDepartment">${department.getName()}</h2>
                            <div class="row">
                                <div class="col-xs-6">Телефон: ${department.getPhone()}<span id="numberPhone"></span></div>
                                <div class="col-xs-6">Факс: ${department.getFax()}<span id="numberFax"></span></div>
                            </div>
                        </div>
                    <table id="infoEmployees" class="table table-striped">
                        <tr>
                            <th>ПІБ працівника</th>
                            <th>Посада</th>
                            <th>№ тел.вн</th>
                            <th>Кімната</th>
                            <th>Електронна адреса</th>
                        </tr>
                        <c:forEach var="employee" items="${employees}">
                            <tr>
                                <td>${employee.getFullName()}</td>
                                <td>${employee.getPost().getName()}</td>
                                <td>${employee.getPhone().getNumber()}</td>
                                <td>${employee.getRoom().getNumberRoom()}</td>
                                <td><a href="mailto:${employee.getFullName()}<${employee.getEmail()}>">${employee.getEmail()}</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="col-xs-4 col-md-4">
                    <div  id="menuDepartment" class="list-group">
                        <c:forEach var="department" items="${departments}">
                            <a href="${department.getId()}" id="" class="list-group-item">${department.getName()}</a>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </body>
    </body>
</html>
