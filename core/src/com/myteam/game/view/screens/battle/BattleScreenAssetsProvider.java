package com.myteam.game.view.screens.battle;

public class BattleScreenAssetsProvider {
	public static String getBackgroundByMapName(String mapName){
		switch (mapName){
			case("Desert"):
				return "desert";
			default:
				return "desert";
		}
	}

	public static String getMusicThemeBYMapName(String mapName){
		switch (mapName){
			case("Desert"):
				return "MusicLoopBattleScreen.wav";
			default:
				return "MusicLoopBattleScreen.wav";
		}
	}
}
