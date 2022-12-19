package com.myteam.game.view.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.myteam.game.view.properties.GlobalProperties;

public class ScaledSpriteBatch extends SpriteBatch {
	private float scalingCameraWidth;
	private float scalingCameraHeight;

	public void draw(TextureRegion region, float x, float y) {
		draw(region, x, y, region.getRegionWidth() * scalingCameraWidth,
				region.getRegionHeight() * scalingCameraHeight);
	}

	public void draw(TextureRegion region, float x, float y, float width, float height) {
		super.draw(region, x, y, width * scalingCameraWidth,
				height * scalingCameraHeight);
	}

	public void drawBackground(TextureRegion region) {
		draw(region,
				(Gdx.graphics.getWidth()
						- ((float) GlobalProperties.getInstance().get("screen_width") * scalingCameraHeight)) / 2,
				0,
				(float) GlobalProperties.getInstance().get("screen_width") * scalingCameraHeight,
				(float) GlobalProperties.getInstance().get("screen_height") * scalingCameraHeight);
	}

	public void draw(TextureRegion region, float x, float y, float k) {
		draw(region, x, y, region.getRegionWidth() * scalingCameraWidth * k,
				region.getRegionHeight() * scalingCameraHeight * k);
	}

	public float getScalingCameraWidth() {
		return scalingCameraWidth;
	}

	public void setScalingCameraWidth(float scalingCameraWidth) {
		this.scalingCameraWidth = scalingCameraWidth;
	}

	public float getScalingCameraHeight() {
		return scalingCameraHeight;
	}

	public void setScalingCameraHeight(float scalingCameraHeight) {
		this.scalingCameraHeight = scalingCameraHeight;
	}
}
