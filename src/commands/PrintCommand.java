package commands;


import server.Server;

public class PrintCommand implements Command {

    private Server server;

    public PrintCommand(Server server) {
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

        // get variable from serverData
        // print variable
    }
}
