<!DOCTYPE html>
<html>
<head>
    <title>Chat Application</title>
</head>
<style>
    /* Định dạng hộp chat */
    #chat {
        background-color: #f5f5f5;
        border: 1px solid #ccc;
        padding: 10px;
        height: 300px;
        overflow-y: scroll; /* Cho phép cuộn nội dung khi có nhiều hơn chiều cao */
    }

    /* Định dạng tin nhắn */
    .message {
        background-color: #e2e2e2;
        border-radius: 5px;
        padding: 5px 10px;
        margin: 5px;
    }

    /* Định dạng input message */
    #message {
        width: 70%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    /* Định dạng nút Send */
    button {
        padding: 10px 20px;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    /* Định dạng nút Send khi di chuột qua */
    button:hover {
        background-color: #0056b3;
    }

</style>
<body>
<h1>Chat</h1>
<div id="chat"></div>
<input type="text" id="message" placeholder="Type a message..." />
<button onclick="sendMessage()">Send</button>

<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.0/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script>
    var stompClient = null;

    function connect() {
        var socket = new SockJS('/chat');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            stompClient.subscribe('/topic/messages', function (response) {
                showMessage(JSON.parse(response.body).content);
            });
        });
    }

    function sendMessage() {
        var message = document.getElementById('message').value;
        stompClient.send("/app/sendMessage", {}, JSON.stringify({ 'content': message }));
        document.getElementById('message').value = '';
    }

    function showMessage(message) {
        var chatDiv = document.getElementById('chat');
        var p = document.createElement('p');
        p.appendChild(document.createTextNode(message));
        chatDiv.appendChild(p);
    }

    connect();
</script>
</body>
</html>
