<%@ page  pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

				<div class="form-group">
                	<form:hidden path="id"/>
            	</div>
            	
            	<div class="form-group">
                	<form:label path="name"><spring:message code="label.title.table.department.name"/></form:label>
                	<form:input path="name" required="true" pattern=""/>
            	</div>
            	
            	<div class="form-group">
                	<form:label path="phone"><spring:message code="label.title.table.department.phone"/></form:label>
                	<form:input path="phone" required="true" pattern=""/>
            	</div>
            	
            	<div class="form-group">
                	<form:label path="fax"><spring:message code="label.title.table.department.fax"/></form:label>
                	<form:input path="fax" required="true" pattern=""/>
            	</div>