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
		<%@include file="header.jsp" %>
		<div class="mt-5" id="header">
			<h2>Add New Announcment</h2>
		</div>
	</div>
	
	
	<div id="devops-form" class="mt-3">
	
		<form:form action="${pageContext.request.contextPath}/devops/announcement" modelAttribute="announcement" method="POST" autocomplete="off">
			<form:hidden path="id" />
			<div class="form-group">
				<label for="subject"><bold>Subject</bold></label> 
				<form:input type="text" class="form-control" placeholder="<Announcement Subject>" id="subject" path="subject" />
			</div>
			
			<div class="form-group">
				<label for="details">Announcement Details</label> 
				<form:input type="text" class="form-control" placeholder="<Announcement Details>" id="details" path="details" />
			</div>
			
			<div class="form-group">
				<label for="supportedByEmails">Email ids of supporting team members/mailing list(s):</label> 
				<form:input type="owner" class="form-control" placeholder="<Comman Seperated Email of Support Team(s)>" id="supportedByEmails" path="supportedByEmails" />
			</div>
			
			<div class="form-group">
				<label for="kind">Kind</label> 
				<form:select class="form-control" id="kind" path="kind" onchange="getValue(this);">
				    <form:options items="${kinds}" />
				</form:select>
			</div>
			
			
			<div  id="mySelect" class="form-group">
				<label for="startDate">Start Date</label>		
				<form:input id="startDatePicker" class= "date" path="startDate" />
				<!--<form:input id="startTimePicker"  path="startDate" />-->
			</div>
			
			<div class="form-group">
				<label for="criticality">Criticality</label> 
				<form:select class="form-control" id="criticality" path="criticality">
				    <form:options items="${criticalities}" />
				</form:select>
			</div>
	
			<div  class="form-group">
				<label for="endDate">Tentative End Date</label>		
				<form:input id="endDatePicker" class= "date" path="endDate" />
				<!--<form:input id="endTimePicker"  path="endDate" />-->
			</div>
			
			
			<div  class="form-group">
				<label for="active">Active</label>		
				<form:checkbox path="active"  />
			</div>
			
			
			
			
			
			
			<c:if test="${globalAnnouncement[0].subject != null }">
			<script>
				to_left();
				to_right();
			</script>
			
			
			<div class="main slide-right">
				<c:forEach var="gAnnouncement" items="${globalAnnouncement}">
					<h4>${gAnnouncement.subject} </h4>
					<h6>${gAnnouncement.details} </h6>
					<hr>
				</c:forEach>
			</div>
			</c:if>
			
			
			
			
			
			
			
			<input class="btn btn-primary" type="submit" value="Submit">
			
			<div style="clear; both;"></div>
			
		</form:form>
		
	</div>
</body>
</html>