package commands;

import client.Client;
import server.Server;

import java.util.Map;


public class CommandBuilder {


    private Server server;
    private Client client;
    private Map<String, String> symbolTable;

    public static final String OPEN_SERVER_COMMAND = "openDataServer";
    public static final String CONNECT_COMMAND = "connect";
    public static final String VARIABLE_ALLOCATION_COMMAND = "var";
    public static final String ASSIGNMENT_COMMAND = "=";
    public static final String WHILE_COMMAND = "while";
    public static final String PRINT_COMMAND = "print";


    public CommandBuilder(Server server, Client client, Map<String, String> symbolTable) {
        this.server = server;
        this.client = client;
        this.symbolTable = symbolTable;
    }


    public Command getCommand(String key) {

        switch (key) {
            case OPEN_SERVER_COMMAND:
                return new OpenDataServerCommand(server);
            case CONNECT_COMMAND:
                return new ConnectToClientCommand(client);
            case VARIABLE_ALLOCATION_COMMAND:
                return new VariableDeclarationCommand(symbolTable);
            case ASSIGNMENT_COMMAND:
                return new VariableAssignmentCommand(client, symbolTable);
            case WHILE_COMMAND:
                return new LoopCommand(server, this);
            case PRINT_COMMAND:
                return new PrintCommand(server);
            default:
                return new VariableAssignmentCommand(client, symbolTable);
        }

    }


}
