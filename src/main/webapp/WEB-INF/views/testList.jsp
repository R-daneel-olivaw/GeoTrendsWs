<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Page</title>
</head>
<body>
	<h2>test controller is working</h2>
	<h3>${reg}</h3>
	<ol>
		<c:forEach items="${keywords}" var="keyword">
			<li>${keyword}</li>
		</c:forEach>
	</ol>

</body>
</html>