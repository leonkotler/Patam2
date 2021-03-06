package commands;

import client.Client;

import java.util.Map;

public class VariableAssignmentCommand implements Command {

    private Client client;
    private Map<String, String> symbolTable;

    public VariableAssignmentCommand(Client client, Map<String, String> symbolTable) {
        this.client = client;
        this.symbolTable = symbolTable;
    }

    @Override
    public void execute(String[] arguments) {
        // get path from symbolTable
        // send assignment to client
    }
}
