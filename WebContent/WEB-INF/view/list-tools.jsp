<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Refernce file from our directory -->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>

	<div id = "wrapper">
		<div id="header">
			<h2>Welcome to DevOps Dashboard</h2>
		</div>
	</div>
	<div id="container">
	
	
		<!-- New Button -->
		<input type="button" value="Add Application" onclick="window.location.href='showFormForAddNewApplication'; return false;"
		class="add-button"
		/>
		
		<div id="content">
		<table>
		<tr>
			<th>Tool Name</th> <th>Purpose</th> <th>Supporting Team Email(s)</th><th>Team</th><th>Action</th><th>Add Instance</th>
		
		</tr>
		
		<c:forEach var="tool" items="${tools}">
			<!-- Construct url for update -->
			<c:url var="updateLink" value="/devops/showFormForToolUpdate">
				<c:param name="toolId" value="${tool.id}"/>
			</c:url>
			
			<c:url var="addInstanceLink" value="/devops/tool/${tool.id}/instance">
			</c:url>
			
			<tr>
				<td>${tool.name }</td>
				<td>${tool.purpose }</td>
				<td>${tool.supportedByEmails }</td>
				<td>${tool.teamName }</td>
				<td>
					<!-- display update link -->
					<a href="${updateLink}">Update</a>
				</td>
				
				<td>
					<!-- display update link -->
					<a href="${addInstanceLink}">Add an instance</a>
				</td>
				
				
			</tr>
			
		</c:forEach>
		</table>
		</div>		
	</div>


</body>
</html>