<%-- 
    Document   : form-post
    Created on : Aug 23, 2016, 3:51:50 PM
    Author     : firsov
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>${action}</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../resources/css/forms.css">
    </head>
    <body>
       <div class="topic size-div">
            ${action}
        </div>
        <form:form modelAttribute="post" method="POST" action="add" accept-charset="utf-8">
            <div>
               <form:input type="hidden" path="id" value="${post.getId()}" readonly="true" />
            </div>
            <div>
                <form:label path="name">Name</form:label>
                <form:input path="name" value="${post.getName()}" required="true" pattern=""/>
            </div>
            <div class="buttons">
                <input type="submit">
                <input type="reset">
                <input type="button" onclick="self.location.href='.';" value="Повернутися">
            </div>
        </form:form>
    </body>
</html>