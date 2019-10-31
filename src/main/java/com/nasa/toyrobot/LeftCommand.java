package com.nasa.toyrobot;

/**
 * Class responsible of the execution of a left face turn for the specified ToyRobot.
 */
public class LeftCommand implements Command {

    private final ToyRobot toyRobot;

    public LeftCommand(ToyRobot toyRobot) {
        this.toyRobot = toyRobot;
    }

    public void execute() {
        this.toyRobot.setFace(toyRobot.getFace().moveLeft());
    }
}
