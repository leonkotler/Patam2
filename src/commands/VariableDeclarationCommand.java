package commands;

import java.util.Map;

public class VariableDeclarationCommand implements Command {

    private Map<String, String> symbolTable;

    public VariableDeclarationCommand(Map<String, String> symbolTable) {
        this.symbolTable = symbolTable;
    }

    @Override
    public void execute(String[] arguments) {
        // validate arguments
        symbolTable.put(arguments[1], arguments[4]);
    }
}
