package com.rsm;

class Player {

    private String name;
    private Integer currentCabin;
    private boolean alive = true;

    Player(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    boolean isAlive() {
        return alive;
    }

    void setAlive(boolean alive) {
        this.alive = alive;
    }

    Integer getCurrentCabin() {
        return currentCabin;
    }

    void setCurrentCabin(Integer currentCabin) {
        this.currentCabin = currentCabin;
    }

}
