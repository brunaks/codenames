$(document).ready(function () {
    $('.draggable').draggable();

    const socket = new WebSocket('ws://localhost:8080/websocket');
    const stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe("/game/fakeId", function (data) {
            $('#move-log').prepend('<p class="card-text">' + data.body + '</p>')
        });
    });
});
