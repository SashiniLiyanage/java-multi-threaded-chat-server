// E/17/190 
// CO327 - Lab1

import java.io.*;
import java.net.*;

// ClinetThread class to create threads for clients
public class ClientThread extends Thread {

    private Socket socket;      // Socket to connect
    private int client;         // clinet number
	public int serverSocketNum; // server port number

    // Constructor
    public ClientThread(Socket socket, int serverSocketNum, int client) {
        this.socket = socket;
        this.serverSocketNum = serverSocketNum;
        this.client = client;
    }

    // therad
    public void run() {
		try {
            // get the socket's input stream and opens a BufferedReader 
			BufferedReader in =
		        new BufferedReader(
		            new InputStreamReader(socket.getInputStream()));


			try { 
                while(true) { 
                    // read client messages
                    String str = in.readLine();

                    // when client send quit or Quit, stop reading in comming messages
                    if(str.equals("quit") || str.equals("Quit")) {
                        System.out.println("\nclient "+client+" quitted\n");
                        break;
                    };
                    // print client messages along with their client number
                    System.out.println("client "+client+" >> "+str);
                } // wait for next message 

            } catch(NullPointerException e) {
                // if the client just kill the connection the str will be null. 
                System.out.println("\nClient"+ client+ " closed the connection\n");
            }
            
            // close the client connection
            socket.close();

		} catch (IOException ex) {
            // incase of a IOException print the error message
			System.out.println("Error in ClientThread "+client+" : " + ex);
			ex.printStackTrace();
		}
	}

}
