package Q2;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class EchoClient
{
	public static void main(String[] args) {

		try {
			System.out.println("Looking for Server...");

			// Get localhost IP address using InetAddress built in function
			InetAddress localAddress = InetAddress.getLocalHost();

			// Create socket for client
			Socket clientSocket = new Socket(localAddress, 6017);

			PrintWriter pr = new PrintWriter(clientSocket.getOutputStream(), true);
			InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
			BufferedReader br = new BufferedReader(isr);

			System.out.println("Connected to server");

			// Read in user input through terminal
			Scanner scanner = new Scanner(System.in);

			while (true) {
				System.out.print("Input: ");
				String input = scanner.nextLine();
				input = input.replace("client", "server");				
				String exit = "exit";

				//If user types "exit", break from while loop. Else, print string from BufferedReader
				if (exit.equalsIgnoreCase(input)) {
					break;
				} else {
					pr.println(input);
					System.out.println("Server: " + br.readLine());
				}
				
			}
			
		// Close sockets
		clientSocket.close();
		scanner.close();

		} catch (IOException ex) {
			System.out.println("Error");
		}
	}
}
