package Q2;

import java.net.*;
import java.io.*;

public class  EchoServer
{
    public static void main(String args[]) {
        System.out.println("Starting echo server...");

        // Try to create a server socket on port 6017; if fail, return exception
        try (ServerSocket serverSocket = new ServerSocket(6017)){

            System.out.println("Waiting for client connection...");

            // Create a client socket that accepts a server socket
            Socket clientSocket = serverSocket.accept();     
            System.out.println("Client connected");

            InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read in next line from buffered reader 
            String line = br.readLine();
            line = line.replace("client", "server");
            // while bufferedreader does not read a null terminator
            while (line != null) {
                System.out.println("Server: " + line);
                pw.println(line);
                line = br.readLine();
            }
            
            // close sockets
            clientSocket.close();
            serverSocket.close();
            
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
