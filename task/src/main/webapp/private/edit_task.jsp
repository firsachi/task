<%-- 
    Document   : form_task
    Created on : Jun 3, 2016, 10:41:15 AM
    Author     : firsov
--%>

<%@page import="kievreclama.task.entities.Urgency"%>
<%@page import="kievreclama.task.entities.Task"%>
<%@page import="kievreclama.task.dao.PostgresqlTaskDao"%>
<%@page import="kievreclama.task.dao.PostgresqlUrgencyDao"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  
    PostgresqlTaskDao pgTask = new PostgresqlTaskDao();
    Task task = pgTask.getTask(new Integer(request.getParameter("index")));
    session.setAttribute("task", task);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" type="text/css" href="../css/form_task.css"/>
        <title>Нове завдвння</title>
    </head>
    <body>
        <div class="center">
            <form action="UpdateTask" method="post">
            <div class="tile">Редагувати завдання.</div>
            <div>
                Ім'я користувача:
                <br>
                <input class="size" type="text" naname="login" value="${name}" disabled="disabled">
            </div>
            <div>
                Приорітет:<br>
                <%
                    PostgresqlUrgencyDao urgencyDao = new PostgresqlUrgencyDao();
                    ArrayList<Urgency> arrayList = urgencyDao.allUrgency();
                    int sizeArray = arrayList.size();
                    for (int index = 0; index < sizeArray; index++){
                %>  <input type="radio" name="priority" value="<%= arrayList.get(index).getId() %>"<%
                        if(index== task.getPriority()-1){
                            out.print(" checked");
                        }
                        %>
                        >
                        <% out.print(arrayList.get(index).getId());%>
                        <br><%
                    }
                %>
            </div>
            <div>
                № службової записки: <br>
                <input class="size" type="text" name="number" value="<%= ((Task) session.getAttribute("task")).getNumber() %>">
            </div>
            <div>
                Зміст завдання:<br>
                <textarea name="infoTask"><%= ((Task) session.getAttribute("task")).getInfoTask() %></textarea>
            </div>
            <div>
                Статус завдання: 
                <input type="checkbox" name="status" <%= ((Task) session.getAttribute("task")).isStatys() ? "checked" : "" %> >
            </div>
            <div>
                <input type="reset">
                <input type="submit" value="Записати">
                <input type="button" value="Повернутися" onclick="self.location.href='/task/private/index.jsp';">
            </div>
            </form>
            <div>
                <form action="DeleteTask" method="post">
                    <input type="hidden" name="id" value="<%= ((Task) session.getAttribute("task")).getId() %>">
                    <input type="submit" value="Видалити">
                </form>
            </div>
        </div>
    </body>
</html>
