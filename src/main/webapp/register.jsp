<html>
<head>
<body>
	<h2>Register new user</h2>

	<form action="register" method="post">

		Name: <input type="text" name="fname" required><br>
		Surname: <input type="text" name="sname" required><br>
		Gender: <select name="gender" size="1">
			<option value="male">M</option>
			<option value="female">F</option>
		</select><br> Birth date:<input type="date" name="birth" required><br>
		Work Address: <input type="text" name="work_addr"><br>
		Home Address: <input type="text" name="home_addr"><br> <input
			type="submit" value="Submit form">

	</form>
	<a href="http://localhost:8080/proj_1/index.jsp"> Home</a>

</body>
</html>