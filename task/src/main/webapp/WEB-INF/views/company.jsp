<%-- 
    Document   : company
    Created on : Aug 21, 2016, 11:27:22 AM
    Author     : firsachi
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Enterprise</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../resources/css/page-private.css">
    </head>
    <body>
        <div class="topic">
            <a href="../employee/">Employee</a>
            <a href="../post/">Post</a>
            <a href="../department/">Department</a>
            <a class="selected" href=".">Enterprise</a>
            <a class="add" href="form?id=0">+</a>
        </div>
        <div class="table-div">
            <div class="row-div th">
                <div>№</div>
                <div>Назва підприємства</div>
            </div>
            <c:forEach var="enterprise" items="${company}" varStatus="loop">
                <div class="row-div td">
                    <div><a href="form?id=${enterprise.getId()}">${loop.index+1}</a></div>
                    <div><a href="form?id=${enterprise.getId()}">${enterprise.getName()}</a></div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>