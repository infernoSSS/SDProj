package com.myteam.game.controller.screens.battle.impl;

import com.myteam.game.controller.screens.battle.BattleScreenController;
import com.myteam.game.controller.screens.battle.transport.BattleScreenModelRequest;
import com.myteam.game.controller.screens.battle.transport.BattleScreenModelResponse;

public class BattleScreenControllerLocalImpl implements BattleScreenController {
	@Override
	public BattleScreenModelResponse getTurn() {
		return null;
	}

	@Override
	public void sendTurn(BattleScreenModelRequest data) {

	}

	@Override
	public BattleScreenModelResponse turn(BattleScreenModelRequest data) {
		return null;
	}
}
