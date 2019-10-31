package com.nasa.toyrobot;

public class ReportCommand implements Command {

    private final ToyRobot toyRobot;

    public ReportCommand(ToyRobot toyRobot) {
        this.toyRobot = toyRobot;
    }

    @Override
    public void execute() {
        System.out.println(toyRobot);
    }
}
