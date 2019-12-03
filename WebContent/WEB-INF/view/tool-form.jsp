<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html>
<html>

<%@include file="head.jsp" %>

<body>
<div class="container">

	<%@include file="header2.jsp" %>
	<c:choose>
	    <c:when test="${kind == 'EDIT'}">
	        <div id="wrapper" align="center">
				
				<div class="mt-5" id="header">
				<h2>EDIT Devops Application Form</h2>
			</div>
	</div>
	    </c:when>    
	    <c:otherwise>
	        <div id="wrapper" align="center">
				<div class="mt-5" id="header">
					<h2>Add new Devops Application Form</h2>
				</div>
			</div>	
	    </c:otherwise>
	</c:choose>


	<div id="devops-form">
	
		<form:form action="saveNewApplication" modelAttribute="tool" method="POST" autocomplete="off">
		
			<!-- Need to associate this data with existing tool  -->
			
			<form:hidden path="id" />
	
			<div class="form-group">
				<label for="name">Name</label> 
				
				
				<c:choose>
				    <c:when test="${kind == 'EDIT'}">
				        <form:input type="text" class="form-control" placeholder="<Name of Application(Tool)>" 
							readOnly="true"
							id="name" path="name" />
				    </c:when>    
				    <c:otherwise>
				        <form:input type="text" class="form-control" placeholder="<Name of Application(Tool)>" 
							id="name" path="name" />
				    </c:otherwise>
				</c:choose>

				
			</div>
			
			<div class="form-group">
				<label for="purpose">Purpose</label> 
				<form:input type="text" class="form-control" placeholder="<Purpose>" id="purpose" path="purpose" />
			</div>
			
			
			<div class="form-group">
				<label for="supportedByEmails">Supporting Team Email(s)</label> 
				<form:input type="text" class="form-control" placeholder="<Comma Seperated Email id of supporting teams>" id="supportedByEmails" path="supportedByEmails" />
			</div>
			
			
			<div class="form-group">
				<label for="teamName">Team Name</label> 
				<form:input type="text" class="form-control" placeholder="<Team Name>" id="teamName" path="teamName" />
			</div>
			
			<div class="form-group">
			
			
				<label for="tier">Tier</label> 
			
				
				<form:select class="form-control" id="tier" path="tier">
				    <form:options items="${tiers}" />
				</form:select>

			</div>

			
			<input class="btn btn-primary" type="submit" value="Submit">
			
			<div style="clear; both;"></div>
			<p>
				<a href="${pageContext.request.contextPath}/devops/tools">Back to Applications List</a>
			</p>
		</form:form>
		
	</div>
	
	</div>
</body>
</html>