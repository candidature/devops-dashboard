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
		<%@include file="header2.jsp" %>
		<div class="mt-5" id="header">
			<h2>List of ALL instances </h2>
		</div>
		<div class="container-fluid mt-2" align="right" >
			<a href="instance/" class="btn btn-primary" role="button">Add Instance</a>
		</div>
	</div>
	
	
	
	
	<div id="devops-form" class="mt-5" align="center">
	
		
		<div id="content">
		

		<table>
		<tr>
			<th>URL</th> <th>Team</th> <th>Owner(s)</th><th>Application</th><th>Update</th><th>DELETE</th>
		</tr>
		
		<c:forEach var="toolInstance" items="${toolInstances}">
			<!-- Construct url for update -->
			<c:url var="updateLink" value="/devops/tool/${toolInstance.tool.id}/instance/${toolInstance.id}">

			</c:url>
			
			<c:url var="delInsrance" value="/devops/tool/${toolInstance.tool.id}/instance/${toolInstance.id}/delete">
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
				
				
				<td>
					<!-- display add link -->
					
					<a onclick="if (!(confirm('Are you Sure, you want to delete this??'))) return false" class="btn btn-danger"   href="${delInsrance}" >DELETE</a>
					
				</td>
				
				
			</tr>
			
		</c:forEach>
		</table>
		
			<div class="container">
				<p>
					<a href="${pageContext.request.contextPath}/devops/tools">Back to Applications List</a>
				</p>
			</div>
			
		</div>		
	</div>

</div>
</body>
</html>