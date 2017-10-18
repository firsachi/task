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
        <spring:message code="label.foma.title.edit.post" var="postTitle"/>
        <title>${ postTitle }</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="../jspf/map-main-css.jspf"%>
    </head>
    <body>
    	<div class="box-form">
    		<div class="page-header">
            	<h2>${ postTitle }</h2>
        	</div>
        	<form:form class="form-horisontal" modelAttribute="modelPost" method="POST" action="save" acceptCharset="UTF-8">
            	<%@include file="../jspf/main-post.jsp" %>
            	<%@include file="../jspf/button-form.jspf" %>
        	</form:form>
    	</div>
    </body>
</html>
