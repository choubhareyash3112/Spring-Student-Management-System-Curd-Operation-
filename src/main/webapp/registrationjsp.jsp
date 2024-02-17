<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <form action="addstudent" method="post">
	<h1>Welcome to my project</h1>
	
	<lable for="id">ID</lable>
	<input type="text" id="id" name="id">
	
	<lable for="name">Name</lable>
	<input type="text" id="name" name="name">
	
	<lable for="city">City</lable>
	<input type="text" id="city" name="city">
	
	<lable for="email">Email</lable>
	<input type="email" id="email" name="email">
	
	<lable for="Password">Password</lable>
	<input type="Password" id="Password" name="Password">
	
	<button type="submit">Submit</button>
	</form>
</body>
</html>