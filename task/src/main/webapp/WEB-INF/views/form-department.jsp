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
        <title>${title}</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../../resources/css/forms.css">
    </head>
    <body>
        <div class="topic size-div">
            ${title}
        </div>
        <form:form modelAttribute="modelDepartment" method="POST" action="add" accept-charset="utf-8">
            <div>
                <form:hidden path="id"/>
            </div>
            <div>
                <form:label path="name">Назва</form:label>
                <form:input path="name" required="true" pattern=""/>
            </div>
            <div>
                <form:label path="phone">Телефон</form:label>
                <form:input path="phone" required="true" pattern=""/>
            </div>
            <div>
                <form:label path="fax">Факс</form:label>
                <form:input path="fax" required="true" pattern=""/>
            </div>
            <div class="buttons">
                <input type="submit" value="Виконати">
                <input type="reset" value="Очичтити">
                <input type="button" onclick="self.location.href='.';" value="Повернутися">
            </div>
        </form:form>
    </body>
</html>