<%-- 
    Document   : form-company
    Created on : Aug 21, 2016, 10:31:57 PM
    Author     : firsachi
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <title>Enterprise</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../resources/css/forms.css">   
    </head>
    <body>
       <div class="topic size-div">
            <c:choose>
                <c:when test="${enterprise.getId() != null}">Edit enterprise</c:when>
                <c:otherwise>New enterprise</c:otherwise>
            </c:choose>
        </div>
        <form:form modelAttribute="enterprise" method="POST" action="add" accept-charset="utf-8">
            <div>
               <form:input type="hidden" path="id" value="${enterprise.getId()}" readonly="true" />
            </div>
            <div>
                <form:label path="name">Name</form:label>
                <form:input path="name" value="${enterprise.getName()}" required="true" pattern=""/>
            </div>
            <div class="buttons">
                <input type="submit">
                <input type="reset">
                <input type="button" onclick="self.location.href='.';" value="Повернутися">
            </div>
        </form:form>
    </body>
</html>