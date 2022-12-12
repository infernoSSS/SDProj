package com.myteam.game.model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public interface Card {
	String getId();

	TextureRegion getTexture();

	Effect getEffect();
}
