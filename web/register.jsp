<!DOCTYPE html>
<html>
	<head>
        <link rel="stylesheet" href="index.css">
        <%@ page language="java" import="java.util.ResourceBundle" %>
        <%@ page language="java" import="java.text.MessageFormat" %>
        <% ResourceBundle resource = ResourceBundle.getBundle("application"); %>
		<title><%= resource.getString("guessing.program") %></title>
	</head>
	<body>
		<div class="content">
            <div class="node">
                <%
                    String error = (String) session.getAttribute("error");
                    if (error != null) {
                        out.print(error);
                    }
                %>
            </div>
		    <div class="node">
                <%= resource.getString("guessing.failure") %></br>
		    </div>
		    <div class="node">
                <input type="text" id="_name" autofocus="autofocus" ></br>
		    </div>
		    <div class="node">
                <button disabled="disabled" id="buttonName" onclick="complete()">Ok</button></br>
		    </div>
			<div id="complete"></div>
		</div>
		<form method="post" action="register">
			<input type="hidden" name="characteristic" id="characteristic">
			<input type="hidden" name="name" id="name">
		</form>
	</body>
</html>
<script>

    function complete() {
        var complete = '<%= resource.getString("guessing.complete") %>';
        document.getElementById('complete').innerHTML = "<div class=\"node\">"
            + complete.replace('{0}', document.getElementById('_name').value).replace('{1}', JSON.parse('${sessionScope.node}').name)
            + "</div><div class=\"node\"><input type=\"text\" id=\"_characteristic\" ></div>"
            + "<div class=\"node\"><button id=\"buttonCharacteristic\" disabled=\"disabled\" onclick=\"save()\">Ok</button></div>";
            document.getElementById('_characteristic').focus();
            document.getElementById('_characteristic').addEventListener('input', function() {
                document.getElementById('buttonCharacteristic').disabled = (this.value === '');
            });
    }

    function save() {
        document.getElementById('name').value = document.getElementById('_name').value
        document.getElementById('characteristic').value = document.getElementById('_characteristic').value
        document.forms[0].submit()
    }

    document.getElementById('_name').addEventListener('input', function() {
        document.getElementById('buttonName').disabled = this.value === '';
    });
</script>
