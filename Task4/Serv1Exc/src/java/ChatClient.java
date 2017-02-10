
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ChatClient 
{
    private final String host;
    private final int port;
    private Socket clientSocket;
    

    public ChatClient(String host, int port) 
    {
        this.host = host;
        this.port = port;
    }

    public void open() throws IOException 
    {
        clientSocket = new Socket();
        clientSocket.connect(new InetSocketAddress(host, port));
    }
    
    /**
     * Sends a message to the server by opening a socket, writing to the input and reading from the output.
     *
     * @param message The message to send
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException 
    {
        // Write to the server
        OutputStream output = clientSocket.getOutputStream();
        PrintWriter writer = new PrintWriter(output);
        writer.println(message);
        writer.flush();
    }
    
    /**
     * Reads a message from the server, if connected.
     *
     * @return A message from the server.
     * @throws IOException
     */
    public String readMessage() throws IOException {
        
        // Read from the server
        InputStream input = clientSocket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String fromServer;
        while ((fromServer = reader.readLine()) == null) 
        {
            // Wait until the server says something interesting
        }
        return fromServer;
    }
    
}
