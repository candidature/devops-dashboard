<nav class="navbar navbar-custom navbar-expand-lg">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  
  <ul class="nav navbar-nav">
  
  <li>
  	<a class="mr-2 btn-white" href="${pageContext.request.contextPath}/devops/tools">Home </a>
  </li>
   
  <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
  	<div class="container">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      
    	<li>
    		<a class="mr-2 btn-white" href="${pageContext.request.contextPath}/devops/showFormForAddNewApplication">Add Application </a>
		</li>
		
		<li>
    		<a class="mr-2 btn-white" href="${pageContext.request.contextPath}/devops/announcements">Announcement </a>
		</li>
		
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<li>
				<a class="btn-white" href="${pageContext.request.contextPath}/logout">Logout</a>
				
			</li>
			<li>
				<div class="btn-white" style="font-size:15px"> Hello <b><c:out value="${pageContext.request.remoteUser}"/></b> </div>
			</li>
		</c:if>
		<c:if test="${pageContext.request.userPrincipal.name == null}">
			<li>
				<a class="btn-white" href="${pageContext.request.contextPath}/login">Login </a>
			</li>
		</c:if>
		
	</ul>
	</div>
	
		
		
		<div class="container float-right ml-6">
		
		</div>
		

		
    </div>
 
  
</nav>
 
  
  