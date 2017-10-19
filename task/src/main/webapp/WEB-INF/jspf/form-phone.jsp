<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
				
				<div class="form-group">
                	<form:hidden path="id"/>
            	</div>
            	
            	<div class="form-group error-message">
            		<form:errors path="number" cssClass="text-danger" />
            	</div>
            	
            	<div class="form-group">
            		<spring:message code="label.phone.number" var="phoneNumber"/>
            		<form:label path="number">${ phoneNumber }</form:label>
            		<form:input path="number" placeholder="${ phoneNumber }"/>
            	</div>