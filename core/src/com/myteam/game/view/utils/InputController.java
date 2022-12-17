package com.myteam.game.view.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Rectangle;
import com.myteam.game.view.properties.GlobalProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputController implements InputProcessor {
	private Map<Class, List<Listener>> listeners;
	private Map<String, List<Bind>> binds;
	private List<Bind> currentLevel;

	public InputController(){
		listeners = new HashMap<>();
		binds = new HashMap<>();
	}

	public void bindArea(Rectangle area, String layer, Object event, boolean isScroll) {
		if(!binds.containsKey(layer)){
			binds.put(layer, new ArrayList<Bind>());
		}
		binds.get(layer).add(new Bind(area, event));
	}

	public void setLayer(String layer){
		currentLevel = binds.get(layer);
	}

	public void addListener(Listener listener, List<Object> events) {
		for(Object e : events){
			if(listeners.get(e.getClass()) == null){
				listeners.put(e.getClass(), new ArrayList<Listener>());
			}
			listeners.get(e.getClass()).add(listener);
		}
	}

	public void sendEvent(Object event){
		for(Listener l : listeners.get(event.getClass())){
			l.sendEvent(event);
		}
	}

	private float mapX(float x){//TODO реализовать маппинг с другими размерами экранов (android)
		if (x <= (Float) GlobalProperties.getInstance().get("offset")) x = 0.0f; else
			if (x >= (Float) GlobalProperties.getInstance().get("offset") + (Float) GlobalProperties.getInstance().get("screen_width")*(Float) GlobalProperties.getInstance().get("k")) x = 1240.0f; else
				x = (x - ((Float) GlobalProperties.getInstance().get("offset")).intValue())/(Float) GlobalProperties.getInstance().get("k");
		return x;
	}

	private float mapY(float y){
		y = y / (Float) GlobalProperties.getInstance().get("k");
		return y;
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if(currentLevel == null){
			currentLevel = (List<Bind>) binds.values().toArray()[0];
		}
		Object event;
		for (Bind bind : currentLevel){
			event = bind.event(mapX(screenX), mapY(screenY));
			if(event != null){
				sendEvent(event);
			}
		}
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		return false;
	}

	private static class Bind{
		Rectangle rectangle;
		Object event;

		Bind(Rectangle rectangle, Object event) {
			this.rectangle = rectangle;
			this.event = event;
		}

		Object event(float x, float y){
			return rectangle.contains(x, y) ? event : null;
		}
	}
}
