/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Network_server_client;

/**
 *
 * @author Samson
 */


import java.io.*;
import java.net.*;

public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started. Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        // Read from client
        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));

        // Send to client
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String message = in.readLine();
        System.out.println("Client says: " + message);
        out.println("Hello from Server!");

        socket.close();
        serverSocket.close();
    }
}