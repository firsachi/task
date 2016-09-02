<%-- 
    Document   : index
    Created on : Jun 8, 2016, 9:15:19 AM
    Author     : firsov
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="refresh" content="600">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="resources/css/index.css"/>
        <title>Список завдань.</title>
    </head>
    <body>
        <div class="table">
            <div class="row title">
                <div class="font">Київреклама</div>
                <div></div>
                <a class="login" href="private/">Login</a>
            </div>
        </div>
        <div class="table pdding">
            <div class="row th">
                <div>Приорітет</div>
                <div>Замовник</div>
                <div>Завдання</div>
                <div>№ службової записки</div>
                <div>Дата</div>
                <div></div>
            </div>
            <c:forEach var="value" items="${tasks}">
                <div class="row td">
                    <div>${value.getUrgensy()}</div>
                    <div>
                        ${value.getEmployee().getSurname()} 
                        ${value.getEmployee().getName()} 
                        ${value.getEmployee().getPatronymic()}
                    </div>
                    <div>${value.getTask()}</div>
                    <div>${value.getNumber()}</div>
                    <div>${value.getDate()}</div>
                    <div>
                        <input type="checkbox" disabled="disabled" <c:if test="${value.getState()}">checked</c:if>>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
