package com.myteam.game.view.units.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.myteam.game.controller.screens.battle.data.BattlePosition;
import com.myteam.game.view.properties.GlobalProperties;
import com.myteam.game.view.screens.battle.events.CurrentAnimationEndEvent;
import com.myteam.game.view.units.Card;
import com.myteam.game.view.units.Character;
import com.myteam.game.view.utils.InputController;
import com.myteam.game.view.utils.Position;

import java.util.HashMap;
import java.util.Map;

public class CharacterImpl implements Character {
	private static Map<String, TextureRegion[]> cashedRegion = new HashMap<>();

	private String id;
	private TextureRegion[] frames;
	private InputController listener;
	private RealiseCondition condition;

	private final float x;
	private final float y;
	private final float width;
	private final float height;

	private Animation<TextureRegion> animation;
	private boolean isBackground;
	private boolean isAlive;
	private float stateTime;

	public CharacterImpl(String id, String base, BattlePosition battlePosition, InputController listener, RealiseCondition condition) {
		this.id = id;
		this.frames = initFrames(base);
		this.listener = listener;
		this.condition = condition;

		Position position = Position.getPositionByBattlePosition(battlePosition);
		if (position.isEnemy()) {
			x = position.getX() + ((Float)GlobalProperties.getInstance().get("char_width")).intValue();
			width = -(Float) GlobalProperties.getInstance().get("char_width");
		}
		else {
			x = position.getX();
			width = (Float) GlobalProperties.getInstance().get("char_width");
		}
		y = position.getY();
		height = (Float) GlobalProperties.getInstance().get("char_height");

		animation = new Animation<>(0.1f, frames);
		isBackground = false;
		isAlive = true;
		stateTime = (float) Math.random() % 10;
	}

	@Override
	public void draw(SpriteBatch batch) {
		if (isAlive() || !animationFinished()) {
			TextureRegion frame = currentFrame();
			batch.draw(frame, x, y, width, height);
		}
		if (animationEnds()) {
			timeHasCome();
		}
	}

	@Override
	public boolean isAlive() {
		return isAlive;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void updateCard(int cardNumber, Card card) {

	}

	@Override
	public void sendEvent(Object event) {

	}

	// Private

	static private TextureRegion[] initFrames(String name) {
		TextureRegion[] frames = cashedRegion.get(name);
		if (frames == null) {
			TextureAtlas atlas = (TextureAtlas) GlobalProperties.getInstance().get("atlas");
			TextureRegion region = atlas.findRegion(name);
			TextureRegion[][] tmp = region.split((Integer) GlobalProperties.getInstance().get("char_frame_width"), region.getRegionHeight());
			frames = tmp[0];
			cashedRegion.put(name, frames);
		}
		return frames;
	}


	private TextureRegion currentFrame() {
		return animation.getKeyFrame(delta(), isAlive());
	}

	private boolean animationEnds() {
		return condition == RealiseCondition.CURRENT_ANIMATION_END;
	}

	private boolean animationFinished() {
		return animation.isAnimationFinished(delta());
	}

	private void timeHasCome() {
		listener.sendEvent(new CurrentAnimationEndEvent());
		isAlive = false;
	}

	private float delta() {
		stateTime += Gdx.graphics.getDeltaTime();
		return stateTime;
	}
}
