package com.myteam.game.view.units;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.myteam.game.controller.screens.battle.data.BattlePosition;

public interface Character extends Unit{
	String getId();

	TextureRegion getTexture(String textureSubName);

	Animation getAnimation();

	void setStatus(Status status);

	Card getCurrentCard();

	void updateCard(int cardNumber, Card card);

	BattlePosition getBattlePosition();

	int getHP();

	static enum Status{

	}
}
