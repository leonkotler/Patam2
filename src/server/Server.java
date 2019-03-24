package server;

import java.util.Map;

public interface Server {

    void listen(int port);
    Map<String, Double> getData();
}
