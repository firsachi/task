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
        <title>User</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../../resources/css/forms.css">
    </head>
    <body>
        <div class="topic size-div">
            <c:choose>
                <c:when test="${employee != null}">Edit</c:when>
                <c:otherwise>New employee</c:otherwise>
            </c:choose>
        </div>
        <form >
            <div>
                Surname 
                <input type="text" name="surname" value="${employee.getSurname()}">
            </div>
            <div>
                Name 
                <input type="text" name="name" value="${employee.getName()} ">
            </div>
            <div>
                Patronymic 
                <input type="text" name="patronymic" value="${employee.getPatronymic()} ">
            </div>
            <div>
                Enterprise
                <a href="">+</a>
                <select>
                    <option>One enterprise</option>
                </select>
            </div>
            <div>
                Department
                <a href="">+</a>
                <select>
                    <option>One department</option>
                </select>   
            </div>
            <div>
                Post
                <a href="">+</a>
                <select>
                    <c:forEach var="post" items="${listPost}">
                        <option>${post.getName()}</option>
                    </c:forEach>
                    
                </select>
            </div>
            <div>
                Room 
                <input type="text" name="room" value="">
            </div>
            <div>
                Phone
                <a href="">+</a>
                <select>
                    <c:forEach var="phone" items="${phones}">
                        <option>${phone.getNumber()}</option>
                    </c:forEach>
                    
                </select>
            </div>
            <div>
                Email 
                <input type="text" name="email" value="">
            </div>
            <div class="buttons">
                <input type="submit">
                <input type="reset">
                <input onclick="self.location.href='.';">
            </div>
        </form>
    </body>
</html>
