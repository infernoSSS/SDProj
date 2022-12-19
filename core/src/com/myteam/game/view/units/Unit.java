package com.myteam.game.view.units;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.myteam.game.controller.screens.battle.data.BattlePosition;
import com.myteam.game.view.utils.Listener;

public interface Unit extends Listener {
	boolean isAlive();

	void draw(SpriteBatch batch);

	enum RealiseCondition {
		ROUND_END, SCENE_END, CURRENT_ANIMATION_END
	}
}
