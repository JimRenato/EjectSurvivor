package com.rsm;

public class Player {

	private String name;
	private Integer currentCabin;
	private boolean alive = true;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public Integer getCurrentCabin() {
		return currentCabin;
	}

	public void setCurrentCabin(Integer currentCabin) {
		this.currentCabin = currentCabin;
	}

}
