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
			<h2>Add a new instance of Devops Application ${tool.name}</h2>
		</div>
	</div>
	

	<div id="devops-form">
	
		<form:form action="${pageContext.request.contextPath}/devops/tool/${tool.id}/instance" modelAttribute="toolInstance" method="POST" autocomplete="off">
			<div class="form-group">
				<label for="url">URL</label> 
				<form:input type="text" class="form-control" placeholder="<URL of Application(Tool)>" id="url" path="url" />
			</div>
			
			<div class="form-group">
				<label for="team">Created for Team (BU details)</label> 
				<form:input type="text" class="form-control" placeholder="<BU Details>" id="team" path="team" />
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