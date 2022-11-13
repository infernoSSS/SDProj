package com.myteam.game.model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.myteam.game.utils.BattlePosition;

public interface Character {
	String getId();

	TextureRegion getTexture(String textureSubName);

	Animation getStandAnimation();

	Animation getRunAnimation();

	Animation getFightAnimation();

	Card getCard(String cardName);

	BattlePosition getPosition();

	int getHP();
}
