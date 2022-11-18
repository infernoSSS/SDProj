package com.myteam.game.properties;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.HashMap;
import java.util.Map;

class PropertiesMapImpl implements Properties {
    private final Map<String, Object> map;

    protected PropertiesMapImpl() {
        map = new HashMap<>();
        map.put("atlas", new TextureAtlas(Gdx.files.internal("atlas.atlas")));
        map.put("effect_width", 32);
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
