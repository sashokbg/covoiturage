<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<script src="<c:url value="/resources/js/jquery-1.11.2.js" />"></script>
<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script src="<c:url value="/resources/js/chosen.jquery.js" />"></script>

<link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.css" />" />
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />" />
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.css" />" />
<link rel="stylesheet" href="<c:url value="/resources/css/chosen.css" />" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="project.form.browser.title" /></title>

	<script type="text/javascript">
		$(document).ready(function() {
			$('.date-picker').datepicker();
			$('#project-users').chosen();
		});
	</script>
</head>
<body>
	<div class="container">
		<h2>
			<spring:message code="project.form.title" />
		</h2>

		<form role="form" action="<c:url value="/project/create.do" />"
			method="post">
			<div class="form-group">
				<label for="project-name"><spring:message
						code="project.form.name" />:</label> <input id="project-name" type="text"
					name="name" />
			</div>
			<div class="form-group">
				<label for="project-creator"><spring:message
						code="project.form.creator" />:</label> <input id="project-creator"
					type="text" name="creatorId" />
			</div>
			<div class="form-group">
				<label for="project-users"><spring:message
						code="project.form.assigned.users" />:</label> <select id="project-users"
					multiple name="assignedUsersIds">
					<c:forEach items="${users}" var="user">
						<option value="${user.id}">${user.firstName}
							${user.lastName}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="project-start"><spring:message
						code="project.form.start" />:</label> <input id="project-start"
					class="date-picker" type="text" name="start" />
			</div>
			<div class="form-group">
				<label for="project-end"><spring:message
						code="project.form.end" />:</label> <input id="project-end"
					class="date-picker" type="text" name="end" />
			</div>
			<div class="form-group">
				<label for="project-submit"><spring:message
						code="project.form.submit" />:</label> <input id="project-submit"
					class="btn btn-default" type="submit" />
			</div>
		</form>
	</div>
</body>
</html>