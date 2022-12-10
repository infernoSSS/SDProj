package com.myteam.game.controller.screens.battle.transport;

import com.myteam.game.controller.screens.battle.data.CardTransportData;
import com.myteam.game.controller.screens.battle.data.CharacterTransportData;

import java.util.List;
import java.util.Map;

public interface BattleScreenModelResponse {
	public boolean isNewScene();
	public String getMapName();
	public List<CharacterTransportData> getCharacters();
	public Map<CharacterTransportData, List<CardTransportData>> getCards();
	public List<String> getEffectsNames();
	public List<Object> getTurnEvents();
}
