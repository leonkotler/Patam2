package commands;

import client.Client;
import server.Server;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;


public class CommandFactory {


    public static final String OPEN_SERVER_COMMAND = "openDataServer";
    public static final String CONNECT_COMMAND = "connect";
    public static final String VARIABLE_ALLOCATION_COMMAND = "var";
    public static final String ASSIGNMENT_COMMAND = "=";
    public static final String WHILE_COMMAND = "while";
    public static final String PRINT_COMMAND = "print";
    private Server server;
    private Client client;
    private Map<String, String> symbolTable;
    private Map<String, Supplier<Command>> commandsSupplierMap;


    public CommandFactory(Server server, Client client, Map<String, String> symbolTable) {
        this.server = server;
        this.client = client;
        this.symbolTable = symbolTable;

        this.commandsSupplierMap = new HashMap<>();

        commandsSupplierMap.put(OPEN_SERVER_COMMAND, () -> new OpenDataServerCommand(this.server));
        commandsSupplierMap.put(CONNECT_COMMAND, () -> new ConnectToClientCommand(this.client));
        commandsSupplierMap.put(VARIABLE_ALLOCATION_COMMAND, () -> new VariableAssignmentCommand(this.client, this.symbolTable));
        commandsSupplierMap.put(ASSIGNMENT_COMMAND, () -> new VariableAssignmentCommand(this.client, this.symbolTable));
        commandsSupplierMap.put(WHILE_COMMAND, () -> new LoopCommand(this.server, this));
        commandsSupplierMap.put(PRINT_COMMAND, () -> new PrintCommand(this.server));
    }

    public Command getCommand(String commandKey) {

        Supplier<Command> commandSupplier = commandsSupplierMap.get(commandKey);

        if (commandSupplier != null) {
            return commandSupplier.get();
        } else {
            // we expect that if it's not any of the commands in the map then it's an assignment command
            return commandsSupplierMap.get(ASSIGNMENT_COMMAND).get();
        }


    }


}
