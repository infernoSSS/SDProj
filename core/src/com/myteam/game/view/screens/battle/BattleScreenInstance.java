package com.myteam.game.view.screens.battle;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.myteam.game.controller.screens.battle.BattleScreenController;
import com.myteam.game.controller.screens.battle.data.CharacterTransportData;
import com.myteam.game.controller.screens.battle.impl.BattleScreenControllerLocalImpl;
import com.myteam.game.controller.screens.battle.transport.BattleScreenModelResponse;
import com.myteam.game.view.utils.InputController;
import com.myteam.game.view.utils.Listener;
import com.myteam.game.view.units.Card;
import com.myteam.game.view.units.Character;
import com.myteam.game.view.units.Effect;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BattleScreenInstance implements Listener {
	private int battleId;
	private BattleScreenController controller;
	private TextureAtlas atlas;
	private InputController listener;
	private String background;
	private String musicTheme;
	private List<Effect> effects;
	private List<Card> cards;
	private List<Character> characters;

	public BattleScreenInstance(int battleId, TextureAtlas atlas, InputController listener) {
		this.battleId = battleId;
		this.atlas = atlas;
		this.listener = listener;
		controller = new BattleScreenControllerLocalImpl();

		characters = new ArrayList<>();
	}

	public String getMusicName(){
		return musicTheme;
	}

	public String getBackgroundName(){
		return background;
	}

	public List<Effect> getEffects(){
		return effects;
	}

	public List<Card> getDeck(){
		return null;
	}

	public List<Card> getTurn(){
		return null;
	}

	public List<Character> getCharacters(){
		return null;
	}

	public void lockCard(int n){

	}

	public void reRoll(){

	}

	private void doTurn(){
		BattleScreenModelResponse response = controller.getTurn(battleId);
		if(response.isNewScene()){

		}
	}

	private void newScene(){
		BattleScreenModelResponse response = controller.getTurn(battleId);
		background = BattleScreenAssetsProvider.getBackgroundByMapName(response.getMapName());
		musicTheme = BattleScreenAssetsProvider.getMusicThemeBYMapName(response.getMapName());
		for(CharacterTransportData charData : response.getCharacters()){

		}
	}

	public void sendEvent(Object event){

	}
}
