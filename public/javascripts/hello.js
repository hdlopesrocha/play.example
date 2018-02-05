if (window.console) {
  console.log("Welcome to your Play application's JavaScript!");

}

function wsurl(s) {
	var l = window.location;
	return ((l.protocol === "https:") ? "wss://" : "ws://") + l.hostname + (((l.port != 80) && (l.port != 443)) ? ":" + l.port : "") + s;
}

var ws;

$(document).ready(function (){

  ws = new WebSocket(wsurl('/ws'));

  ws.onopen = function () {
    // connection is opened and ready to use
    ws.send({"type":"text", "content":"hello!"});
    console.log("WebSocket opened!");
  };

  ws.onerror = function (error) {
    // an error occurred when sending/receiving data
    console.log("WebSocket error:", error);
  };



  ws.onmessage = function (message) {
    console.log('Message received: ', message.data);
    // try to decode json (I assume that each message
    // from server is json)
    try {
        $("#wsMessage").html(message.data);
    } catch (e) {
      console.log('This doesn\'t look like a valid JSON: ', message.data);
      return;
    }
    // handle incoming message
  };

});