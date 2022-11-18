package com.myteam.game.model;

import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.myteam.game.utils.BattlePosition;

public interface Effect {
	Animation getAnimation();

	BattlePosition getPosition();
}
