<%-- 
    Document   : employee
    Created on : Aug 20, 2016, 9:08:04 AM
    Author     : firsachi
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../resources/css/page-private.css">
    </head>
    <body>
        <div style="display: table; width: 100%">
            <div style="display: table-row">
                <div class="menu">
                    <ul>
                        <li><a href="">Users</a></li>
                        <li><a href="">Post</a></li>
                        <li><a href="">Department</a></li>
                        <li><a href="">Enterprise</a></li>
                    </ul>
                    <ul>
                        <li><a href="forma-user.html">Add</a></li>
                    </ul>
                </div>
                <div class="content">
                    <div class="main-table">
                        <div class="row th">
                            <div>№ телефону</div>
                            <div>ПІБ працівника</div>
                            <div>Підприємство</div>
                            <div>Відділ</div>
                            <div>Посада</div>
                            <div>Електронна адреса</div>
                        </div>
                        <c:forEach var="employee" items="${employees}">
                            <div class="row td select">
                                <div><a href="form/?id=${employee.getId()}">skl</a></div>
                                <div>
                                    ${employee.getSurname()} 
                                    ${employee.getName()} 
                                    ${employee.getPatronymic()}
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
