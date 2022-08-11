// E/17/190 
// CO327 - Lab1

import java.io.*;
import java.net.*;


class ChatServer  {
    public static ServerSocket server;		// server socket
    public static int serverSocketNum;		// port number
    public static int client;				// number of clients

	// function to create threads for each client
    public static void handleConnection(Socket connection){
		try {
			// create new client instance and start the tread
			ClientThread newClient = new ClientThread(connection, serverSocketNum,client);
			newClient.start();
			
		} catch (Exception e){
			System.out.println("Some issue" + e);
		}
    }

	// constructor (default)
    public ChatServer() {}



    public static void main(String [] args)
    throws IOException { 

		serverSocketNum = 666;	// Default port number
		client = 0;				// count number of clients

		// change the port number if it is given as an arguement
		if (args.length == 1) {
			serverSocketNum = Integer.parseInt(args[0]);
		}
	 
		
		try {
			// open the server socket
			server = new ServerSocket(serverSocketNum);
			System.out.println("Chat Server is listening on port " + serverSocketNum);

		}catch (IOException e) {
			// if socket cannot be open, print the error message and exit the program
			System.out.println("Could not listen on port: "+serverSocketNum);
			System.exit(0);
		}

		while(true) {
			// wait for a connection
			Socket socket = server.accept();
			// if a client is connected icrease the client count
			client++;
			System.out.println("\nClient "+client+" connected\n");
			// call the function to create separate thread for clients
			handleConnection(socket);
		}

    }
    
}