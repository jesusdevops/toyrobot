package com.nasa.toyrobot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(JUnit4.class)
public class CommandsParserTest {

    @Test
    public void number_of_valid_commands() {
        List<String> commandsStr = Arrays.asList(new String[]{"MOVE","PLACE 1,2,NORTH","LEFT","RIGHT","MOVE","REPORT","JUMP"});
        TableTop tableTop = new TableTop(5,5);
        ToyRobot toyRobot = new ToyRobot(tableTop);
        CommandsParser commandsParser = new CommandsParser(commandsStr,toyRobot);
        assertThat(commandsParser.parse().size(),is(5));
    }

    @Test
    public void place_command_has_x_y_f_attributes() {
        List<String> commandsStr = Arrays.asList(new String[]{"PLACE 1,2,NORTH"});
        TableTop tableTop = new TableTop(5,5);
        ToyRobot toyRobot = new ToyRobot(tableTop);
        CommandsParser commandsParser = new CommandsParser(commandsStr,toyRobot);
        List<Command> commands = commandsParser.parse();
        assertThat(((PlaceCommand)commands.get(0)).getX(),is(1));
        assertThat(((PlaceCommand)commands.get(0)).getY(),is(2));
        assertThat(((PlaceCommand)commands.get(0)).getFace(),is(Face.NORTH));
    }

    /**
     * A robot that is not on the table can choose the ignore the MOVE, LEFT, RIGHT and REPORT commands.
     */
    @Test
    public void ignore_commands_when_robot_is_not_on_the_table() {
        List<String> commandsStr = Arrays.asList(new String[]{"PLACE 6,7,NORTH","MOVE","REPORT"});
        TableTop tableTop = new TableTop(5,5);
        ToyRobot toyRobot = new ToyRobot(tableTop);
        CommandsParser commandsParser = new CommandsParser(commandsStr,toyRobot);
        List<Command> commands = commandsParser.parse();
        assertThat(commands.size(),is(0));
    }


}