package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;

public class SimpleServer implements Server {

    private HashMap<String, Double> serverData = new HashMap<>();
    private boolean stop = false;
    private Thread serverThread;

    @Override
    public void listen(int port) {
        serverThread = new Thread(() -> {
            try {

                ServerSocket server = new ServerSocket(port);
                server.setSoTimeout(5000);

                while (!stop) {
                    try {
                        Socket aClient = server.accept(); // blocking call
                        try {
                            handleClient(aClient.getInputStream());
                            aClient.getInputStream().close();
                            aClient.close();

                        } catch (IOException e) {
                            System.out.println("-> Received an IOException: " + e.getMessage());
                        }
                    } catch (SocketTimeoutException e) {
                        System.out.println("-> No client connected within the set timeout, trying again...");
                    }
                }
                System.out.println("-> Closing server");
                server.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        serverThread.start();
    }

    private void handleClient(InputStream inputStream) {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

        String line;

        try {
            while ((line = in.readLine()) != null) {
                System.out.println("Received from simulator: " + line);
                // implement map population
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        stop = true;
    }

    @Override
    public Thread serverThread() {
        return serverThread;
    }

    @Override
    public Map<String, Double> getData() {
        return serverData;
    }
}
