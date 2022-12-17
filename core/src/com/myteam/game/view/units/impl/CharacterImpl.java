package com.myteam.game.view.units.impl;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.myteam.game.view.units.Card;
import com.myteam.game.view.units.Character;

import java.util.HashMap;
import java.util.Map;

public class CharacterImpl implements Character {
	private String id;
	private int hp;
	private boolean isAlive;
	private RealiseCondition realiseCondition;
	private static Map<String, TextureRegion[]> cashedRegion = new HashMap<>();

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void updateCard(int cardNumber, Card card) {

	}

	@Override
	public boolean isAlive() {
		return isAlive;
	}

	@Override
	public void sendEvent(Object event) {

	}
}
