<%-- 
    Document   : index
    Created on : Aug 17, 2016, 2:54:47 PM
    Author     : firsov
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../../resources/css/index.css">
        <title>Tasks</title>
    </head>
    <body>
        <div class="table">
            <div class="row title">
                <div>Співробітник:</div>
                <div>${employee.getSurname()}  ${employee.getName()} ${employee.getPatronymic()}</div>
                <div></div>
                <a href="0&${employee.getId()}">Додати</a>
            </div>
        </div>
        <div class="table pdding">
            <div class="row th">
                <div>Приорітет</div>
                <div>Завдання</div>
                <div>№ службової записки</div>
                <div>Дата</div>
                <div></div>
            </div> 
             <c:forEach var="val" items="${listTask}">
                <div class="row td">
                    <div><a href="${val.getId()}&${employee.getId()}">${val.getUrgensy()}</a></div>
                    <div><a href="${val.getId()}&${employee.getId()}">${val.getTask()}</a></div>
                    <div><a href="${val.getId()}&${employee.getId()}">${val.getNumber()}</a></div>
                    <div><a href="${val.getId()}&${employee.getId()}">${val.getDate()}</a></div>
                    <div>
                        <input type="checkbox" disabled="disabled" <c:if test="${val.getState()}">checked</c:if>>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
