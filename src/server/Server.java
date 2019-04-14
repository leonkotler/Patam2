package server;

import java.util.Map;

public interface Server {

    void listen(int port);

    void stop();

    Thread serverThread();
    Map<String, Double> getData();
}
