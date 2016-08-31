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
        <link rel="stylesheet" type="text/css" href="../../resources/css/tasks.css">
        <title>Tasks</title>
    </head>
    <body>
        <div class="div-table">
            <div class="div-row">
                <div>Співробітник:</div>
                <div>${employee.getSurname()}  ${employee.getName()} ${employee.getPatronymic()}</div>
                <div></div>
                <div><a href="">Додати</a></div>
            </div>
        </div>
        <div class="div-table">
            <div class="div-row th">
                <div>Приорітет</div>
                <div>Завдання</div>
                <div>№ службової записки</div>
                <div>Дата</div>
                <div>Виконанно</div>
            </div> 
          <!--  <c:forEach var="val" items="${task}">
                <div class="div-row td">
                    <div>${val.getUrgensy()}</div>
                    <div>${val.getTask()}</div>
                    <div>${val.getNumber()}</div>
                    <div>${val.getDate()}</div>
                    <div>${val.getState()}</div>
                </div>
            </c:forEach>
          -->
        </div>
    </body>
</html>
