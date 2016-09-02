<%-- 
    Document   : post
    Created on : Aug 23, 2016, 12:06:44 PM
    Author     : firsov
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Post</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../../resources/css/page-private.css">
    </head>
    
    <body>
        <div class="topic">
            <a href="../employee/">Employee</a>
            <a class="selected" href=".">Post</a>
            <a href="../department/">Department</a>
            <a href="../company/">Enterprise</a>
            <a class="add" href="0">+</a>
        </div>
        <div class="table-div">
            <div class="row-div th">
                <div>№</div>
                <div>Назва посади</div>
                <div>Важливість посади</div>
            </div>
            <c:forEach var="value" items="${position}" varStatus="number">
                <div class="row-div td">
                    <div>${number.index + 1}</div>
                    <div><a href="${value.getId()}">${value.getName()}</a></div>
                    <div><a href="${value.getId()}">${value.getHeft()}</a></div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
