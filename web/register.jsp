<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">		
        <%@ page language="java" import="java.util.ResourceBundle" %>
        <%@ page language="java" import="java.text.MessageFormat" %>

        <% ResourceBundle resource = ResourceBundle.getBundle("application"); %>

		<title><%= resource.getString("guessing.program") %></title>
		
		<script>

			function complete() {
				var node = JSON.parse('${sessionScope.node}')
				var complete = '<%= resource.getString("guessing.complete") %>';
				document.getElementById('complete').innerHTML =
				    complete.replace('{0}', document.getElementById('_name').value).replace('{1}', node.name)
				    + "</br></br><input type=\"text\" id=\"_characteristic\" ></br></br><button onclick=\"save()\">Ok</button>";
				    document.getElementById('_characteristic').focus();
			}	
			
			function save() {
				document.getElementById('name').value = document.getElementById('_name').value
				document.getElementById('characteristic').value = document.getElementById('_characteristic').value
				document.forms[0].submit()
			}
			
		</script>
	</head>
	<body>
		<div id="content" style="border: 0px solid black; width: 800px; height: 160px; left: 500px; top: 270px; position: absolute;">
			<%= resource.getString("guessing.failure") %></br>
			<input type="text" id="_name" autofocus="autofocus" ></br>
			<button onclick="complete()">Ok</button></br>
			<div id="complete"></div>
		</div>
		<form method="post" action="register">
			<input type="hidden" name="characteristic" id="characteristic">
			<input type="hidden" name="name" id="name">
		</form>
	</body>
</html>