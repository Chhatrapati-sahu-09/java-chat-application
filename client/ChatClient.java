package client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {

        try (
                Socket socket = new Socket(SERVER_ADDRESS, PORT);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(
                        socket.getOutputStream(), true);
                Scanner scanner = new Scanner(System.in)) {

            // Receive username prompt
            System.out.println(in.readLine());

            String username = scanner.nextLine();
            out.println(username);

            // Thread to receive messages
            new Thread(() -> {
                String response;
                try {
                    while ((response = in.readLine()) != null) {
                        System.out.println(response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            // Send messages
            while (scanner.hasNextLine()) {
                out.println(scanner.nextLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
