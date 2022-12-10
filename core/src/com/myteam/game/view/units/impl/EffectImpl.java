package com.myteam.game.view.units.impl;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.myteam.game.controller.screens.battle.data.BattlePosition;
import com.myteam.game.view.units.Effect;
import com.myteam.game.view.properties.GlobalProperties;
import com.myteam.game.view.utils.Position;

import java.util.HashMap;
import java.util.Map;

public class EffectImpl implements Effect {

    private Animation<TextureRegion> effectAnimation;
    private TextureRegion[] effectFrames;
    private BattlePosition battlePosition;
    private TextureRegion animationRegion;
    private static Map<String, TextureRegion[]> cashedRegion = new HashMap<>();
    private boolean isBackground;
    private Position position;

    @Override
    public Animation getAnimation() {
        return effectAnimation;
    }

    @Override
    public BattlePosition getBattlePosition() {
        return battlePosition;
    }

    @Override
    public boolean isBackGround() {
        return isBackground;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    public EffectImpl(String name, BattlePosition battlePosition) {
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
    }

    public EffectImpl(String name, int x, int y) {
        this(name, null);
        this.isBackground = true;
        this.position = new Position(x, y, false);
    }

    public static void clear (){
        cashedRegion = new HashMap<>();
    }
}



