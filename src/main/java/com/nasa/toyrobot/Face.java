package com.nasa.toyrobot;

public enum Face {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Face moveLeft() {
        switch(this) {
            case NORTH: return WEST;
            case WEST: return SOUTH;
            case SOUTH: return EAST;
            case EAST: return NORTH;
            default: return NORTH;
        }
    }

    public Face moveRight() {
        switch(this) {
            case NORTH: return EAST;
            case EAST: return SOUTH;
            case SOUTH: return WEST;
            case WEST: return NORTH;
            default: return NORTH;
        }
    }
}
