<%-- 
    Document   : form-employee
    Created on : Aug 19, 2016, 10:35:16 AM
    Author     : firsov
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
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
                <form:hidden path="id"/>
            </div>
            <div>
                <form:label path="surname">Surname</form:label>
                <form:input path="surname" required="true" pattern=""/>
            </div>
            <div>
                <form:label path="name">Name</form:label> 
                <form:input path="name" required="true" pattern=""/>
            </div>
            <div>
                <form:label path="patronymic">Patronymic</form:label> 
                <form:input path="patronymic" required="true" pattern=""/>
            </div>
           <div>
                <form:label path="enterprise">Підприємстао</form:label>
                <form:select path="enterprise" class="no-button" items="${modelEmployee.getListCompany()}" itemValue="id" itemLabel="name"/> 
            </div>
            <div>
                <form:label path="department">Відділ</form:label>
                <form:select path="department"  >
                    <form:options items="${modelEmployee.getListDeapartment()}" itemValue="id" itemLabel="name"/>
                </form:select>  
            </div>
            <div>
                <form:label path="post">Посада</form:label>
                <form:select path="post" items="${modelEmployee.getListPost()}" itemValue="id" itemLabel="name"/>
            </div>
            <div>
                <form:label path="numberRoom">Кімната</form:label> 
                <form:select path="numberRoom" items="${modelEmployee.getListRoom()}" itemValue="id" itemLabel="numberRoom"/>
            </div>
            <div>
                <form:label path="phone">Телефон</form:label>
                <form:select path="phone" items="${modelEmployee.getListPhone()}" itemValue="id" itemLabel="number"/>
            </div>
            <div>
                <form:label path="email">Електорона пошта</form:label> 
                <form:input path="email"/>
            </div>
            <div class="buttons">
               <input type="submit" value="Виконати">
                <input type="reset" value="Скасувати">
                <input type="button" onclick="self.location.href='.';" value="Повернутися">
            </div>
        </form:form>
    </body>
</html>
