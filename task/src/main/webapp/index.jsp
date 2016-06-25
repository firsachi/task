<%-- 
    Document   : index
    Created on : Jun 8, 2016, 9:15:19 AM
    Author     : firsov
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kievreclama.task.entities.SqlQuery"%>
<%@page import="kievreclama.task.entities.Task"%>
<%@page import="kievreclama.task.entities.Urgency"%>
<%@page import="kievreclama.task.entities.Emploue"%>
<%@page import="kievreclama.task.entities.SettingsFilter"%>
<%@page import="kievreclama.task.dao.PostgresqlUrgencyDao"%>
<%@page import="kievreclama.task.dao.PostgresqlEmploueDao"%>
<%@page import="kievreclama.task.dao.PostgresqlTaskDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! PostgresqlTaskDao pgTask = new PostgresqlTaskDao(); %>
<%! PostgresqlEmploueDao pgEmploue = new PostgresqlEmploueDao(); %>
<%! PostgresqlUrgencyDao pgUrgency = new PostgresqlUrgencyDao(); %>
<%! List<Task> listTask = new ArrayList<>(); %>
<% 
    SettingsFilter settingsFilter = new SettingsFilter();
    if (null != session.getAttribute("filter")){
        settingsFilter = (SettingsFilter) session.getAttribute("filter");
    }else{
        session.setAttribute("filter", settingsFilter);
    }
    if (null==session.getAttribute("table")){
        session.setAttribute("table", SqlQuery.ALL_TASK);
    }
    listTask = pgTask.fillTables( (String) session.getAttribute("table"));
    pageContext.setAttribute("tasks", listTask);
    pageContext.setAttribute("ofurgency", pgUrgency.allUrgency());
    pageContext.setAttribute("emplouers", pgEmploue.allEpmloue());
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="refresh" content="600">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/index.css"/>
        <title>Список завдань.</title>
    </head>
    <body>
        <table class="titles">
            <tr>
            <td class="logo"><img src="img/logo.png" alt="logotip"></td>
            <td class="name">Київреклама</td>
            <td>Фільтри:
                    <form action="ServletFilterIndex" method="post" >
                        Замовник
                        <select name="customer">
                            <option value="0">Всі</option>

                            <c:forEach var="emploue" items="${emplouers}">
                                <option value="${emploue.getId() }"
                                        <c:if test="${emploue.getId() == filter.getCustumer()}">
                                            selected 
                                        </c:if>
                                        >${emploue.getLogin()}</option>
                            </c:forEach>
                            </select>
                            &nbsp;
                            Приорітет:
                            <select name="priority">
                                <option value="0">Всі</option>
                                <c:forEach var="urgency" items="${ofurgency}">
                                    <option value="${urgency.getId()}" 
                                            <c:if test="${urgency.getId() == filter.getPriority()}"> 
                                                selected 
                                            </c:if> >
                                        ${urgency.getId()}
                                    </option>
                                </c:forEach>
                            </select>
                            ${filter.getPriority()}
                            &nbsp;
                            Статус:
                            <select name="status">
                                <option value="0" <c:if test="${0 == filter.isStatys()}" > selected </c:if> >Всі</option>
                                <option value="1" <c:if test="${1 == filter.isStatys()}" > selected </c:if> >Виконано</option>
                                <option value="2" <c:if test="${2 == filter.isStatys()}" > selected </c:if> >В роботі</option>
                            </select>
                            &nbsp;
                            <input type="submit" value="Виконати">        
                            <input type="button" onclick="location.href='FilterClear'" value="Скасувати">
                        </form>
            </td>
            <td class="login"><button onclick="window.location.href='private/index.jsp'">Увійти</button></td>
            </tr>
        </table>
        <div>
            <table class="content">
                <div style="position: fixed;">
                <tr>
                    <th>Приорітет</th>
                    <th width="7%">Замовник</th>
                    <th width="60%">Завдання</th>        
                    <th>№ службової записки</th>
                    <th>Дата</th>
                    <th>Виконанно</th>
                </tr>
                </div>
                <c:forEach var="task" items="${tasks}">
                    <tr>
                        <td> ${task.getPriority()} </td>
                        <td> ${task.getEmploue().getLogin()} </td>
                        <td id="content_task"> ${task.getInfoTask()} </td>           
                        <td> ${task.getNumber()} </td>
                        <td> ${task.getDate()} </td>
                        <td> <input type="checkbox" disabled="disabled" 
                                    <c:if test="${task.isStatys()}">
                                        checked 
                                    </c:if> >
                        </td>
                    </tr>
                </c:forEach>
            </table>
            
        </div>
    </body>
</html>
