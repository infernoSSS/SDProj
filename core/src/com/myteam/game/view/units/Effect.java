package com.myteam.game.view.units;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.myteam.game.controller.screens.battle.data.BattlePosition;
import com.myteam.game.view.utils.Position;

public interface Effect extends Unit{
//	Animation getAnimation();
	void draw(SpriteBatch batch);

	boolean isBackGround();

	Position getPosition();
}
