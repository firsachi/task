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
        <div class="table">
            <div class="row">
                <div class="cell menu">
                    <div class="menu-blok-border">
                        <div class="table-th">Name</div>
                        <a class="link-dekoration menu-blok" href="../employee/">Employee</a>
                        <a class="link-dekoration menu-blok" href="">Post</a>
                        <a class="link-dekoration menu-blok" href="">Department</a>
                        <a class="link-dekoration menu-blok menu-select" href=".">Enterprise</a>
                    </div>
                    <a class="menu-link-add link-dekoration" href="form?id=0">Add</a>
                </div>
                <div class="cell">
                    <div class="table">
                        <div class="row">
                            <div class="cell table-th">№</div>
                            <div class="cell table-th">Назва підприємства</div>
                        </div>
                        <c:forEach var="enterprise" items="${company}">
                            <div class="row select">
                                <div class="cell table-td"><a href="form?id=${enterprise.getId()}">${enterprise.getId()}</a></div>
                                <div class="cell table-td"><a href="form?id=${enterprise.getId()}">${enterprise.getName()}</a></div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>