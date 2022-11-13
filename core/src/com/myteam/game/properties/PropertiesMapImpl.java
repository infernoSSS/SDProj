package com.myteam.game.properties;

import java.util.HashMap;
import java.util.Map;

class PropertiesMapImpl implements Properties{
	private final Map<String, Object> map;

	protected PropertiesMapImpl() {
		map = new HashMap<>();
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
