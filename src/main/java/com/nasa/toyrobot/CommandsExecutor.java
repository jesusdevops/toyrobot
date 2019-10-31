package com.nasa.toyrobot;

import java.util.List;

/**
 * Class responsible for the execution a list of commands.
 */
public class CommandsExecutor {

    /**
     * Execute the specified commands. The commands will be executed in the natural order of the list.
     * Note: It will not execute any command until a PLACE command is executed first.
     * @param commands The list of commands to be executed.
     */
    public void executeCommands(List<Command> commands) {
        for(Command command : commands) {
            command.execute();
        }
    }
}
