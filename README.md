# Quarkus Issue 23073

To start the websocket server, run the following Docker command:

`docker run -p 9222:9222 zenika/alpine-chrome:latest --no-sandbox --remote-debugging-address=0.0.0.0 --remote-debugging-port=9222`

Open `http://localhost:9222/json` in your browser and copy `webSocketDebuggerUrl` value to `WebsocketResource#L25`