<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<%
 	response.setHeader("Refresh", "3");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table border="1">
				<tr>
					<th width="10%">온도</th>
					<td width="30%">습도</td>
				</tr>
			<tr>
				<td>${dto.hum } </td>
				<td>${dto.temp } </td>
			</tr>
			</table>
</body>
</html>