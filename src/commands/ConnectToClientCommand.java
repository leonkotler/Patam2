package commands;

import client.Client;

public class ConnectToClientCommand implements Command {

    private Client client;

    public ConnectToClientCommand(Client client) {
        this.client = client;
    }


    @Override
    public void execute(String[] arguments) {

    }


}
