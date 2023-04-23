<!DOCTYPE html>
<html>
	<head>
        <link rel="stylesheet" href="index.css">
        <%@ page language="java" import="java.util.ResourceBundle" %>
        <% ResourceBundle resource = ResourceBundle.getBundle("application"); %>
		<title><%= resource.getString("guessing.program") %></title>
	</head>
	<body>
		<form method="post" action="yes">
			<div class="content">
				<div id="node" class="node"></div>
				<div class="node">
                    <button>Yes</button>
                    <button onclick="document.forms[0].action = 'no'">No</button>
                </div>
			</div>
		</form>
	</body>
</html>
<script>
    window.onload = function() {
        document.getElementById('node').innerHTML = JSON.parse('${sessionScope.node}').name + '?'
    }
</script>
