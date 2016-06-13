<%-- 
    Document   : index
    Created on : Jun 8, 2016, 11:18:34 AM
    Author     : firsov
--%>

<%@page import="kievreclama.task.entities.Task"%>
<%@page import="kievreclama.task.entities.Emploue"%>
<%@page import="kievreclama.task.dao.PostgresqlEmploueDao"%>
<%@page import="kievreclama.task.dao.PostgresqlTaskDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! PostgresqlTaskDao pgTask = new PostgresqlTaskDao(); %>
<%
    session.setAttribute("name", request.getUserPrincipal().getName());
    PostgresqlEmploueDao pgEmploue = new PostgresqlEmploueDao();
    Emploue emploue = pgEmploue.findEmploue( (String) session.getAttribute("name"));
    session.setAttribute("emploue", emploue);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../css/index_1.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <table class="title">
            <tr>
                <td class="user_name">Користувач ${name}</td>
                <td></td>
                <form>
                    <td class="button"><button formaction="add_task.jsp">Додати</button></td>
                    <td class="button"><button formaction="ServletEnd">Вийти</button></td>
                </form>
            </tr>
        </table>
        <table class="content">
            <tr>
                <th>Приорітет</th>
                <th>Завдання</th>   
                <th width="150px">№ службової записки</th>
                <th width="75px">Дата</th>
                <th>Виконанно</th>
            </tr>
            <%
                for (Task task : pgTask.fillEmpluertTask(emploue)){
            %><tr>
                <td><a href="edit_task.jsp?index=<% out.print(task.getId()); %>"><%= task.getPriority() %></a></td>
                <td id="content_task"><a href="edit_task.jsp?index=<% out.print(task.getId()); %>"><% out.print(task.getInfoTask()); %></a></td>          
                <td><a href="edit_task.jsp?index=<% out.print(task.getId()); %>"><% out.print(task.getNumber()); %></a></td>
                <td><a href="edit_task.jsp?index=<% out.print(task.getId()); %>"><% out.print(task.getDate()); %></a></td>
                <td><a href="edit_task.jsp?index=<% out.print(task.getId()); %>">
                    <input type="checkbox" disabled="disabled"
                        <% 
                            if (task.isStatys()){
                                out.print("checked");
                            }
                        %>
                    ></a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
</html>
