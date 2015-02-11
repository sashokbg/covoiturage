<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<script src="<c:url value="/resources/js/jquery-1.11.2.js" />"></script>
</head>
<body>
	Welcome Home:

	<c:forEach items="${usersList}" var="user">
		<br />[${user.id}] ${user.name} - travels from ${user.path.startPoint} to ${user.path.endPoint}
	</c:forEach>
</body>
</html>