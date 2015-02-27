<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
<title><spring:message code="user.form.browser.title" /></title>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.date-picker').datepicker();
			$('#user-roles').chosen();
		});
	</script>
</head>
<body>
	<div class="container">
		<h2>
			<spring:message code="user.form.title" />
		</h2>

		<form:form role="form" action="${pageContext.request.contextPath}/users/create.do" method="post" commandName="user">
			<div class="form-group">
				<label for="user-firstName">
					<spring:message code="user.form.firstName" />:
				</label>
				<input id="user-firstName" type="text" name="firstName" />
			</div>
			<form:select path="gender">
				<form:options items="${gendersList}"/>
			</form:select>
			<div class="form-group">
				<label for="user-lastName">
					<spring:message code="user.form.lastName" />:
				</label>
				<input id="user-lastName" type="text" name="lastName" />
			</div>
			<div class="form-group">
				<label for="user-birthday">
					<spring:message code="user.form.birthday" />:
				</label>
				<input id="user-birthday" class="date-picker" type="text" name="birthDay" />
			</div>
			<div class="form-group">
				<label for="user-roles">
					<spring:message code="user.form.roles" />:
				</label>
				<form:select id="user-roles" path="roles" multiple="true">
					<form:options items="${rolesList}" itemValue="id" itemLabel="name" />
				</form:select>
			</div>
			<div class="form-group">
				<label for="user-submit">
					<spring:message code="user.form.submit" />:
				</label>
				<input id="user-submit" class="btn btn-default" type="submit" />
			</div>
		</form:form>
	</div>
</body>
</html>