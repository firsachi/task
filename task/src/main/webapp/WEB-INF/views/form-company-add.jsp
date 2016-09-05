<%-- 
    Document   : form-company
    Created on : Aug 21, 2016, 10:31:57 PM
    Author     : firsachi
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <title><spring:message code="label.company.new.title"/></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../../resources/css/forms.css">   
    </head>
    <body>
       <div class="topic size-div">
            <spring:message code="label.company.new.title"/>
        </div>
        <form:form modelAttribute="enterprise" method="POST" action="save" accept-charset="utf-8">
            <div>
                <form:hidden path="id"/>
            </div>
            <div>
                <form:label path="name"><spring:message code="label.company.name"/></form:label>
                <form:input path="name" required="true" pattern=""/>
            </div>
            <div class="buttons">
                <input type="submit" value="<spring:message code="label.buttonSubmit"/>">
                <input type="reset" value="<spring:message code="label.buttonReset"/>">
                <input type="button" onclick="self.location.href='.';" 
                       value="Повернутися" value="<spring:message code="label.buttonBack"/>" >
            </div>
        </form:form>
    </body>
</html>