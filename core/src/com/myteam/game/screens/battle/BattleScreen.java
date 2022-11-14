package com.myteam.game.screens.battle;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.myteam.game.SDGame;

import java.util.ArrayList;
import java.util.List;

public class BattleScreen implements Screen {

    private final SDGame game;

    private TextureAtlas atlas;
    private Background background;
    private SpriteBatch batch;
    private Viewport viewport;
    private OrthographicCamera camera;
    private boolean inTravel = true;
    private Music musicLoopBattleScreen;

    public BattleScreen(final SDGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        atlas = new TextureAtlas(Gdx.files.internal("atlas.atlas"));
        background = new Background("desert", atlas);
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);
        musicLoopBattleScreen = Gdx.audio.newMusic(Gdx.files.internal("MusicLoopBattleScreen.wav"));
        musicLoopBattleScreen.setLooping(true);
        musicLoopBattleScreen.play();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.render(batch, inTravel);
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
                themeOffset -= Gdx.graphics.getWidth() / 6 * Gdx.graphics.getDeltaTime();
                batch.draw(theme, themeOffset + 1240, 0);
            }
            if (themeOffset <= -1240) {
                themeOffset = 0;
            }
            batch.draw(ground, 0, 0);
        }
    }
}