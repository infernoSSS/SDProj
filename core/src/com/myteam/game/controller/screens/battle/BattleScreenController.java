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

	public BattleScreenModelResponse getTurn(int battleId);

	public void sendTurn(BattleScreenModelRequest data, int battleId);

	public BattleScreenModelResponse turn(BattleScreenModelRequest data, int battleId);

	enum ScreenControllerProvider {
		LOCAL, SERVER
	}
}
