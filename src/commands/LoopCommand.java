package commands;


import server.Server;

import java.util.List;

public class LoopCommand implements Command {


    private List<Command> commands;
    private Server server;


    public LoopCommand(Server server) {
        this.server = server;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }


    @Override
    public void execute(String[] arguments) {
        // while condition is not fulfilled (check value from server data table)
        //     execute each of the commands
    }
}