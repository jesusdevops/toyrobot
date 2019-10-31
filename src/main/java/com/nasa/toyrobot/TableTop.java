package com.nasa.toyrobot;

/**
 * Class responsible of defining the moving area for a ToyRobot
 */
public class TableTop {

    private final int length;
    private final int width;

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public TableTop(int length, int width) {
        this.length = length;
        this.width = width;
    }
}
