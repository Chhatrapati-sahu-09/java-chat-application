package server;

import java.io.*;
import java.net.*;
import java.util.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ChatServer {

    private static final int PORT = 12345;
    private static Set<ClientHandler> clients = new HashSet<>();

    public static void main(String[] args) {
        log("Server started...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            while (true) {
                Socket socket = serverSocket.accept();
                log("New client connected");

                ClientHandler client = new ClientHandler(socket, clients);
                clients.add(client);

                new Thread(client).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(String message) {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("[" + time + "] " + message);
    }
}
