package com.myteam.game.view.properties;

public final class GlobalProperties {
	private static Properties properties = null;
	private GlobalProperties(){

	}

	public static Properties getInstance(){
		if(properties == null){
			properties = new PropertiesMapImpl();
		}
		return properties;
	}
}
