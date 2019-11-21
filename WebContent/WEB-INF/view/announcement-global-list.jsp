<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
			<h2>List of Global Announcements</h2>
		</div>
		<div class="container-fluid mt-2" align="right" >
			<a href="${pageContext.request.contextPath}/devops/announcement" class="btn btn-primary" role="button">Add New Announcement</a>
		</div>
	</div>
	
	
	
	
	<div id="devops-form" class="mt-5" align="center">
			
		<div id="content">
		
		<table>
		<tr>
			<th>Subject</th> <th>Details</th> <th>Owner(s)</th><th>Start Date</th><th>End Date</th><th>ACTION</th>
		</tr>
		
		<c:forEach var="announcement" items="${announcements}">
		
		
			<!-- Construct url for update -->
			<c:url var="updateLink" value="/devops/announcement/${announcement.id}">

			</c:url>
			<c:url var="deleteLink" value="/devops/announcement/${announcement.id}/delete">

			</c:url>
			
			<tr>
				<td>${announcement.subject}</td>
				<td>${announcement.details }</td>
				<td>${announcement.supportedByEmails }</td>
				<td>${announcement.startDate }</td>
				<td>${announcement.endDate }</td>
				<td>
					<!-- display update link -->
					<a href="${updateLink}">Update</a>
					|
					<a href="${deleteLink}">Delete</a>
				</td>
				
			</tr>
			
		</c:forEach>
		</table>
		
			
			
		</div>		
	</div>

</div>
</body>
</html>