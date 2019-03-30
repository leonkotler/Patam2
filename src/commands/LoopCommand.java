package commands;


import server.Server;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LoopCommand implements Command {


    private CommandBuilder commandBuilder;
    private Server server;


    public LoopCommand(Server server, CommandBuilder commandBuilder) {
        this.server = server;
        this.commandBuilder = commandBuilder;
    }


    @Override
    public void execute(String[] arguments) {

        // validate arguments

        String variable = arguments[1];
        String operator = arguments[2];
        String value = arguments[3];

        List<String[]> listOfCommands = convertArgumentsToListOfCommands(Arrays.toString(arguments));


        while (condition(variable, operator, value)) {
            listOfCommands.forEach(command -> commandBuilder.getCommand(command[0]).execute(command));
        }

    }

    private boolean condition(String variable, String operator, String value) {

        switch (operator) {
            case "<":
                return server.getData().get(variable) < Double.valueOf(value);
            case ">":
                return server.getData().get(variable) > Double.valueOf(value);
            case "<=":
                return server.getData().get(variable) <= Double.valueOf(value);
            case ">=":
                return server.getData().get(variable) >= Double.valueOf(value);
            case "==":
                return server.getData().get(variable).equals(Double.valueOf(value));
            case "!=":
                return !server.getData().get(variable).equals(Double.valueOf(value));
            default:
                return false;
        }

    }

    private List<String[]> convertArgumentsToListOfCommands(String argumentsAsString) {

        // first line is while condition, last is line "}" - therefore we remove them
        List<String> listOfLines = Arrays.asList(argumentsAsString.split("\n"));

        listOfLines.remove(0);
        listOfLines.remove(listOfLines.size());

        return listOfLines
                .stream()
                .map(line -> line.split(" "))
                .collect(Collectors.toList());
    }
}