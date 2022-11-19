package com.myteam.game.utils;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ScaledSpriteBatch extends SpriteBatch {
    private float scalingCameraWidth;
    private float scalingCameraHeight;

    public void draw (TextureRegion region, float x, float y) {
        draw(region, x, y, region.getRegionWidth() * scalingCameraWidth , region.getRegionHeight()*scalingCameraHeight);
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
