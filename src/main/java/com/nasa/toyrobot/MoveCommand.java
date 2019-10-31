package com.nasa.toyrobot;

/**
 * Class responsible of the execution of a position move
 * for the specified ToyRobot depending on its current face direction.
 */
public class MoveCommand implements Command {

    private final ToyRobot toyRobot;

    public MoveCommand(ToyRobot toyRobot) {
        this.toyRobot = toyRobot;
    }

    public void execute() {
        switch (toyRobot.getFace()) {
            case EAST: moveEast();
                break;
            case WEST: moveWest();
                break;
            case NORTH: moveNorth();
                break;
            case SOUTH: moveSouth();
                break;
        }
    }

    private void moveSouth() {
        if(toyRobot.getPosY() - 1 >= 0) {
            toyRobot.setPosY(toyRobot.getPosY() - 1);
        }
    }

    private void moveNorth() {
        if((toyRobot.getPosY() + 1) <= toyRobot.getTableTop().getLength()-1) {
            toyRobot.setPosY(toyRobot.getPosY() + 1);
        }
    }

    private void moveWest() {
        if(toyRobot.getPosX() - 1 >= 0) {
            toyRobot.setPosX(toyRobot.getPosX() - 1);
        }
    }

    private void moveEast() {
        if(toyRobot.getPosX() + 1 <= toyRobot.getTableTop().getWidth()-1) {
            toyRobot.setPosX(toyRobot.getPosX() + 1);
        }
    }
}
