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
			<h2>List of instances</h2>
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
			<th>URL</th> <th>Team</th> <th>Owner(s)</th> <th>App Name</th><th>Action</th>
		
		</tr>
		
		<c:forEach var="toolInstance" items="${toolInstances}">
			<!-- Construct url for update -->
			<c:url var="updateLink" value="/devops/showFormForToolUpdate">
				<c:param name="toolId" value="${toolInstance.id}"/>
			</c:url>
			
			
			<tr>
				<td>${toolInstance.url }</td>
				<td>${toolInstance.team }</td>
				<td>${toolInstance.owner }</td>
				<td>${toolInstance.tool.name }</td>
				<td>
					<!-- display update link -->
					<a href="${updateLink}">Update</a>
				</td>
				
			</tr>
			
		</c:forEach>
		</table>
		
			<p>
				<a href="${pageContext.request.contextPath}/devops/tools">Back to Applications List</a>
			</p>
			
		</div>		
	</div>


</body>
</html>