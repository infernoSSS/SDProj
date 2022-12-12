package com.myteam.game.utils;

import com.badlogic.gdx.Gdx;
import com.myteam.game.properties.GlobalProperties;

public class BattlePosition {
	public static BattlePosition PLAYER_SECOND_ROW_DOWN = new BattlePosition(
			(int) (20 * ((float) Gdx.graphics.getWidth() / (float) GlobalProperties.getInstance().get("screen_width")))+((Float)GlobalProperties.getInstance().get("offset")).intValue(),
			(int) (150 * ((float) Gdx.graphics.getHeight() / (float) GlobalProperties.getInstance().get("screen_height"))));

	public static BattlePosition PLAYER_SECOND_ROW_TOP = new BattlePosition(
			(int) (20 * ((float) Gdx.graphics.getWidth() / (float) GlobalProperties.getInstance().get("screen_width")))+((Float)GlobalProperties.getInstance().get("offset")).intValue(),
			(int) (355 * ((float) Gdx.graphics.getHeight() / (float) GlobalProperties.getInstance().get("screen_height"))));

	public static BattlePosition PLAYER_FIRS_ROW_DOWN = new BattlePosition(
			(int) (168 * ((float) Gdx.graphics.getWidth() / (float) GlobalProperties.getInstance().get("screen_width")))+((Float)GlobalProperties.getInstance().get("offset")).intValue(),//900
			(int) (35 * ((float) Gdx.graphics.getHeight() / (float) GlobalProperties.getInstance().get("screen_height"))));

	public static BattlePosition PLAYER_FIRS_ROW_MIDDLE = new BattlePosition(
			(int) (168 * ((float) Gdx.graphics.getWidth() / (float) GlobalProperties.getInstance().get("screen_width")))+((Float)GlobalProperties.getInstance().get("offset")).intValue(),//900
			(int) (235 * ((float) Gdx.graphics.getHeight() / (float) GlobalProperties.getInstance().get("screen_height"))));

	public static BattlePosition PLAYER_FIRS_ROW_TOP = new BattlePosition(
			(int) (168 * ((float) Gdx.graphics.getWidth() / (float) GlobalProperties.getInstance().get("screen_width")))+((Float)GlobalProperties.getInstance().get("offset")).intValue(),//900
			(int) (460 * ((float) Gdx.graphics.getHeight() / (float) GlobalProperties.getInstance().get("screen_height"))));

	public static BattlePosition ENEMY_SECOND_ROW_DOWN = new BattlePosition(
			(int) (1060 * ((float) Gdx.graphics.getWidth() / (float) GlobalProperties.getInstance().get("screen_width")))-((Float)GlobalProperties.getInstance().get("offset")).intValue(),
			(int) (150 * ((float) Gdx.graphics.getHeight() / (float) GlobalProperties.getInstance().get("screen_height"))));

	public static BattlePosition ENEMY_SECOND_ROW_TOP = new BattlePosition(
			(int) (1060 * ((float) Gdx.graphics.getWidth() / (float) GlobalProperties.getInstance().get("screen_width")))-((Float)GlobalProperties.getInstance().get("offset")).intValue(),
			(int) (355 * ((float) Gdx.graphics.getHeight() / (float) GlobalProperties.getInstance().get("screen_height"))));

	public static BattlePosition ENEMY_FIRS_ROW_DOWN = new BattlePosition(
			(int) (910 * ((float) Gdx.graphics.getWidth() / (float) GlobalProperties.getInstance().get("screen_width")))-((Float)GlobalProperties.getInstance().get("offset")).intValue(),//900
			(int) (35 * ((float) Gdx.graphics.getHeight() / (float) GlobalProperties.getInstance().get("screen_height"))));

	public static BattlePosition ENEMY_FIRS_ROW_MIDDLE = new BattlePosition(
			(int) (910 * ((float) Gdx.graphics.getWidth() / (float) GlobalProperties.getInstance().get("screen_width")))-((Float)GlobalProperties.getInstance().get("offset")).intValue(),//900
			(int) (235 * ((float) Gdx.graphics.getHeight() / (float) GlobalProperties.getInstance().get("screen_height"))));

	public static BattlePosition ENEMY_FIRS_ROW_TOP = new BattlePosition(
			(int) (910 * ((float) Gdx.graphics.getWidth() / (float) GlobalProperties.getInstance().get("screen_width")))-((Float)GlobalProperties.getInstance().get("offset")).intValue(),//900
			(int) (460 * ((float) Gdx.graphics.getHeight() / (float) GlobalProperties.getInstance().get("screen_height"))));

	private final int x;
	private final int y;

	public BattlePosition(int x, int y) {
		this.x = x;
		this.y = y;
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
}
