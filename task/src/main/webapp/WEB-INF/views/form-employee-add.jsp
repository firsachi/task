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
        <title><spring:message code="label.foma.title.add.employee"/></title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../../resources/css/forms.css">
    </head>
    <body>
        <div class="topic size-div">
            <spring:message code="label.foma.title.add.employee"/>
        </div>
            <form:form modelAttribute="modelEmployee" method="POST" action="save" acceptCharset="UTF-8">
                <form:hidden path="id"/>
            </div>
            <div>
                <form:label path="surname"><spring:message code="label.form.employee.surname"/></form:label>
                <form:input path="surname" required="true" pattern=""/>
            </div>
            <div>
                <form:label path="name"><spring:message code="label.from.employee.name"/></form:label> 
                <form:input path="name" required="true" pattern=""/>
            </div>
            <div>
                <form:label path="patronymic"><spring:message code="label.form.employee.patronymic"/></form:label> 
                <form:input path="patronymic" required="true" pattern=""/>
            </div>
           <div>
               <form:label path="enterprise"><spring:message code="label.title.table.employee.company"/></form:label>
                <form:select path="enterprise" class="no-button" items="${modelEmployee.getListCompany()}" itemValue="id" itemLabel="name"/> 
            </div>
            <div>
                <form:label path="department"><spring:message code="label.title.table.employee.department"/></form:label>
                <form:select path="department"  >
                    <form:options items="${modelEmployee.getListDeapartment()}" itemValue="id" itemLabel="name"/>
                </form:select>  
            </div>
            <div>
            <form:label path="post"><spring:message code="label.title.table.employee.post"/></form:label>
                <form:select path="post" items="${modelEmployee.getListPost()}" itemValue="id" itemLabel="name"/>
            </div>
            <div>
                <form:label path="numberRoom"><spring:message code="label.title.table.employee.room"/></form:label> 
                <form:select path="numberRoom" items="${modelEmployee.getListRoom()}" itemValue="id" itemLabel="numberRoom"/>
            </div>
            <div>
                <form:label path="phone"><spring:message code="label.title.table.employee.number"/></form:label>
                <form:select path="phone" items="${modelEmployee.getListPhone()}" itemValue="id" itemLabel="number"/>
            </div>
            <div>
                <form:label path="email"><spring:message code="label.title.table.employee.email"/></form:label> 
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
