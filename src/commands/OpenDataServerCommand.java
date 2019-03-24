package commands;

import server.Server;

public class OpenDataServerCommand implements Command {

    private Server server;

    public OpenDataServerCommand(Server server) {
        this.server = server;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    @Override
    public void execute(String[] arguments) {
        // open server on ip and port
    }
}
