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
        <%@include file="../jspf/map-file.jspf" %>   
    </head>
    <body>
    	<div class="container">
    		<div class="page-header">
    			<h2><spring:message code="label.company.edit.title"/></h2>
    		</div>
  			<form:form modelAttribute="enterprise" method="POST" action="save" acceptCharset="UTF-8" class="form-horizontal"  role="form">
            	<div class="form-group">
               		<form:hidden path="id"/>
            	</div>
            	<div class="form-group">
               		<form:label path="name" class="col-sm-2 control-label" ><spring:message code="label.company.name" /></form:label>
               		<div class="col-sm-10">
      					<form:input path="name" required="true" pattern="" class="form-control"/>
    				</div>
            	</div>
            	<div class="form-group">
            		<div class="col-sm-offset-2 col-sm-10">
            			<button type="button" onclick="self.location.href='.';" class="btn btn-default"><spring:message code="label.buttonBack"/></button>
            			<button type="reset" class="btn btn-default"><spring:message code="label.buttonReset"/></button>
            			<button type="submit" class="btn btn-default"><spring:message code="label.buttonSubmit"/></button>
    				</div>
            	</div>
        	</form:form>
        </div>
    </body>
</html>