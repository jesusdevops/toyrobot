package com.nasa.toyrobot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class MoveCommandTest {


    private TableTop tableTop = new TableTop(5,5);

    @Test
    public void move_north() {
        ToyRobot toyRobot = new ToyRobot(tableTop);
        toyRobot.setFace(Face.NORTH);
        toyRobot.setPosX(0);
        toyRobot.setPosY(0);
        MoveCommand moveCommand = new MoveCommand(toyRobot);
        moveCommand.execute();
        assertThat(toyRobot.getPosX(),is(0));
        assertThat(toyRobot.getPosY(),is(1));
    }


    @Test
    public void move_east() {
        ToyRobot toyRobot = new ToyRobot(tableTop);
        toyRobot.setFace(Face.EAST);
        toyRobot.setPosX(0);
        toyRobot.setPosY(0);
        MoveCommand moveCommand = new MoveCommand(toyRobot);
        moveCommand.execute();
        assertThat(toyRobot.getPosX(),is(1));
        assertThat(toyRobot.getPosY(),is(0));
    }


    @Test
    public void move_south() {
        ToyRobot toyRobot = new ToyRobot(tableTop);
        toyRobot.setFace(Face.SOUTH);
        toyRobot.setPosX(0);
        toyRobot.setPosY(1);
        MoveCommand moveCommand = new MoveCommand(toyRobot);
        moveCommand.execute();
        assertThat(toyRobot.getPosX(),is(0));
        assertThat(toyRobot.getPosY(),is(0));
    }


    @Test
    public void move_west() {
        ToyRobot toyRobot = new ToyRobot(tableTop);
        toyRobot.setFace(Face.WEST);
        toyRobot.setPosX(1);
        toyRobot.setPosY(0);
        MoveCommand moveCommand = new MoveCommand(toyRobot);
        moveCommand.execute();
        assertThat(toyRobot.getPosX(),is(0));
        assertThat(toyRobot.getPosY(),is(0));
    }
}