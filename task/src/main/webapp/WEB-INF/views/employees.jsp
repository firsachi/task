<%-- 
    Document   : employee
    Created on : Aug 20, 2016, 9:08:04 AM
    Author     : firsachi
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Employee</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../resources/css/page-private.css">
    </head>
    <body>
        <div class="topic">
            <a class="selected" href="./">Employee</a>
            <a href="../post/">Post</a>
            <a href="../department/">Department</a>
            <a href="../company/">Enterprise</a>
            <a class="add" href="form?id=0">+</a>
        </div>
        <div class="table-div">
            <div class="row-div th">
                <div>№ телефону</div>
                <div>ПІБ працівника</div>
                <div>Підприємство</div>
                <div>Відділ</div>
                <div>Посада</div>
                <div>Електронна адреса</div>
            </div>
            <c:forEach var="employee" items="${employees}">
                <div class="row-div td">
                    <div><a href="form/?id=${employee.getId()}">skl</a></div>
                    <div>
                        <a href="form/?id=${employee.getId()}">
                            ${employee.getSurname()} 
                            ${employee.getName()} 
                            ${employee.getPatronymic()}
                        </a>
                    </div>
                    <div>
                        1
                    </div>
                    <div>
                        1
                    </div>
                    <div>
                        1
                    </div>
                    <div>
                        1
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
