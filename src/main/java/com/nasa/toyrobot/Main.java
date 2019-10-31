package com.nasa.toyrobot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    private static final int LENGTH = 5;
    private static final int WIDTH = 5;

    public static void main(String... args) throws IOException {

        if(args.length == 0) throw new IllegalArgumentException("You need to provide a valid file path.");

        TableTop tableTop = new TableTop(LENGTH, WIDTH);

        ToyRobot toyRobot = new ToyRobot(tableTop);

        CommandsParser commandsParser = new CommandsParser(Files.readAllLines(Paths.get(args[0])), toyRobot);

        CommandsExecutor commandsExecutor = new CommandsExecutor();

        commandsExecutor.executeCommands(commandsParser.parse());
    }
}
