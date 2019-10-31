package com.nasa.toyrobot;

/**
 * Class responsible of the execution of setting the initial position and face direction for the specified ToyRobot.
 */
public class PlaceCommand implements Command {

    private final Face face;
    private final int y;
    private final int x;
    private final ToyRobot toyRobot;

    public PlaceCommand(ToyRobot toyRobot, int x, int y, Face face) {
        this.toyRobot = toyRobot;
        this.x = x;
        this.y = y;
        this.face = face;
    }

    @Override
    public void execute() {
        if(x <= toyRobot.getTableTop().getWidth() -1 && y <= toyRobot.getTableTop().getLength() -1) {
            toyRobot.setPosX(x);
            toyRobot.setPosY(y);
            toyRobot.setFace(face);
        }
    }

    public Face getFace() {
        return face;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
