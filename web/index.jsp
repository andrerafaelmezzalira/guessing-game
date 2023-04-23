<!DOCTYPE html>
<html>
	<head>
        <link rel="stylesheet" href="index.css">
		<%@ page language="java" import="java.util.ResourceBundle" %>
        <% ResourceBundle resource = ResourceBundle.getBundle("application"); %>
		<title><%= resource.getString("guessing.program") %></title>
	</head>
	<body>
		<form method="post" action="ok">
			<div class="content">
				<div class="node">
                    <%= resource.getString("guessing.welcome") %>
				</div>
				<div class="node">
    				<button>Ok</button>
			    </div>
			</div>
		</form>
	</body>
</html>