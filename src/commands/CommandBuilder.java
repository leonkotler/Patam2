package commands;

import client.Client;
import server.Server;

import java.util.HashMap;
import java.util.Map;

public class CommandBuilder {


    private Server server;
    private Client client;
    private Map<String, String> symbolTable;


    public CommandBuilder(Server server, Client client, Map<String, String> symbolTable) {
        this.server = server;
        this.client = client;
        this.symbolTable = symbolTable;
    }


    public Command getCommand(String key) {

        switch (key) {
            case "openDataServer":
                return new OpenDataServerCommand(server);
            case "connect":
                return new ConnectToClientCommand(client);
            case "var":
                return new VariableDeclarationCommand(symbolTable);
            case "=":
                return new VariableAssignmentCommand(client);
            case "while":
                return new LoopCommand(symbolTable);
            case "print":
                return new PrintCommand(server);
            default:
                return null;
        }

    }


}
