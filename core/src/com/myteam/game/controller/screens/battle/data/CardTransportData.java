package com.myteam.game.controller.screens.battle.data;

public class CardTransportData {
	private int id;
	private String name;
	private String layout;
	private String description;

	public CardTransportData(int id, String name, String layout, String description) {
		this.id = id;
		this.name = name;
		this.layout = layout;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLayout() {
		return layout;
	}

	public String getDescription() {
		return description;
	}
}
