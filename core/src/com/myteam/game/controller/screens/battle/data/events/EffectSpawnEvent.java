package com.myteam.game.controller.screens.battle.data.events;

import com.myteam.game.controller.screens.battle.data.EffectReleaseCondition;

public class EffectSpawnEvent {
	private final String eventName;
	private final int[] targetsCharacterId;
	private final EffectReleaseCondition releaseCondition;

	public EffectSpawnEvent(String eventName, int[] targetsCharacterId, EffectReleaseCondition releaseCondition) {
		this.eventName = eventName;
		this.targetsCharacterId = targetsCharacterId;
		this.releaseCondition = releaseCondition;
	}

	public String getEventName() {
		return eventName;
	}

	public int[] getTargetsCharacterId() {
		return targetsCharacterId;
	}

	public EffectReleaseCondition getReleaseCondition() {
		return releaseCondition;
	}
}
