package com.myteam.game.view.units;

import com.myteam.game.controller.screens.battle.data.BattlePosition;

public interface Unit {
	BattlePosition getBattlePosition();

	enum RealiseCondition {
		ROUND_END, SCENE_END, CURRENT_ANIMATION_END
	}
}
