<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
				
				<div class="form-group">
                	<form:hidden path="id"/>
            	</div>
            	
            	<div class="form-group error-message">
            		<form:errors path="numberRoom" cssClass="text-danger" />
            	</div>
            	
            	<div class="form-group">
            		<spring:message code="label.room.number" var="phoneRoom"/>
            		<form:label path="numberRoom">${ phoneRoom }</form:label>
            		<form:input path="numberRoom" placeholder="${ phoneRoom }"/>
            	</div>