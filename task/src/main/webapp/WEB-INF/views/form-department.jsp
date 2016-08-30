<%-- 
    Document   : form-department
    Created on : 26.08.2016, 15:43:06
    Author     : firsov
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Department</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../../resources/css/forms.css">
    </head>
    <body>
        <div class="topic size-div">
             
        </div>
        <form:form modelAttribute="department" method="POST" action="add" accept-charset="utf-8">
            <div>
               <form:input type="hidden" path="id" value="" readonly="true" />
            </div>
            <div>
                <form:label path="name">Name</form:label>
                <form:input path="name" value="" required="true" pattern=""/>
            </div>
            <div>
                <form:label path="phone">Phone</form:label>
                <form:input path="phone" value="" required="true" pattern=""/>
            </div>
            <div>
                <form:label path="fax">Fax</form:label>
                <form:input path="fax" value="" required="true" pattern=""/>
            </div>
            <div class="buttons">
                <input type="submit">
                <input type="reset">
                <input type="button" onclick="self.location.href='.';">
            </div>
        </form:form>
    </body>
</html>