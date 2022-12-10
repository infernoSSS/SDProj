package com.myteam.game.controller.screens.battle.transport;

import com.myteam.game.controller.screens.battle.data.BattlePosition;

public interface BattleScreenModelRequest {
	public void addEvent(BattleScreenModelRequestEvent e);

	public static class BattleScreenModelRequestEvent{
		private int userId;
		private int cardId;
		private BattlePosition battlePosition;

		public BattleScreenModelRequestEvent(int userId, int cardId, BattlePosition battlePosition) {
			this.userId = userId;
			this.cardId = cardId;
			this.battlePosition = battlePosition;
		}

		public int getUserId() {
			return userId;
		}

		public int getCardId() {
			return cardId;
		}

		public BattlePosition getBattlePosition() {
			return battlePosition;
		}
	}
}
