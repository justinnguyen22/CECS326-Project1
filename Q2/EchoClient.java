/**
 * An echo client. The client enters data to the server, and the
 * server echoes the data back to the client.
 */
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class EchoClient
{
	public static void main(String[] args) {

		try {
			System.out.println("Looking for Server...");
			InetAddress localAddress = InetAddress.getLocalHost();
			Socket clientSocket = new Socket(localAddress, 6017);
			PrintWriter pr = new PrintWriter(clientSocket.getOutputStream(), true);
			InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
			BufferedReader br = new BufferedReader(isr);

			System.out.println("Connected to server");
			Scanner scanner = new Scanner(System.in);

			while (true) {
				System.out.print("Input: ");
				String input = scanner.nextLine();
				String exit = "exit";

				if (exit.equalsIgnoreCase(input)) {
					break;
				} else {
					pr.println(input);
					System.out.println("Server: " + br.readLine());
				}
				
			}
			
		clientSocket.close();
		scanner.close();

		} catch (IOException ex) {
			// Handle exceptions
		}
	}
}
