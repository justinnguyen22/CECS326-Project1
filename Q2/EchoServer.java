
import java.net.*;
import java.io.*;

public class  EchoServer
{
    public static void main(String args[]) {
        System.out.println("Starting echo server...");

        try (ServerSocket serverSocket = new ServerSocket(6017)){

            System.out.println("Waiting for client connection...");

            Socket clientSocket = serverSocket.accept();     
            System.out.println("Client connected");

            InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);
            String line = br.readLine();

            while (line != null) {
                System.out.println("Server: " + line);
                pw.println(line);
                line = br.readLine();
            }
            
            clientSocket.close();
            serverSocket.close();
            
        }
        catch(Exception e) {
            
        }
    }
}
