<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="<c:url value="/resources/js/jquery-1.11.2.js" />"></script>
<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/jquery-ui.css" />" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.css" />" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap-theme.css" />" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="project.form.browser.title" /></title>

<script type="text/javascript">
	$(document).ready(function() {
		$('.date-picker').datepicker();
	});
</script>
</head>
<body>
	<div class="container">
		<h2>
			<spring:message code="project.form.title" />
		</h2>
		
		<form action="<c:url value="/project/create.do" />" method="post">
			<div class="row">
				<div class="col-md-4">
					<label for="project-name"><spring:message code="project.form.name" />:</label>
					<input id="project-name" type="text" name="name" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<label for="project-creator"><spring:message code="project.form.creator" />:</label>
					<input id="project-creator" type="text" name="creatorId" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<label for="project-users"><spring:message code="project.form.assigned.users" />:</label>
					<input id="project-users" type="text" name="assignedUsersIds" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<label for="project-start"><spring:message code="project.form.start" />:</label>
					<input id="project-start" class="date-picker" type="text" name="start" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<label for="project-end"><spring:message code="project.form.end" />:</label>
					<input id="project-end" class="date-picker" type="text" name="end" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<label for="project-submit"><spring:message code="project.form.submit" />:</label>
					<input id="project-submit" class="btn btn-default" type="submit" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>