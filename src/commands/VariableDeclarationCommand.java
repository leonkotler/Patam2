package commands;

import java.util.Map;

public class VariableDeclarationCommand implements Command {

    private Map<String, String> symbolTable;

    public VariableDeclarationCommand(Map<String, String> symbolTable) {
        this.symbolTable = symbolTable;
    }

    public Map<String, String> getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(Map<String, String> symbolTable) {
        this.symbolTable = symbolTable;
    }

    @Override
    public void execute(String[] arguments) {
        // put variable in symbolTable
    }
}
