#java-multi-threaded-chat-server

The chat server will accept connections from clients and would let clients send in strings over the network. The server will display the string sent by the client and will wait for the next string. When the client sends a message “quit”, the server will close the connection with the client and wait for another connection (possibly from a different client) and repeat the same.

How to run:
- sudo java ChatServer <port number>
- on another terminal: nc 127.0.0.1 <port number>

Read the documentation for more details