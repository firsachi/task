<%-- 
    Document   : index
    Created on : Jun 8, 2016, 9:15:19 AM
    Author     : firsov
--%>

<%@page import="kievreclama.task.dao.postgresql.PostgresqlUrgencyDao"%>
<%@page import="kievreclama.task.dao.UrgencyDao"%>
<%@page import="kievreclama.task.entity.SettingsFilter"%>
<%@page import="kievreclama.task.entity.SqlQuery"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! SettingsFilter settingsFilter = new SettingsFilter(); %>
<% 
    if (null != session.getAttribute("filter")){
        settingsFilter = (SettingsFilter) session.getAttribute("filter");
    }else{
        session.setAttribute("filter", settingsFilter);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="refresh" content="600">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="resources/index.css"/>
        <title>Список завдань.</title>
    </head>
    <body>
        <table class="titles">
            <tr>
                <td class="logo"><img src="resources/img/logo.png" alt="logotip"></td>
            <td class="name">Київреклама</td>
            <td>Фільтри:
                    <form action="ServletFilterIndex" method="post" >
                        Замовник
                        <select name="customer">
                            <option value="0">Всі</option>
                            <sql:query dataSource="jdbc/postgres" var="emplouers">
                                 <%= SqlQuery.ALL_EMPLOUERS %>
                            </sql:query>
                            <c:forEach var="emploue" items="${emplouers.rows}">
                                <option value="${emploue.login}"
                                        <c:if test="${emploue.id == filter.getCustumer()}">
                                            selected 
                                        </c:if>
                                        >${emploue.surname} &nbsp; ${emploue.name} </option>
                            </c:forEach>
                            </select>
                            &nbsp;
                            Приорітет:
                            <select name="priority">
                                <option value="0">Всі</option>
                                <sql:query dataSource="jdbc/postgres" var="ofurgency">
                                    <%= SqlQuery.ALL_URGENCY %>
                                </sql:query>
                                <c:forEach var="urgency" items="${ofurgency.rows}">
                                    <option value="${urgency.id}" 
                                            <c:if test="${urgency.id == filter.getPriority()}"> 
                                                selected 
                                            </c:if> >
                                        ${urgency.id}
                                    </option>
                                </c:forEach>
                            </select>
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
            <td class="login"><button onclick="window.location.href='private/distributor.jsp'">Увійти</button></td>
            </tr>
        </table>
        <div>
            <table class="content">
                <div style="position: fixed;">
                <tr>
                    <th>Приорітет</th>
                    <th>Замовник</th>
                    <th width="60%">Завдання</th>        
                    <th>№ службової записки</th>
                    <th>Дата</th>
                    <th>Виконанно</th>
                </tr>
                </div>
            <sql:query var="tasks" dataSource="jdbc/postgres">
                ${filter.getQuery()}
            </sql:query>
                <c:forEach var="task" items="${tasks.rows}">
                    <tr>
                        <td> ${task.urgency} </td>
                        <td id="content_task" > ${task.surname} &nbsp; ${task.name} &nbsp; ${task.patronymic} </td>
                        <td id="content_task"> ${task.task} </td>           
                        <td> ${task.number} </td>
                        <td> ${task.data_create} </td>
                        <td> <input type="checkbox" disabled="disabled" 
                                    <c:if test="${task.state}">
                                        checked 
                                    </c:if> >
                        </td>
                    </tr>
                </c:forEach>
            </table>
            
        </div>
    </body>
</html>
