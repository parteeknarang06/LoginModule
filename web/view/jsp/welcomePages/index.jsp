<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<%=request.getServletContext().getServletContextName() %> <br>
		<%=request.getServletContext().getContextPath() %> <br>
		<%=request.getServletPath() %>
		<%-- <%
			response.sendRedirect(request.getServletContext().getContextPath()+"/init");
		%> --%>
		<form action="/app.login/init">
			<input type="text" value="12" name="test">
			<button type="submit">Click init</button>
		</form>
		<form action="/app.login/init/login">
			<input type="text" value="12" name="test">
			<button type="submit">Click init log</button>
		</form>
		<form action="/app.login/login">
			<input type="text" value="12" name="test">
			<button type="submit">Click log</button>
		</form>
		<form action="/app.login/init/login/check">
			<input type="text" value="12" name="test">
			<button type="submit">Click init log check</button>
		</form>
	</body>
</html>