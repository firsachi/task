<%-- 
    Document   : form-employee
    Created on : Aug 19, 2016, 10:35:16 AM
    Author     : firsov
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            
        </div>
        <form>
            <div>
                Surname
                <input type="text" name="surname" value="${employee.getSurname()}"
            </div>
            <div>
                name
                <input type="text" name="name" value="${employee.getName()}">
            </div>
            <div>
                Patronymic
                <input type="text" name="patronymic" value="${employee.getPatronymic()}"
             </div>
            
        </form>
    </body>
</html>
