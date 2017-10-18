<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

				<div class="form-group">
                	<form:hidden path="id"/>
            	</div>
            	
            	<div class="form-group">
                	<form:label path="name"><spring:message code="label.title.table.post.name"/></form:label>
                	<form:input path="name" required="true" pattern=""/>
            	</div>
            	
            	<div class="form-group">
                	<form:label path="heft"><spring:message code="label.title.table.post.heft"/></form:label>
                	<form:select path="heft" items="${HEFT_POST}"/>
            	</div>