<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WebSocket</title>
<script type="text/javascript" src="/coreyou.springMVC/js/sockjs-1.1.4/sockjs.js"></script>
<script type="text/javascript" src="/coreyou.springMVC/js/stomp-websocket-1.1.7/stomp.js"></script>
<script type="text/javascript">
var stompClient = null;

function setConnected(connected) {
	document.getElementById("connect").disabled = connected;
	document.getElementById("disconnect").disabled = !connected;
	document.getElementById("conversationDiv").style.visibility = connected ? "visible" : "hidden";
	document.getElementById("response").innerHTML = "";
}

function connect() {
	var socket = new SockJS("/coreyou.springMVC/portfolio");
	var stompClient = Stomp.over(socket);

	stompClient.connect({}, function(frame) {
		console.log("client.connect()");
		setConnected(true);
	});
}

function disconnect() {
	if (stompClient != null) {
		stompClient.disconnect();
	}
	setConnected(false);
	console.log("client.disconnected");
}

function setName() {
	var value = document.getElementById("name").value;
	stompClient.send("app/websocketHelloWorld", {}, value);
}

connect();

</script>
</head>
<body>
	<div>
		<button id="connect" onclick="connect();">Connect</button>
		<button id="disconnect" onclick="disconnect();" disabled="disabled">DisConnect</button>
	</div>
	<div id="conversationDiv">
		<p><label>notice content?</label></p>
		<p><textarea id="name" rows="5"></textarea></p>
		<button id="sendName" onclick="sendName();">Send</button>
		<p id="response"></p>
	</div>
</body>
</html>