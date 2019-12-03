<nav class="navbar navbar-expand-lg navbar-default">
  


    <div class="collapse navbar-collapse" id="navbarCollapse">
        <div class="navbar-nav">
            
            
            
            
            <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="${pageContext.request.contextPath}/devops/tools" id="navbarDropdown" 
		        role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          Applications
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
		          <a class="dropdown-item" href="${pageContext.request.contextPath}/devops/tools">List</a>
		          <a class="dropdown-item" href="${pageContext.request.contextPath}/devops/showFormForAddNewApplication">Add</a>
           </li>
            
            
            <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="${pageContext.request.contextPath}/devops/instances" id="navbarDropdown" 
		        role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          Instances
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
		          <a class="dropdown-item" href="${pageContext.request.contextPath}/devops/instances">List</a>
		          
		          
		          <c:forEach items="${tools}" var="tool">
					<a class="dropdown-item" href="${pageContext.request.contextPath}/devops/tool/${tool.id}/instance"> ${tool.name}- Add Instance </a>
				  </c:forEach>
				
           </li>
           
           
           
           <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="${pageContext.request.contextPath}/devops/instances" id="navbarDropdown" 
		        role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          Announcements
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
		          <a class="dropdown-item" href="${pageContext.request.contextPath}/devops/announcements">List</a>
		          <a class="dropdown-item" href="${pageContext.request.contextPath}/devops/announcement">Create New Global Announcement </a>
           </li>
           
           
           
           <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" 
		        role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          Reports
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
		          <a class="dropdown-item" href="#">Application(s)</a>
		          <a class="dropdown-item" href="#">Instance(s)</a>
		          <a class="dropdown-item" href="#">announcements(s)</a>
           </li>
	    </div>
	    
	    
        <div class="navbar-nav ml-auto">
        	<li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" 
		        role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          Profile
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
		          
		          
		          <c:if test="${pageContext.request.userPrincipal.name == null}">
						<a class="dropdown-item" href="${pageContext.request.contextPath}/login">Login </a>

					</c:if>
					
					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<div class="dropdown-item"  style="font-size:15px"> Hello <b><c:out value="${pageContext.request.remoteUser}"/></b>
						 </div>
						<a class="dropdown-item"  href="${pageContext.request.contextPath}/logout">Logout</a>	
					</c:if>
           </li>
        </div>
    </div>
</nav>