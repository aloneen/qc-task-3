package kz.seisen.task4;

public class Main {

    public static void main(String[] args) throws Exception {
        HttpServer server = new HttpServer(8080);
        server.start();
    }
}