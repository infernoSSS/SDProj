package com.myteam.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.myteam.game.screens.battle.BattleScreen;


public class SDGame extends Game {
	BitmapFont font;

	public void create() {

		// libGDX по умолчанию использует Arial шрифт.
		font = new BitmapFont();
     	this.setScreen(new BattleScreen(this));
	}

	public void render() {

		super.render(); // важно!
	}

	public void dispose() {
	}
}

