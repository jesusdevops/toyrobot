package com.nasa.toyrobot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.*;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class CommandsExecutorTest {

    private CommandsExecutor commandsExecutor = new CommandsExecutor();
    private TableTop tableTop = new TableTop(5,5);
    private ToyRobot toyRobot = new ToyRobot(tableTop);

    @Test
    public void reports_location_in_table_top() {
        List<String> commandsStr =  Arrays.asList(new String[]{"PLACE 1,2,NORTH","LEFT","MOVE","RIGHT","REPORT"});
        CommandsParser commandsParser = new CommandsParser(commandsStr,toyRobot);
        commandsExecutor.executeCommands(commandsParser.parse());
        assertThat(toyRobot.getPosX(),is(0));
        assertThat(toyRobot.getPosY(),is(2));
        assertThat(toyRobot.getFace(),is(Face.NORTH));
    }

    @Test
    public void prevents_toyRobot_from_falling_of_the_tableTop() {
        List<String> commandsStr =  Arrays.asList(new String[]{"PLACE 4,4,NORTH","MOVE"});
        CommandsParser commandsParser = new CommandsParser(commandsStr,toyRobot);
        commandsExecutor.executeCommands(commandsParser.parse());
        assertThat(toyRobot.getPosX(),is(4));
        assertThat(toyRobot.getPosY(),is(4));
        assertThat(toyRobot.getFace(),is(Face.NORTH));
    }

}