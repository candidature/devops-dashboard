<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Refernce file from our directory -->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />



<title>Insert title here</title>
</head>

<body>
	<div id="wrapper" align="center">
		<div id="header">
			<h2>Add new Devops Application Form</h2>
		</div>
	</div>
	

	<div id="devops-form">
	
		<form:form action="saveNewApplication" modelAttribute="tool" method="POST" autocomplete="off">
			<div class="form-group">
				<label for="name">Name</label> 
				<form:input type="text" class="form-control" placeholder="<Name of Application(Tool)>" id="name" path="name" />
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
				<form:input type="text" class="form-control" placeholder="<tier>" id="tier" path="tier" />
			</div>

			
			<input class="btn btn-primary" type="submit" value="Submit">
			
			<div style="clear; both;"></div>
			<p>
				<a href="${pageContext.request.contextPath}/devops/tools">Back to Applications List</a>
			</p>
		</form:form>
		
	</div>
	
	
</body>
</html>