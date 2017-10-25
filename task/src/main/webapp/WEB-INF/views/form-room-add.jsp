<%-- 
    Document   : form-company
    Created on : 23.10.2017
    Author     : firsachi
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<spring:message code="label.room.addTitle" var="title" />
		<title>${ title }</title>
		<%@include file="../jspf/map-main-css.jspf"%> 
	</head>
	<body>
		<div class="box-form">
			<div class="page-header">
            	<h2>${ title }</h2>
        	</div>
        	<form:form class="form-horisontal" modelAttribute="room" method="POST" action="save" acceptCharset="UTF-8">
        		<%@include file="../jspf/main-room.jsp" %>
        		<c:set value="self.location.href='.';" var="backPage" />
				<%@include file="../jspf/button-form.jspf" %>
        	</form:form>
		</div>
	</body>
</html>