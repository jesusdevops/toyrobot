package com.nasa.toyrobot;

/**
 * Class that holds to position and face direction of this ToyRobot
 */
public class ToyRobot {

    private final TableTop tableTop;
    private int posX = -1;
    private int posY = -1;
    private Face face = null;

    @Override
    public String toString() {
        return String.format("%s,%s,%s",posX,posY,face);
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Face getFace() {
        return face;
    }

    public TableTop getTableTop() {
        return tableTop;
    }

    public ToyRobot(TableTop tableTop) {
        this.tableTop = tableTop;
    }

    public void setPosY(int val) {
        this.posY = val;
    }

    public void setPosX(int val) {
        this.posX = val;
    }

    public void setFace(Face face) {
        this.face = face;
    }
}
