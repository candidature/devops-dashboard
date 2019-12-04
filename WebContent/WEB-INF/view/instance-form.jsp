<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
   
<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp" %>
</head>
<body>

<div class="container">
	
	<div id="wrapper" align="center">
		<%@include file="header2.jsp" %>
		<div class="mt-5" id="header">
			<h2>Add a new instance of Devops Application ${tool.name}</h2>
		</div>
	</div>
	
	
	<div id="devops-form" class="mt-5">
		
		
		<form:form action="${pageContext.request.contextPath}/devops/tool/${tool.id}/instance/" modelAttribute="toolInstance" method="POST" autocomplete="off">
			<form:hidden path="id" />
			<div class="form-group">
				<label for="url">URL</label> 
				<form:input type="text" class="form-control" placeholder="<URL of Application(Tool)>" id="url" path="url" />
			</div>
			
			<div class="form-group">
				<label for="team">Created for Team (BU details)</label> 
				<form:input type="text" class="form-control" placeholder="<BU Details>" id="team" path="team" />
			</div>
			
			<div class="form-group">
				<label for="owner">BU's owners email ids</label> 
				<form:input type="text" class="form-control" placeholder="<Comman Seperated Email id of BU Owners>" id="owner" path="owner" />
			</div>
			
			
			<div class="form-group">
			
			
				<label for="domain">Domain</label> 
			
				
				<form:select class="form-control" id="domain" path="domain">
				    <form:options items="${domains}" />
				</form:select>

			</div>
			
			
			
			<div class="form-group">
				<label for="label">Label(s)</label> 
				<form:input type="text" class="form-control" placeholder="<Space Seperated List of labels>" id="label" path="label" />
			</div>
			
			
			<div class="form-group">
				<label for="command">Command to check health every 5 seconds(s) Exit 1: Failure, Exit 0: Success.</label> 
				<form:input type="text" class="form-control" placeholder="<Command in double quotes>" id="command" path="command" />
			</div>
			
			
			
			<input class="btn btn-primary" type="submit" value="Submit">
			
			<div style="clear; both;"></div>
			
			<div class="container">
				<p>
					<a href="${pageContext.request.contextPath}/devops/tool/${tool.id}/instances/">Back to Instance List</a>
				</p>
			</div>
		</form:form>
		
	</div>
</body>
</html>