<%-- 
    Document   : form-employee
    Created on : Aug 19, 2016, 10:35:16 AM
    Author     : firsov
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
        <form:form modelAttribute="modelEmployee" method="POST" action="add" accept-charset="utf-8">
                <form:hidden path="id" value="${modelEmployee.getId()}"/>
            </div>
            <div>
                <form:label path="surname">Surname</form:label>
                <form:input path="surname" value="${modelEmployee.getSurname()}" required="true" pattern=""/>
            </div>
            <div>
                <form:label path="name">Name</form:label> 
                <form:input path="name" value="${modelEmployee.getName()}" required="true" pattern=""/>
            </div>
            <div>
                <form:label path="patronymic">Patronymic</form:label> 
                <form:input type="text" path="patronymic" value="${modelEmployee.getPatronymic()}" required="true" pattern=""/>
            </div>
           <div>
                <form:label path="enterprise">Enterprise</form:label>
                <form:select path="enterprise" class="no-button" items="${listCompany}" itemValue="id" itemLabel="name"/> 
            </div>
            <div>
                <form:label path="department">Department</form:label>
                <form:select path="department" class="no-button" >
                    <form:options items="${listDepartment}" itemValue="id" itemLabel="name"/>
                </form:select>  
            </div>
            <div>
                <form:label path="post">Post</form:label>
                <form:select path="post" class="no-button" items="${listPost}" itemValue="id" itemLabel="name"/>
            </div>
            <div>
                <form:label path="numberRoom">Room</form:label> 
                <form:select path="numberRoom" items="${numberRoom}" itemValue="id" itemLabel="numberRoom"/>
            </div>
            <div>
                <form:label path="phone">Phone</form:label>
                <form:select path="phone" items="${listPhone}" itemValue="id" itemLabel="number"/>
            </div>
            <div>
                <form:label path="email">Email</form:label> 
                <form:input type="text" path="email" value="${modelEmployee.getEmail()}"/>
            </div>
            <div class="buttons">
                <input type="submit">
                <input type="reset">
                <input onclick="self.location.href='.';">
            </div>
        </form:form>
    </body>
</html>
