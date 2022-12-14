package com.myteam.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.myteam.game.view.properties.GlobalProperties;
import com.myteam.game.view.screens.battle.BattleScreen;


public class SDGame extends Game {
	BitmapFont font;

	public void create() {

		// libGDX по умолчанию использует Arial шрифт.
		font = new BitmapFont();
		GlobalProperties.getInstance().put("offset" , (Gdx.graphics.getWidth()-((float) GlobalProperties.getInstance().get("screen_width") * ((Float) GlobalProperties.getInstance().get("k"))))/2,false);
     	this.setScreen(new BattleScreen(this));
	}

	public void render() {

		super.render(); // важно!
	}

	public void dispose() {
	}
}

