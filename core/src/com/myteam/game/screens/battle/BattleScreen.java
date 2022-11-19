package com.myteam.game.screens.battle;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.myteam.game.SDGame;
import com.myteam.game.model.impl.EffectImpl;
import com.myteam.game.properties.GlobalProperties;
import com.myteam.game.utils.ScaledSpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class BattleScreen implements Screen {

    private final SDGame game;

    private TextureAtlas atlas;
    private Background background;
    private ScaledSpriteBatch batch;
    private Viewport viewport;
    private OrthographicCamera camera;
    private boolean inTravel = true;
    private Music musicLoopBattleScreen;
    private EffectImpl effect;
    float stateTime;
    private static float ratioSkalingCameraWidth;
    private static float ratioSkalingCameraHeight;
    TextureRegion currentFrame;

    public BattleScreen(final SDGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        atlas = (TextureAtlas) GlobalProperties.getInstance().get("atlas");
        effect = new EffectImpl("hesagsagsa",100, 170);
        background = new Background("desert", atlas);
        batch = new ScaledSpriteBatch();
        batch.setScalingCameraWidth((float) Gdx.graphics.getWidth() / 1240.0f);
        batch.setScalingCameraHeight((float) Gdx.graphics.getHeight() / 720.0f );
        camera = new OrthographicCamera();
        camera.setToOrtho(false,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        viewport = new FitViewport (Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);
        musicLoopBattleScreen = Gdx.audio.newMusic(Gdx.files.internal("MusicLoopBattleScreen.wav"));
        musicLoopBattleScreen.setLooping(true);
        musicLoopBattleScreen.play();
        stateTime = 0f;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        currentFrame = (TextureRegion) effect.getAnimation().getKeyFrame(stateTime, true);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stateTime+=Gdx.graphics.getDeltaTime();
        batch.begin();
        background.render(batch, inTravel);
        batch.draw(currentFrame, effect.getPosition().getX(), effect.getPosition().getY());
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        musicLoopBattleScreen.dispose();
        atlas.dispose();
    }
    private static class Background {
        float themeOffset;
        TextureRegion back;
        TextureRegion theme;
        TextureRegion ground;


        Background(String name, TextureAtlas atlas) {
            back = atlas.findRegion(name + "_back");
            theme = atlas.findRegion(name + "_theme");
            ground = atlas.findRegion(name + "_ground");
            themeOffset = 0;
        }
        
        void render(SpriteBatch batch, boolean inTravel) {
            batch.draw(back, 0, 0);
            if (!inTravel) {
                batch.draw(theme, themeOffset, 0);
            } else {
                batch.draw(theme, themeOffset, 0);
                if (themeOffset != 0 ){
                batch.draw(theme, themeOffset + theme.getRegionWidth(), 0);}
                themeOffset -= Gdx.graphics.getWidth() / 6 * Gdx.graphics.getDeltaTime();
            }
            if (themeOffset <= -theme.getRegionWidth()) {
                themeOffset = 0;
            }
            batch.draw(ground, 0, 0);
        }
    }
}