<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>

		<body>
		<%
		String msg = (String) request.getAttribute("msg");
	%>
		
		
			<form action="UserCtl" method="post">
				<table>
				<tr>
				<%
					if (msg != null) {
				%>
				<%=msg%>
				<%
					}
				%>
			</tr>
				
					<tr>
						<th>
							<p style="color: red;">first_name :</p>
						</th>
						<td><input type="text" name="first_name"></td>
					</tr>
					<tr>
						<th>
							<p style="color: blue;">last_name :</p>
						</th>
						<td><input type="text" name="last_name"></td>
					</tr>
					<tr>
						<th>
							<p style="color: red;">login_id :</p>
						</th>
						<td><input type="text" name="login_id"></td>
					</tr>
					<tr>
						<th><p style="color: blue;">password :</p></th>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<th><p style="color: red;">dob :</p></th>
						<td><input type="date" name="dob"></td>
					</tr>
					<tr>
						<th><p style="color: blue;">address :</p></th>
						<td><input type="text" name="address"></td>
					</tr>

					<tr>
						<th></th>
						<td><input type="submit" name ="operation" value ="SignUp">
						<input type="submit" name = "opreation"  value ="Reset"> 
						</td>
						
					</tr>
				</table>
			</form>
		</body>
</html>

