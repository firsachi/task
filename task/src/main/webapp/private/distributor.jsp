<%-- 
    Document   : distributor
    Created on : Jun 25, 2016, 2:46:23 PM
    Author     : firsachi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if (request.isUserInRole("hr")){
        
    }else if(request.isUserInRole("task")){
        response.sendRedirect("/task/private/ts/index.jsp");
    }else{
        response.sendRedirect("/task/");
    }
%>
