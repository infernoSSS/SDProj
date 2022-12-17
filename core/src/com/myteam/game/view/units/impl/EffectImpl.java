package com.myteam.game.view.units.impl;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.myteam.game.controller.screens.battle.data.BattlePosition;
import com.myteam.game.view.units.Effect;
import com.myteam.game.view.properties.GlobalProperties;
import com.myteam.game.view.utils.InputController;
import com.myteam.game.view.utils.Position;

import java.util.HashMap;
import java.util.Map;

public class EffectImpl implements Effect {

    private Animation<TextureRegion> effectAnimation;
    private TextureRegion[] effectFrames;
    private BattlePosition battlePosition;
    private TextureRegion animationRegion;
    private InputController listener;
    private static Map<String, TextureRegion[]> cashedRegion = new HashMap<>();
    private boolean isBackground;
    private RealiseCondition realiseCondition;
    private Position position;
    private boolean isAlive;

    public EffectImpl(String name, BattlePosition battlePosition, InputController listener, RealiseCondition realiseCondition) {
        this.realiseCondition = realiseCondition;
        this.isBackground = false;
        this.battlePosition = battlePosition;
        this.position = null;
        effectFrames = cashedRegion.get(name);
        if (effectFrames == null) {
            TextureAtlas atlas = (TextureAtlas) GlobalProperties.getInstance().get("atlas");
            animationRegion = atlas.findRegion(name);
            TextureRegion[][] tmp = animationRegion.split((Integer) GlobalProperties.getInstance().get("effect_width"), animationRegion.getRegionHeight());
            effectFrames = tmp[0];
            cashedRegion.put(name, effectFrames);
        }

        effectAnimation = new Animation<TextureRegion>(0.1f, effectFrames);

        this.isAlive = true;
    }

    public EffectImpl(String name, int x, int y, InputController listener, RealiseCondition realiseCondition) {
        this(name, null, listener, realiseCondition);
        this.isBackground = true;
        this.position = new Position(x, y, false);
    }

    @Override
    public void draw(SpriteBatch batch) {

    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public boolean isBackGround() {
        return isBackground;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    public static void clear (){
        cashedRegion = new HashMap<>();
    }

    @Override
    public void sendEvent(Object event) {

    }
}



