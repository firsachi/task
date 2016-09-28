<%-- 
    Document   : form-post
    Created on : Aug 23, 2016, 3:51:50 PM
    Author     : firsov
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><spring:message code="label.foma.title.edit.post"/></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../../resources/css/forms.css">
    </head>
    <body>
        <div class="topic size-div">
            <spring:message code="label.foma.title.edit.post"/>
        </div>
        <form:form modelAttribute="modelPost" method="POST" action="save" acceptCharset="UTF-8">
            <div>
                <form:hidden path="id"/>
            </div>
            <div>
                <form:label path="name"><spring:message code="label.title.table.post.name"/></form:label>
                <form:input path="name" required="true" pattern=""/>
            </div>
            <div>
                <form:label path="heft"><spring:message code="label.title.table.post.heft"/></form:label>
                <form:select path="heft" items="${modelPost.getHEFT_POST()}"/>
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
