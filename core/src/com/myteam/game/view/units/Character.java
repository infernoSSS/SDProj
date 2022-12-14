package com.myteam.game.view.units;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.myteam.game.controller.screens.battle.data.BattlePosition;

public interface Character extends Unit{
	String getId();

	void updateCard(int cardNumber, Card card);
}
