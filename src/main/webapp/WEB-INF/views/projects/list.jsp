<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
	<script src="<c:url value="/resources/js/jquery-1.11.2.js" />"></script>
	<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
	<link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.css" />" />
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />" />
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.css" />" />
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><spring:message code="project.list.browser.title" /></title>
</head>
<body>
	<div class="container">
		<h2>
			<spring:message code="project.list.title" />
		</h2>

		<div class="table-responsive">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Start Date</th>
						<th>End Date</th>
						<th>Tasks</th>
						<th>Creator</th>
						<th>Users</th>
					</tr>
				</thead>
				<c:forEach items="${projects}" var="project">
					<tr>
						<td>${project.id}</td>
						<td>${project.name}</td>
						<td><fmt:formatDate type="both" value="${project.start}" /></td>
						<td><fmt:formatDate type="both" value="${project.end}" /></td>
						<td>
							<table>
								<c:forEach items="${project.tasks}" var="task">
									<tr>
										<td>
											${task.name}
										</td>
									</tr>
								</c:forEach>
							</table>
						</td>
						<td>${project.creator.firstName}-${project.creator.lastName}</td>
						<td>
							<table>
								<c:forEach items="${project.assignedUsers}" var="assignedUser">
									<tr>
										<td>${assignedUser.firstName}-${assignedUser.lastName} [<c:forEach
												items="${assignedUser.roles}" var="role">${role.name},</c:forEach>]
										</td>
									</tr>
								</c:forEach>
							</table>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<a class="btn btn-default" href="<c:url value="/projects/create" />">Create a new project</a>
	</div>
</body>
</html>