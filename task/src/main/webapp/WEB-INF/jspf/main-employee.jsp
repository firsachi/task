<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

				<div class="form-group">
                	<form:hidden path="id"/>
            	</div>
            	
            	<div class="form-group">
                	<form:label path="surname"><spring:message code="label.form.employee.surname"/></form:label>
                	<form:input path="surname" required="true" pattern=""/>
            	</div>
            	
            	<div class="form-group">
                	<form:label path="name"><spring:message code="label.from.employee.name"/></form:label> 
                	<form:input path="name" required="true" pattern=""/>
            	</div>
            	
            	<div class="form-group">
                	<form:label path="patronymic"><spring:message code="label.form.employee.patronymic"/></form:label> 
                	<form:input path="patronymic" required="true" pattern=""/>
            	</div>
            	
           		<div class="form-group">
               		<form:label path="idEnterprise"><spring:message code="label.title.table.employee.company"/></form:label>
                	<form:select path="idEnterprise" items="${listCompany}" itemValue="id" itemLabel="name"/> 
            	</div>
            	
            	<div class="form-group">
                	<form:label path="idDepartment"><spring:message code="label.title.table.employee.department"/></form:label>
                	<form:select path="idDepartment"  items="${listDepartment}" itemValue="id" itemLabel="name" />
            	</div>
            	         	
            	<div class="form-group">
            		<form:label path="idPost"><spring:message code="label.title.table.employee.post"/></form:label>
                	<form:select path="idPost" items="${listPost}" itemValue="id" itemLabel="name"/>
            	</div>
            	
            	<div class="form-group">
                	<form:label path="idRoom"><spring:message code="label.title.table.employee.room"/></form:label> 
                	<form:select path="idRoom" items="${listRoom}" itemValue="id" itemLabel="numberRoom"/>
            	</div>
            	
            	<div class="form-group">
                	<form:label path="idPhone"><spring:message code="label.title.table.employee.number"/></form:label>
                	<form:select path="idPhone" items="${listPhone}" itemValue="id" itemLabel="number"/>
            	</div>
            	
            	<div class="form-group">
                	<form:label path="email"><spring:message code="label.title.table.employee.email"/></form:label> 
                	<form:input path="email"/>
            	</div>
            	