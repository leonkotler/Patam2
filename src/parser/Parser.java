package parser;


import commands.Command;
import commands.CommandBuilder;

import java.util.Map;

public class Parser {


    private CommandBuilder commandBuilder;
    private String reservedSymbols = "{}()<>=+-*/";
    private Map<String, Double> symbolTable;

    public Parser(CommandBuilder commandBuilder, Map<String, Double> symbolTable) {
        this.commandBuilder = commandBuilder;
        this.symbolTable = symbolTable;
    }

    public void parse(String[] line) {


        Command command = commandBuilder.getCommand(line[0]);
        command.execute(line);

    }


    public String[] parseVariablesFromLine(String[] line) {


        // we iterate over each word in the line an parse it variables to their values in the symbol table
        // note that we start from index=1 to avoid the command names amd the variable that is being assigned to
        for (int i = 1; i < line.length; i++) {

            String currentWord = line[i];

            if (!isANumber(currentWord) && !reservedSymbols.contains(currentWord)) { // not already a number or a reserved symbol
                line[i] = symbolTable.get(currentWord).toString(); // get variable from symbol table
            }
        }

        return line;
    }

    public boolean isANumber(String word) {
        try {
            Double.parseDouble(word);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
