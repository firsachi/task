<%-- 
    Document   : tasks
    Created on : Aug 17, 2016, 2:46:05 PM
    Author     : firsov
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            
        </style>
    </head>
    <body>
        <h1>Hello hibernate!</h1>
        <div style="display: table; width: 100%;">
            
        
        <c:forEach var="values" items="${val}">
            <div style="display: table-row">
                <div style="display: table-cell">
                    ${values.getId()} 
                </div>
                <div style="display: table-cell">
                    ${values.getSurname()} 
                    ${values.getName()} 
                    ${values.getPatronymic()}
                </div>
             
            </div>
            
        </c:forEach>
        </div>
    </body>
</html>
