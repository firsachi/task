<%-- 
    Document   : form-task
    Created on : Sep 1, 2016, 2:59:55 PM
    Author     : firsov
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" type="text/css" href="../../resources/css/form_task.css"/>
        <title>Нове завдвння</title>
    </head>
    <body>
        <div class="center">
            <div class="tile">Новае завдання.</div>
            <form:form modelAttribute="taskModel" method="POST" action="add" accept-charset="utf-8">
                <div>
                    Ім'я користувача:<br>
                    <span class="user-name">${employee.getSurname()} ${employee.getName()} ${employee.getPatronymic()}</span>
                    <form:input class="size" type="hidden" path="employee" value="${employee.getId()}"/>
                </div>
                <div>
                    Приорітет:<br>
                    <form:radiobuttons path="urgensy" items="${urgency}"/>
                </div>
                <div>
                    № службової записки:<br>
                    <form:input class="size" path="number" required="true"/>
                </div>
                <div>
                    <form:label path="task">Зміст завдання:</form:label><br>
                    <form:textarea path="task" required="true" ></form:textarea>${task.getTask()}
                     
                </div>
                
                <div>
                    <input type="reset">
                    <input type="submit" value="Записати">
                    <input type="button" onclick="self.location.href='.';"  value="Повернутися">
                </div>
            </form:form>
        </div>
    </body>
</html>
