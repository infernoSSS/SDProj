package com.myteam.game.model.impl;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.myteam.game.model.Effect;
import com.myteam.game.properties.GlobalProperties;
import com.myteam.game.utils.BattlePosition;

import java.util.HashMap;
import java.util.Map;

public class EffectImpl implements Effect {

    private Animation<TextureRegion> effectAnimation;
    private TextureRegion[] effectFrames;
    private BattlePosition battlePosition;
    private TextureRegion animationRegion;
    private static Map<String, TextureRegion[]> cashedRegion = new HashMap<>();

    @Override
    public Animation getAnimation() {
        return effectAnimation;
    }

    @Override
    public BattlePosition getPosition() {
        return battlePosition;
    }

    public EffectImpl(String name, BattlePosition battlePosition) {
        this.battlePosition = battlePosition;
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
        this(name, new BattlePosition(x, y));
    }

    public static void clear (){
        cashedRegion = new HashMap<>();
    }
}



