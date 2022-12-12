package com.myteam.game.properties;

import java.util.Optional;

public interface Properties {
	Object get(String key);
	void put(String key, Object value, boolean hardStore);
	//"hardStore" means value mast be stored between launches also
}
