<%-- 
    Document   : index
    Created on : Jun 8, 2016, 11:18:34 AM
    Author     : firsov
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="kievreclama.task.entities.SqlQuery"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="kievreclama.task.entities.Task"%>
<%@page import="kievreclama.task.entities.Emploue"%>
<%@page import="kievreclama.task.dao.PostgresqlEmploueDao"%>
<%@page import="kievreclama.task.dao.PostgresqlTaskDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PostgresqlEmploueDao pgEmploue = new PostgresqlEmploueDao();
    Emploue emploue = pgEmploue.findEmploue( request.getUserPrincipal().getName());
    if (null == request.getSession().getAttribute("UserTask")){
        PostgresqlTaskDao pgTaskDao = new PostgresqlTaskDao();
        ArrayList<Task> listTask = pgTaskDao.fillEmpluertTask(emploue);
        session.setAttribute("UserTask", listTask);
    }
    session.setAttribute("emploue", emploue);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../../css/index_1.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <table class="title">
            <tr>
                <td class="user_name">Користувач: &nbsp; ${emploue.getSurname()} &nbsp; ${emploue.getName()}</td>
                <td></td>
                <form>
                    <td class="button"><button formaction="add_task.jsp">Додати</button></td>
                    <td class="button"><button formaction="/task/private/ServletEnd">Вийти</button></td>
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
            <c:forEach var="task" items="${UserTask}" varStatus="stepValue">
                <tr>
                    <c:set var="id">${stepValue.count}</c:set>
                    <td><a href="edit_task.jsp?index=${id}"><div>${task.getPriority()}</div></a></td>
                    <td id="content_task"><a href="edit_task.jsp?index=${id}"><div>${task.getInfoTask()}</div></a></td>
                    <td><a href="edit_task.jsp?index=${id}"><div>${task.getNumber()}</div></a></td>
                    <td><a href="edit_task.jsp?index=${id}"><div>${task.getDate()}</div></a></td>
                    <td>
                        <a href="edit_task.jsp?index=${id}">
                            <div>
                                <input type="checkbox" disabled="disabled" 
                                    <c:if test="${task.isStatys()}">
                                        checked 
                                    </c:if> >
                            </div>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
</html>
