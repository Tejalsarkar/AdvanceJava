<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="ForgetPasswordCtl" method ="post" >

<%String password = (String) request.getAttribute("password"); %>
<table>
<tr>
<% if (password != null){ %>

<h1> <%=password%></h1>

<% }%>

</tr>

<tr>

<th>loginId</th>
<td><input type="text" name="loginId"></td>
</tr>
<tr>
<td><input type="Submit"  value="Submit" ></td>

</tr>


</table>


</form>

</body>
</html>