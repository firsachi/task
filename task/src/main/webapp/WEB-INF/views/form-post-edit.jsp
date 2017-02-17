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
        <%@include file="../jspf/map-main-css.jspf"%>
    </head>
    <body>
    	<div class="box-form">
    		<div class="page-header">
            	<h2><spring:message code="label.foma.title.edit.post"/></h2>
        	</div>
        	<form:form class="form-horisontal" modelAttribute="modelPost" method="POST" action="save" acceptCharset="UTF-8">
            	<div class="form-group">
                	<form:hidden path="id"/>
            	</div>
            	<div class="form-group">
                	<form:label path="name"><spring:message code="label.title.table.post.name"/></form:label>
                	<form:input path="name" required="true" pattern=""/>
            	</div>
            	<div class="form-group">
                	<form:label path="heft"><spring:message code="label.title.table.post.heft"/></form:label>
                	<form:select path="heft" items="${modelPost.getHEFT_POST()}"/>
            	</div>
            	<%@include file="../jspf/button-form.jspf" %>
        	</form:form>
    	</div>
    </body>
</html>
