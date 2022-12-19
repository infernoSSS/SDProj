package com.myteam.game.view.utils;

import com.myteam.game.controller.screens.battle.data.BattlePosition;
import com.badlogic.gdx.Gdx;
import com.myteam.game.view.properties.GlobalProperties;

public class Position {

	public static Position getPositionByBattlePosition(BattlePosition battlePosition){
		switch (battlePosition){
			case PLAYER_SECOND_ROW_DOWN:
				return new Position(20, 150, false);
			case PLAYER_SECOND_ROW_TOP:
				return new Position(20, 355, false);
			case PLAYER_FIRS_ROW_DOWN:
				return new Position(168, 35, false);
			case PLAYER_FIRS_ROW_MIDDLE:
				return new Position(168, 235, false);
			case PLAYER_FIRS_ROW_TOP:
				return new Position(168, 460, false);
			case ENEMY_SECOND_ROW_DOWN:
				return new Position(1060, 150, true);
			case ENEMY_SECOND_ROW_TOP:
				return new Position(1060, 355, true);
			case ENEMY_FIRS_ROW_DOWN:
				return new Position(910, 35, true);
			case ENEMY_FIRS_ROW_MIDDLE:
				return new Position(910, 235, true);
			case ENEMY_FIRS_ROW_TOP:
				return new Position(910, 460, true);

			default:
				return new Position(0, 0, false);
		}
	}

	private final int x;
	private final int y;
	private final boolean isEnemy;


	public Position(int x, int y, boolean isEnemy) {
		this.x = (int) (x * (Float) GlobalProperties.getInstance().get("k"))  + ((Float) GlobalProperties.getInstance().get("offset")).intValue();
		this.y = (int) (y * (Float) GlobalProperties.getInstance().get("k"));
		this.isEnemy = isEnemy;
	}

	@Override
	public String toString() {
		return "BattlePosition{" +
				"x=" + x +
				", y=" + y +
				'}';
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isEnemy() {
		return isEnemy;
	}
}
