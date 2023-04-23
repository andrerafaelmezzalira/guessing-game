<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <%@ page language="java" import="java.util.ResourceBundle" %>
        <% ResourceBundle resource = ResourceBundle.getBundle("application"); %>

		<title><%= resource.getString("guessing.program") %></title>
		<script>
			window.onload = function() {
				var node = JSON.parse('${sessionScope.node}')
				document.getElementById('node').innerHTML = node.name + '?</br>'
			}
		</script>
	</head>
	<body>
		<form method="post" action="yes">
			<div id="content" style="border: 0px solid black; width: 200px; height: 60px; left: 550px; top: 270px; position: absolute;">
				<div id="node"></div>
				<button>Sim</button>&nbsp;
				<button onclick="document.forms[0].action = 'no'">Não</button>
			</div>
		</form>
	</body>
</html>