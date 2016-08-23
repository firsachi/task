<%-- 
    Document   : post
    Created on : Aug 23, 2016, 12:06:44 PM
    Author     : firsov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Post</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../resources/css/page-private.css">
    </head>
    
    <body>
        <div class="topic">
            <a href="../employee/">Employee</a>
            <a class="selected" href=".">Post</a>
            <a href="../department/">Department</a>
            <a href="../company/">Enterprise</a>
            <a class="add" href="form?id=0">+</a>
        </div>
        <div class="table-div">
            <div class="row-div th">
                <div>Назва посади</div>
                <div>Важливість посади</div>
            </div>
        </div>
    </body>
</html>
