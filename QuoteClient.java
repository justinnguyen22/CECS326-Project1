/**
 * Modified DateClient so that it requests a quote
 * from the quote server.
 */

import java.net.*;
import java.io.*;

public class QuoteClient
{
    public static void main(String[] args) {
        try {
            Socket sock = new Socket("127.0.0.1", 6017);

            InputStream in = sock.getInputStream();
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));

            String line;
            while((line = bin.readLine()) !=  null)
                System.out.println(line);

            sock.close();
        }
        catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}
