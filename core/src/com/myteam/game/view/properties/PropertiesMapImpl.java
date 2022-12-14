package com.myteam.game.view.properties;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.HashMap;
import java.util.Map;

class PropertiesMapImpl implements Properties {
    private final Map<String, Object> map;

    protected PropertiesMapImpl() {
        map = new HashMap<>();
        map.put("atlas", new TextureAtlas(Gdx.files.internal("atlas.atlas")));
        map.put("effect_width", 50);
        map.put("screen_height", 720.0f);
        map.put("screen_width", 1240.0f);
        map.put("k",Gdx.graphics.getHeight() / (float) GlobalProperties.getInstance().get("screen_height"));
    }

    @Override
    public Object get(String key) {
        return map.get(key);
    }

    @Override
    public void put(String key, Object value, boolean hardStore) {
        map.put(key, value);
    }
}
