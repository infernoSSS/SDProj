package com.myteam.game.controller.screens.battle;

import com.myteam.game.controller.screens.battle.transport.BattleScreenModelRequest;
import com.myteam.game.controller.screens.battle.transport.BattleScreenModelResponse;

public interface BattleScreenController {

	public static BattleScreenController getInstance(ScreenControllerProvider provider) {
		switch (provider){
			case LOCAL:
				return null;
			case SERVER:
				return null;
			default:
				return null;
		}
	}

	public BattleScreenModelResponse getTurn();

	public void sendTurn(BattleScreenModelRequest data);

	public BattleScreenModelResponse turn(BattleScreenModelRequest data);

	enum ScreenControllerProvider {
		LOCAL, SERVER
	}
}
