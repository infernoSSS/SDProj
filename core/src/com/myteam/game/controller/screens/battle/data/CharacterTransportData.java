package com.myteam.game.controller.screens.battle.data;

public class CharacterTransportData {
	private int id;
	private int maxHp;
	private String name;
	private boolean alive;

	public CharacterTransportData(int id, int maxHp, String name, boolean alive) {
		this.id = id;
		this.maxHp = maxHp;
		this.name = name;
		this.alive = alive;
	}

	public int getId() {
		return id;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public String getName() {
		return name;
	}

	public boolean isAlive() {
		return alive;
	}

	@Override
	public int hashCode() {
		return id;
	}
}
