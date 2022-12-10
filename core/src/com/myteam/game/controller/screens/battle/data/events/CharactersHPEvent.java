package com.myteam.game.controller.screens.battle.data.events;

public class CharactersHPEvent {
	private final int[] charactersId;
	private final int value;

	public CharactersHPEvent(int[] charactersId, int value) {
		this.charactersId = charactersId;
		this.value = value;
	}

	public int[] getCharactersId() {
		return charactersId;
	}

	public int getValue() {
		return value;
	}
}
