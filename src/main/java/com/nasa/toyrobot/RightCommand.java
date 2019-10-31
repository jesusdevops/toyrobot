package com.nasa.toyrobot;

/**
 * Class responsible of the execution of a right face turn for the specified ToyRobot
 */
public class RightCommand implements Command {

    private final ToyRobot toyRobot;

    public RightCommand(ToyRobot toyRobot) {
        this.toyRobot = toyRobot;
    }

    public void execute() {
        this.toyRobot.setFace(toyRobot.getFace().moveRight());
    }
}
