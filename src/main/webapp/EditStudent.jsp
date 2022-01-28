<%@page import="com.ty.student.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

th {
	background-color: #04AA6D;
	color: white;
}

.button {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}

.button3 {
	background-color: #f44336;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Student student = (Student) request.getAttribute("myStudent");
	%>
	<table>
		<form action="edit" method="post">
			ID :<input type="number" name="id" readonly="readonly" value=<%=student.getId()%>><br> 
			NAME :<input	type="text" name="name" value=<%=student.getName()%>><br>
			EMAIL :<input type="text" name="email" value=<%=student.getEmail()%>><br>
			PHONE :<input type="NUMBER" name="phone" value=<%=student.getPhone()%>><br> 
			AGE :<input	type="text" name="age" value=<%=student.getAge()%>><br>
			<br> <input type="submit" value="Udate">
		</form>
	</table>
</body>
</html>