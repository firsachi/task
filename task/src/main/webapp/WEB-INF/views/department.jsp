<%-- 
    Document   : department
    Created on : Aug 23, 2016, 3:15:11 PM
    Author     : firsov
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Department</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../resources/css/page-private.css">
    </head>
    
    <body>
        <div class="topic">
            <a href="../employee/">Employee</a>
            <a href="../post/">Post</a>
            <a class="selected" href=".">Department</a>
            <a href="../company/">Enterprise</a>
            <a class="add" href="form?id=0">+</a>
        </div>
        <div class="table-div">
            <div class="row-div th">
                <div>Назва відділу</div>
                <div>Підриємство</div>
                <div>Телефон</div>
                <div>Факс</div>
            </div>
        </div>
    </body>
</html>
