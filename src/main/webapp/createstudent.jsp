<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

div {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="nav.jsp"%>
	<%
		String name = (String)session.getAttribute("userName");
%>
	<%
		String message = (String)request.getAttribute("message");
		if(message != null){
			%>
		 %>	<h1><%=message %></h1>
		 <%
		}
	%>
	
	<form action="create" method="get">
		Enter the Name : <input type="text" name="name"> <br>
		Enter the email : <input type="text" name="email"> <br>
		Enter the contack number : <input type="text" name="phone"> <br>
		Select gender : <input type="radio" id="male" name="gender">  
		<label for="male">Male</label>   <input type="radio" id="female"
			name="gender">   <label for="female">Female</label><br>
		Enter the age : <input type="text" name="age"> <br> <br>
		<input type="submit" value="Submit">
	</form>
	<ul>

	</ul>
</body>
</html>