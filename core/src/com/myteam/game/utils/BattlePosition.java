package com.myteam.game.utils;

public class BattlePosition {
	public static final BattlePosition PLAYER_SECOND_ROW_DOWN = new BattlePosition(20, 60);
	public static final BattlePosition PLAYER_SECOND_ROW_TOP = new BattlePosition(20, 150);
	public static final BattlePosition PLAYER_FIRS_ROW_DOWN = new BattlePosition(100, 10);
	public static final BattlePosition PLAYER_FIRS_ROW_MIDDLE = new BattlePosition(100, 90);
	public static final BattlePosition PLAYER_FIRS_ROW_TOP = new BattlePosition(100, 170);

	public static final BattlePosition ENEMY_SECOND_ROW_DOWN = new BattlePosition(1180, 60);
	public static final BattlePosition ENEMY_SECOND_ROW_TOP = new BattlePosition(1180, 150);
	public static final BattlePosition ENEMY_FIRS_ROW_DOWN = new BattlePosition(1080, 10);
	public static final BattlePosition ENEMY_FIRS_ROW_MIDDLE = new BattlePosition(1080, 90);
	public static final BattlePosition ENEMY_FIRS_ROW_TOP = new BattlePosition(1080, 170);

	private final int x;
	private final int y;

	private BattlePosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
