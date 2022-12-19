package com.myteam.game.view.units.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.myteam.game.controller.screens.battle.data.BattlePosition;
import com.myteam.game.view.screens.battle.events.CurrentAnimationEndEvent;
import com.myteam.game.view.units.Effect;
import com.myteam.game.view.properties.GlobalProperties;
import com.myteam.game.view.utils.InputController;
import com.myteam.game.view.utils.Position;

import java.util.HashMap;
import java.util.Map;

public class EffectImpl implements Effect {
    private static Map<String, TextureRegion[]> cashedRegion = new HashMap<>();

    private TextureRegion[] frames;
    private InputController listener;
    private RealiseCondition condition;

    private final float x;
    private final float y;
    private final float width;
    private final float height;

    private Animation<TextureRegion> animation;
    private boolean isBackground;
    private boolean isExists;
    private float stateTime;

    public EffectImpl(String base, BattlePosition battlePosition, InputController listener, RealiseCondition condition) {
        this.frames = initFrames(base);
        this.listener = listener;
        this.condition = condition;

        Position position = Position.getPositionByBattlePosition(battlePosition);
        if (position.isEnemy()) {
            x = position.getX() + ((Float)GlobalProperties.getInstance().get("effect_width")).intValue();
            width = -(Float) GlobalProperties.getInstance().get("effect_width");
        }
        else {
            x = position.getX();
            width = (Float) GlobalProperties.getInstance().get("effect_width");
        }
        y = position.getY();
        height = (Float) GlobalProperties.getInstance().get("effect_height");

        animation = new Animation<>(0.1f, frames);
        isBackground = false;
        isExists = true;
        stateTime = (float) Math.random() % 100;
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
        return isExists;
    }

    @Override
    public boolean isBackGround() {
        return isBackground;
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
            TextureRegion[][] tmp = region.split((Integer) GlobalProperties.getInstance().get("effect_frame_width"), region.getRegionHeight());
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
        isExists = false;
    }

    private float delta() {
        stateTime += Gdx.graphics.getDeltaTime();
        return stateTime;
    }
}



