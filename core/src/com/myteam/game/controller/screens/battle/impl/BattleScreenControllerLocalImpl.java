package com.myteam.game.controller.screens.battle.impl;

import com.myteam.game.controller.screens.battle.BattleScreenController;
import com.myteam.game.controller.screens.battle.transport.BattleScreenModelRequest;
import com.myteam.game.controller.screens.battle.transport.BattleScreenModelResponse;

public class BattleScreenControllerLocalImpl implements BattleScreenController {
	@Override
	public BattleScreenModelResponse getTurn(int battleId) {
		return null;
	}

	@Override
	public void sendTurn(BattleScreenModelRequest data, int battleId) {

	}

	@Override
	public BattleScreenModelResponse turn(BattleScreenModelRequest data, int battleId) {
		return null;
	}
}
