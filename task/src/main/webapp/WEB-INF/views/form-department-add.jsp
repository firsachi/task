<%-- 
    Document   : form-department
    Created on : 26.08.2016, 15:43:06
    Author     : firsov
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><spring:message code="label.foma.title.add.department"/></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../../resources/css/forms.css">
    </head>
    <body>
        <div class="topic size-div">
            <spring:message code="label.foma.title.add.department"/>
        </div>
        <form:form modelAttribute="modelDepartment" method="POST" action="save" acceptCharset="UTF-8">
            <div>
                <form:hidden path="id"/>
            </div>
            <div>
                <form:label path="name"><spring:message code="label.title.table.department.name"/></form:label>
                <form:input path="name" required="true" pattern=""/>
            </div>
            <div>
                <form:label path="phone"><spring:message code="label.title.table.department.phone"/></form:label>
                <form:input path="phone" required="true" pattern=""/>
            </div>
            <div>
                <form:label path="fax"><spring:message code="label.title.table.department.fax"/></form:label>
                <form:input path="fax" required="true" pattern=""/>
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