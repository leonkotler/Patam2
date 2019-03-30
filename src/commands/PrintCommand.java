package commands;


import server.Server;

public class PrintCommand implements Command {

    private Server server;

    public PrintCommand(Server server) {
        this.server = server;
    }


    @Override
    public void execute(String[] arguments) {
        // validate arguments
        System.out.println(server.getData().get(arguments[1]));
    }
}
