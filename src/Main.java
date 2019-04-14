import client.Client;
import client.SimpleClient;
import server.Server;
import server.SimpleServer;

public class Main {

    public static void main(String[] args) {

        try {

            Client client = new SimpleClient();
            Server server = new SimpleServer();

            client.connect("127.0.0.1", 5402);
            server.listen(5400);


            double number = 1;

//            for (int i = 0; i < 10; i++) {
//
//                client.set("controls/flight/rudder", number);
//
//                number *= -1;
//
//                Thread.sleep(1000);
//            }


            server.serverThread().join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
