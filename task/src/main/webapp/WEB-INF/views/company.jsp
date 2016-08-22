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
        <div style="display: table;">
            <div style="display: table-row">
                <div class="menu">
                    <ul>
                        <li><a href="">Users</a></li>
                        <li><a href="">Post</a></li>
                        <li><a href="">Department</a></li>
                        <li><a href="">Enterprise</a></li>
                    </ul>
                    <ul>
                        <li><a href="form/?id=0">Add</a></li>
                    </ul>
                </div>
                <div class="content">
                    <div class="main-table">
                        <div class="row th">
                            <div>№ </div>
                            <div>Назва</div>
                        </div>
                        <c:forEach var="enterprise" items="${company}">
                            <div class="row td select">
                                <div></div>
                                <div>
                                    ${enterprise.getName()}
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>