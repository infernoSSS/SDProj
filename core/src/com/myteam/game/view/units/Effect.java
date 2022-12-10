package com.myteam.game.view.units;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.myteam.game.controller.screens.battle.data.BattlePosition;
import com.myteam.game.view.utils.Position;

public interface Effect extends Unit{
	Animation getAnimation();

	BattlePosition getBattlePosition();

	boolean isBackGround();

	Position getPosition();
}
