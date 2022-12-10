package com.myteam.game.view.screens.battle;

import com.myteam.game.view.utils.Listener;
import com.myteam.game.view.units.Card;
import com.myteam.game.view.units.Character;
import com.myteam.game.view.units.Effect;

import java.util.List;

public class BattleScreenInstance implements Listener {
	public String getMusicName(){
		return "MusicLoopBattleScreen.wav";
	}

	public String getBackgroundName(){
		return "BG1_1";
	}

	public List<Effect> getEffects(){
		return null;
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

	public void doTurn(){

	}

	public void newTurn(){

	}

	public void sendEvent(Object event){

	}
}
