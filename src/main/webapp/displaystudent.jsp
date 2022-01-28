<%@page import="com.ty.student.dto.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
.topnav a:hover {
  background-color: #ddd;
  color: black;
}
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


.button3 {background-color: #f44336;} 

</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="nav.jsp"%>


	<%
	ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("students");
	%>
	<table border="">
		<form>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>PHONE</th>
				<th>AGE</th>
				<th>DELETE</th>
				<th>EDIT</th>
			</tr>
			<%
			for (Student s : students) {
			%>
			<tr>
				<td><%=s.getId()%></td>
				<td><%=s.getName()%></td>
				<td><%=s.getEmail()%></td>
				<td><%=s.getPhone()%></td>
				<td><%=s.getAge()%></td>
				
				<td><button class="button button3"><a href="delete?id=<%=s.getId()%>" style="color:white; font-style: normal; font-family:serif; ">Delete</a></button></td>
				<td><a href="getStudent?id=<%=s.getId()%>">EDIT</a></td>
			</tr>
			<%
			}
			%>
		</form>
	</table>
</body>
</html>