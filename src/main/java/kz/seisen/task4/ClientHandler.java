package kz.seisen.task4;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                Socket client = socket;
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream())
        ) {
            String requestLine = in.readLine();
            System.out.println("Request: " + requestLine);

            String body = "<h1>Hello from Mini HTTP Server!</h1>";

            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html");
            out.println("Content-Length: " + body.length());
            out.println();
            out.println(body);
            out.flush();

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}