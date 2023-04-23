<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">

		<%@ page language="java" import="java.util.ResourceBundle" %>
        <% ResourceBundle resource = ResourceBundle.getBundle("application"); %>

		<title><%= resource.getString("guessing.program") %></title>
	</head>
	<body>
		<form method="post" action="ok">
			<div id="content" style="border: 0px solid black; width: 200px; height: 60px; left: 550px; top: 270px; position: absolute;">
				<%= resource.getString("guessing.welcome") %>
				<button>Ok</button>
			</div>
		</form>
	</body>
</html>