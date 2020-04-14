function joinGame() {

    var username = document.getElementById("username").value;
    var gameId = document.getElementById("gameId").value;

    const gameRequest = {gameExternalId: gameId, playerName: username};

    fetch('http://localhost:8080/game', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(gameRequest),
    })
        .then((response) => response.json())
        .then((data) => {
            console.log('Success:', data);
            window.location.assign("/game.html?id=" + data.internalId);
        })
        .catch((error) => {
            alert("It was not possible to enter the room");
        });
}