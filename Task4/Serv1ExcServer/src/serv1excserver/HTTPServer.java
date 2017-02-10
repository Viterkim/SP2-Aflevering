
package serv1excserver;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HTTPServer implements HttpHandler
{
    private final String host;
    private final int port;
    private Socket connection;
    //Synchronizedlist
    List<String> messages;

    public HTTPServer(String host, int port) 
    {
        this.messages = Collections.synchronizedList(new ArrayList<>());
        this.host = host;
        this.port = port;
    }
    
    
    public void startServer() throws IOException
    {
        ServerSocket socket = new ServerSocket();
        socket.bind(new InetSocketAddress(host, port));
        System.out.println("Server startet listening on port " + port);
        
        while ((connection = socket.accept()) != null)
        {
            handle(); /// ???? Ingen ide om hvordan jeg får he objektet ind, har googlet alt, og siddet i 2 timer og prøve at finde ud af det, intet resultat
                    
            connection.close();
        }
        
    }
    
    @Override
    public void handle(HttpExchange he) throws IOException 
    {
        String response = he.getRequestMethod();
        if(response.equalsIgnoreCase("GET"))
        {
            handleGET();
        }
        else if (response.equalsIgnoreCase("POST"))
        {
            handlePOST();
        }
    }
    
    public void handlePOST() throws IOException
    {
        InputStream input = connection.getInputStream();

        // Read whatever comes in
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line = reader.readLine();
        
    }
    
    public void handleGET() throws IOException
    {

    }
    
}
