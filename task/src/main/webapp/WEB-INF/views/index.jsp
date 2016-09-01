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
            <div class="row">
                <div class="logo">
                    <img src="resources/img/logo.png">
                </div>
                <div class="logo__title">Київреклама</div>
                <div></div>
                <div class="login"><a href="private/">Login</a></div>
            </div>
        </div>
        <div class="table">
            <div class="row th">
                <div>Приорітет</div>
                <div>Замовник</div>
                <div>Завдання</div>
                <div>№ службової записки</div>
                <div>Дата</div>
                <div>Виконанно</div>
            </div>
            <c:forEach var="value" items="${tasks}">
                <div class="row td">
                    <div>${value.getUrgensy()}</div>
                    <div>${value.getEmployee().getName()}</div>
                    <div>${value.getTask()}</div>
                    <div>${value.getNumber()}</div>
                    <div>${value.getDate()}</div>
                    <div>${value.getState()}</div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
