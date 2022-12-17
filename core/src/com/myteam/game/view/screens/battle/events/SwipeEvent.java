package com.myteam.game.view.screens.battle.events;

public class SwipeEvent {
	private Direction direction;

	public SwipeEvent(Direction direction) {
		this.direction = direction;
	}

	public Direction getDirection() {
		return direction;
	}

	public enum Direction{
		UP, DOWN, RIGHT, LEFT
	}
}
