<%-- 
    Document   : form_task
    Created on : Jun 3, 2016, 10:41:15 AM
    Author     : firsov
--%>

<%@page import="kievreclama.task.entities.Urgency"%>
<%@page import="kievreclama.task.dao.PostgresqlUrgencyDao"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" type="text/css" href="../css/form_task.css"/>
        <title>Нове завдвння</title>
    </head>
    <body>
        <div class="center">
            <form action="NewTask" method="post">
            <div class="tile">Новае завдання.</div>
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
                %>  <input type="radio" name="priority" value="<% out.print(arrayList.get(index).getId()); %>"<%
                        if(index==sizeArray-1){
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
                <input class="size" type="text" name="number">
            </div>
            <div>
                Зміст завдання:<br>
                <textarea name="infoTask"></textarea>
            </div>
            <div>
                <input type="reset">
                <input type="submit" value="Записати">
                <input type="button" onclick="self.location.href='/task/private/index.jsp';"  value="Повернутися">
            </div>
            </form>
        </div>
    </body>
</html>
