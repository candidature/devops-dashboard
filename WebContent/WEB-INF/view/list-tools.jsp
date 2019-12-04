<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html>
<html>

<%@include file="head.jsp" %>

<body>
<script>

$(document).ready(function() {
    var marquee = $('div.marquee');
    console.log(marquee);
    marquee.each(function() {
        var mar = $(this),indent = mar.width();
        mar.marquee = function() {
            indent--;
            mar.css('text-indent',indent);
            if (indent < -1 * mar.children('div.marquee-text').width()) {
                indent = mar.width();
            }
        };
        mar.data('interval',setInterval(mar.marquee,1000/60));
    });
});

</script>
<div class="container">

	<%@include file="header2.jsp" %>
<div class="row">
<div class="col">
	<div class="p-1">
		
		<c:if test="${globalAnnouncement[0].subject != null }">
			<div class="main marquee">
			<div class="marquee-text">
				<c:forEach var="gAnnouncement" items="${globalAnnouncement}">
					|| ${gAnnouncement.subject} ${gAnnouncement.details} ||
				</c:forEach>
			</div>
			</div>
		</c:if>
		
		
		<c:if test="${tier != null}">
			<div class="mt-3">
			<h4>TIER - ${tier}</h4>
			</div>
				<c:if test="${tier =='TIER_1' }">
				<div><h5><i>Below Applications are having 24*7 Support</i></h5></div>
			</c:if>
		</c:if>
		
        <div class="row mt-2 justify-content-left">
		
		<c:forEach var="tool" items="${tools}">
			<!-- Construct url for update -->
			<c:url var="updateLink" value="/devops/showFormForToolUpdate">
				<c:param name="toolId" value="${tool.id}"/>
			</c:url>
			
			<c:url var="instancesLink" value="/devops/tool/${tool.id }/instances">
			</c:url>
			
			<c:url var="addInstanceLink" value="/devops/tool/${tool.id}/instance">
			</c:url>
			
			<c:url var="deleteInstanceLink" value="/devops/tool/${tool.id}">
			</c:url>
			
			<c:url var="toolAnnouncementLink" value="/devops/announcement/tool/${tool.id}">
			</c:url>
		<div class="card mx-2 mb-3" style="width: 20rem;">
		<a href="#" data-toggle="${tool.purpose }" title="${tool.purpose}">
		  <img class="card-img-top" width="10" height="60"  src="${pageContext.request.contextPath}/resources/image/devops.jpeg" alt="GTSO">
	    </a>
		  <a href="${toolAnnouncementLink}" ><i class="fa fa-bullhorn"></i></a>
		  
  			<div class="card-body" >
    			<h5 class="card-title">${tool.name }</h5>
    			
    			
    			<h6>Health : 
    			
    				<c:if test="${not empty tool.instances}">
						${fn:length(tool.instances)}/${fn:length(tool.instances)}
					</c:if>
    				<c:if test="${empty tool.instances}">
						0/0
					</c:if>
    			
    			
    			</h6>
    			
    			
    			
    			
    			
    			<h6>Announcement : 
    			
    			
    			
    			<c:if test="${not empty tool.announcements}">
					<div class="main marquee">
					<div class="marquee-text">
						<c:forEach var="announcement" items="${tool.announcements}">
							|| ${announcement.subject} ${announcement.details} ||
						</c:forEach>
					</div>
					</div>
				</c:if>
    			

    			</h6>
    			<p class="card-text">  <small> </br> <address>Supported Mail: ${tool.supportedByEmails} Team: ${tool.teamName }</address></small></p>
    			<a href="${instancesLink}" class="btn btn-primary">Instances</a>
    			<a href="${updateLink}" class="btn btn-primary">Edit</a>
    			
    			<a onclick="if (!(confirm('Are you Sure, you want to delete this??'))) return false" class="btn btn-danger"   href="${deleteInstanceLink}" >DELETE</a>
    			
    			
  			</div>
		</div>
		
			</c:forEach>
		</div>
	</div>
</div>

		<div class="col-1 mt-2">
			<%@include file="tier.jsp" %>
		</div>
</div>
	
	
	
</div>
</body>
</html>