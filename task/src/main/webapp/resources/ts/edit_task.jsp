<%-- 
    Document   : form_task
    Created on : Jun 3, 2016, 10:41:15 AM
    Author     : firsov
--%>

<%@page import="kievreclama.task.entities.Urgency"%>
<%@page import="kievreclama.task.entities.Task"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  
    int index = new Integer(request.getParameter("index")) -1;
    Task task = ((ArrayList<Task>) session.getAttribute("UserTask")).get(index);
    session.setAttribute("updateTask", task);
    session.setAttribute("index", index);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" type="text/css" href="../../css/form_task.css"/>
        <title>Нове завдвння</title>
    </head>
    <body>
        <div class="center">
            <form action="UpdateTask" method="post">
            <div class="tile">Редагувати завдання.</div>
            <div>
                Ім'я користувача:
                <br>
                <input class="size" type="text" naname="login" value="${emploue.getSurname()} &nbsp; ${emploue.getName()}" disabled="disabled">
            </div>
            <div>
                Приорітет:<br>
                <jsp:include page="priority.jspf">
                    <jsp:param name="setPriority" value="${updateTask.getPriority()}"/>             
                </jsp:include>
            </div>
            <div>
                № службової записки: <br>
                <input class="size" type="text" name="number" value="${updateTask.getNumber()}">
            </div>
            <div>
                Зміст завдання:<br>
                <textarea name="infoTask">${updateTask.getInfoTask()}</textarea>
            </div>
            <div>
                Статус завдання: 
                <input type="checkbox" name="status"  >
            </div>
            <div>
                <input type="reset">
                <input type="submit" value="Записати">
                <input type="button" value="Повернутися" onclick="self.location.href='/task/private/ts/index.jsp';">
            </div>
            </form>
            <div>
                <form action="DeleteTask" method="post">
                    <input type="hidden" name="id" value="<%= task.getId() %>">
                    <input type="submit" value="Видалити">
                </form>
            </div>
        </div>
    </body>
</html>
