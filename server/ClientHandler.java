package server;

import java.io.*;
import java.net.*;
import java.util.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ClientHandler implements Runnable {

    private Socket socket;
    private Set<ClientHandler> clients;
    private PrintWriter out;
    private BufferedReader in;
    private String username;

    public ClientHandler(Socket socket, Set<ClientHandler> clients) {
        this.socket = socket;
        this.clients = clients;
    }

    public void run() {
        try {

            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Enter your username:");
            username = in.readLine();

            log(username + " joined the chat");
            broadcast(username + " joined the chat");

            String message;

            while ((message = in.readLine()) != null) {
                if (message.startsWith("@")) {
                    // Private messaging: @username message
                    handlePrivateMessage(message);
                } else {
                    log(username + ": " + message);
                    broadcast(username + ": " + message);
                }
            }

        } catch (IOException e) {
            log(username + " disconnected");
        } finally {
            clients.remove(this);
            broadcast(username + " left the chat");
            log(username + " left the chat");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handlePrivateMessage(String message) {
        int spaceIndex = message.indexOf(" ");
        if (spaceIndex != -1) {
            String targetUser = message.substring(1, spaceIndex);
            String privateMsg = message.substring(spaceIndex + 1);

            for (ClientHandler client : clients) {
                if (client.username != null && client.username.equals(targetUser)) {
                    client.out.println("[Private from " + username + "]: " + privateMsg);
                    this.out.println("[Private to " + targetUser + "]: " + privateMsg);
                    log("[Private] " + username + " -> " + targetUser + ": " + privateMsg);
                    return;
                }
            }
            this.out.println("User '" + targetUser + "' not found.");
        }
    }

    private void broadcast(String message) {
        for (ClientHandler client : clients) {
            client.out.println(message);
        }
    }

    private void log(String message) {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("[" + time + "] " + message);
    }

    public String getUsername() {
        return username;
    }
}
