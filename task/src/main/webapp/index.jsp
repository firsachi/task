<%-- 
    Document   : index
    Created on : Jun 8, 2016, 9:15:19 AM
    Author     : firsov
--%>


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
<% 
    SettingsFilter settingsFilter = new SettingsFilter();
    if (null != session.getAttribute("filter")){
        settingsFilter = (SettingsFilter) session.getAttribute("filter");
    }else{
        session.setAttribute("filter", settingsFilter);
    }
    if (null==session.getAttribute("table")){
        session.setAttribute("table", "SELECT tasks.id,emplouers.login,task,number,date_create,urgency,state,delete FROM tasks JOIN emplouers ON emplouers.id = tasks.emploue WHERE delete=false AND state=false ORDER BY urgency");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="refresh" content="10">
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
                        <%
                            for (Emploue emploue : pgEmploue.allEpmloue()){
                        %>
                            <option <%
                                        if (emploue.getId() == settingsFilter.getCustumer()){
                                            out.print(" selected");
                                        }
                                    %>
                                    value="<%= emploue.getId() %>"><%= emploue.getLogin() %></option>
                                    <%
                                    }
                                %>
                            </select>
                            &nbsp;
                            Приорітет:
                            <select name="priority">
                                <option value="0">Всі</option>
                                <% 
                                    for (Urgency urgency : pgUrgency.allUrgency()){
                                        %>
                                        <option <%
                                            if (urgency.getId() == settingsFilter.getPriority()){
                                                        out.print(" selected");
                                                    }
                                            %> 
                                            value="<% out.print(urgency.getId());%>" ><% out.print(urgency.getId()); %></option>
                                        <%
                                    }
                                %>
                                
                            </select>
                            &nbsp;
                            Статус:
                            <select name="status">
                                <option value="0" <%if (0==((SettingsFilter) session.getAttribute("filter")).isStatys()) {out.print(" selected");}%> >Всі</option>
                                <option value="1" <%if (1==((SettingsFilter) session.getAttribute("filter")).isStatys()) {out.print(" selected");}%> >Виконано</option>
                                <option value="2" <%if (2==((SettingsFilter) session.getAttribute("filter")).isStatys()) {out.print(" selected");}%> >В роботі</option>
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
                <%
                    //String sql = "SELECT tasks.id,emplouers.login,task,number,date_create,urgency,state,delete FROM tasks JOIN emplouers ON emplouers.id = tasks.emplouer WHERE delete=false";
                    for (Task task : pgTask.fillTables( (String) session.getAttribute("table"))){
                    %><tr>
                        <td> <% out.print(task.getPriority()); %> </td>
                        <td> <% out.print(task.getEmploue().getLogin()); %> </td>
                        <td id="content_task"> <% out.print(task.getInfoTask()); %> </td>           
                        <td> <% out.print(task.getNumber()); %> </td>
                        <td> <% out.print(task.getDate()); %></td>
                        <td> <input type="checkbox" disabled="disabled" <%
                            if (task.isStatys()){
                                out.print("checked");
                            }
                        %>>
                        </td>
                    </tr><%
                    }%>
            </table>
            
        </div>
    </body>
</html>
