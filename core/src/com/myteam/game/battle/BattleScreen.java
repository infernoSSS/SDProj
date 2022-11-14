package com.myteam.game.battle;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.myteam.game.Space_and_Dice;

public class BattleScreen implements Screen {

    final Space_and_Dice game;

    TextureAtlas atlas;
    TextureRegion regionBackground;
    TextureRegion regionGround;
    TextureRegion regionSquare;
    SpriteBatch batch;
    private Viewport viewport;
    OrthographicCamera camera;
    boolean inTravel = true;
    Music MusicLoopBattleScreen;
    float speedInTravel = 0;

    public BattleScreen(final Space_and_Dice gam) {
        game = gam;

    }

    @Override
    public void show() {
        atlas = new TextureAtlas(Gdx.files.internal("atlas.atlas"));
        regionBackground = atlas.findRegion("Background");
        regionGround = atlas.findRegion("Ground");
        regionSquare = atlas.findRegion("Square");
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1240, 720);
        viewport = new FitViewport(1240, 720, camera);
        MusicLoopBattleScreen = Gdx.audio.newMusic(Gdx.files.internal("MusicLoopBattleScreen.wav"));
        MusicLoopBattleScreen.play();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(regionBackground,0, 0);
        if (!inTravel){
            batch.draw(regionGround,0, 0);
        }else{
            batch.draw(regionGround,speedInTravel, 0);
            speedInTravel -= 5;
            batch.draw(regionGround,speedInTravel+1240, 0);
        }
        if (speedInTravel == -1240){
            speedInTravel = 0;
        }
        batch.draw(regionSquare,0, 0);
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

    }
}