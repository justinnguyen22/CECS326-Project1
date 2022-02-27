/**
 * Quote server listening to port 6017.
 *
 */
 
import java.net.*;
import java.io.*;

public class QuoteServer
{
    public static void main(String[] args) {
        try {
            ServerSocket sock = new ServerSocket(6017);
            while (true) {
                Socket client = sock.accept();
                PrintWriter pout = new PrintWriter(client.getOutputStream(), true);

                pout.println("\"Life is either a great adventure or nothing.\" \n - Helen Keller");

                client.close();
            }
        }

        catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}
