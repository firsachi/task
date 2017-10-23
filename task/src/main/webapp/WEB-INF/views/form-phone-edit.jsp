<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<spring:message code="label.phone.addTitle" var="addTitle"/>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>${ addTitle }</title>
		<%@include file="../jspf/map-main-css.jspf"%>
	</head>
	
	<body>
		<div class="box-form">
    		<div class="page-header">
            	<h2>${ addTitle }</h2>
        	</div>
        	<form:form class="form-horisontal" modelAttribute="phone" method="POST" action="../save" acceptCharset="UTF-8">
        		<%@include file="../jspf/form-phone.jsp" %>
        		<c:set value="self.location.href='..';" var="backPage" />
        		<%@include file="../jspf/button-form.jspf" %>
        	</form:form>
        </div>
	</body>
</html>