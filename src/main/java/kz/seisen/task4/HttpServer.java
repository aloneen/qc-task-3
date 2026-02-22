package kz.seisen.task4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    private final int port;

    public HttpServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Server started on port " + port);

            while (true) {

                Socket socket = serverSocket.accept();
                System.out.println("New connection: " + socket.getInetAddress());

                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        }
    }
}