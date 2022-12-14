package com.myteam.game.view.screens.battle;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.myteam.game.SDGame;
import com.myteam.game.view.units.impl.EffectImpl;
import com.myteam.game.view.properties.GlobalProperties;
import com.myteam.game.view.utils.InputController;
import com.myteam.game.view.utils.Listener;
import com.myteam.game.view.utils.Position;
import com.myteam.game.view.utils.ScaledSpriteBatch;

public class BattleScreen implements Screen {

    private final SDGame game;

    private TextureAtlas atlas;
    private Background background;
    private ScaledSpriteBatch batch;
    private Viewport viewport;
    private OrthographicCamera camera;
    private boolean inTravel = true;
    private Music musicLoopBattleScreen;
//    private EffectImpl effect;
    private BattleScreenInstance instance;
    private InputController inputListener;
    private float stateTime;
    private TextureRegion currentFrame;
    private int battleId;

    public BattleScreen(final SDGame game, int battleId) {
        this.game = game;
        this.battleId = battleId;
        atlas = (TextureAtlas) GlobalProperties.getInstance().get("atlas");
        inputListener = new InputController();
        this.instance = new BattleScreenInstance(battleId, atlas, inputListener);
    }

    @Override
    public void show() {
        batch = new ScaledSpriteBatch();
        batch.setScalingCameraWidth((float) Gdx.graphics.getWidth() / (float)GlobalProperties.getInstance().get("screen_width"));
        batch.setScalingCameraHeight((float) Gdx.graphics.getHeight() / (float)GlobalProperties.getInstance().get("screen_height") );
        camera = new OrthographicCamera();
        camera.setToOrtho(false,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        viewport = new FitViewport (Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);
        background = new Background(instance.getBackgroundName(), atlas);
        musicLoopBattleScreen = Gdx.audio.newMusic(Gdx.files.internal(instance.getMusicName()));
        musicLoopBattleScreen.setLooping(true);
        musicLoopBattleScreen.play();
        stateTime = 0f;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
//        currentFrame = (TextureRegion) effect.getAnimation().getKeyFrame(stateTime, true);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stateTime+=Gdx.graphics.getDeltaTime();
        batch.begin();
        background.render(batch, inTravel);
//        batch.draw(currentFrame, effect.getPosition().getX(), effect.getPosition().getY());
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

    public static class DeckTable implements Listener {
        private BattleScreenInstance instance;
        private Position position;

        public DeckTable(BattleScreenInstance instance) {
            this.instance = instance;
            this.position = new Position(0,0, false);
        }

        @Override
        public void sendEvent(Object event) {

        }

        public void draw(SpriteBatch batch){

        }
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