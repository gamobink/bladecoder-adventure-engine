package org.bladecoder.engine.ui;

import org.bladecoder.engine.ui.UI.State;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MenuScreen implements Screen {

	public static final String BACK_COMMAND = "back";
	public static final String QUIT_COMMAND = "quit";
	public static final String RELOAD_COMMAND = "reload";
	public static final String HELP_COMMAND = "help";
	public static final String CREDITS_COMMAND = "credits";

	private static final float MARGIN = 15;

	UI ui;

	Stage stage;

	public MenuScreen(UI ui) {
		this.ui = ui;
	}

	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(delta);
		stage.draw();

		ui.getBatch().setProjectionMatrix(
				stage.getViewport().getCamera().combined);
		ui.getBatch().begin();
		ui.getPointer().draw(ui.getBatch(), stage.getViewport());
		ui.getBatch().end();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void dispose() {
		stage.dispose();
		stage = null;
	}

	@Override
	public void show() {
		stage = new Stage(new ScreenViewport());

		Table table = new Table();
		table.setFillParent(true);
		table.center();

		ImageButton back = new ImageButton(new TextureRegionDrawable(ui
				.getUIAtlas().findRegion(BACK_COMMAND)));
		back.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				ui.setScreen(State.SCENE_SCREEN);
			}
		});

		table.add(back).pad(MARGIN);

		ImageButton reload = new ImageButton(new TextureRegionDrawable(ui
				.getUIAtlas().findRegion(RELOAD_COMMAND)));
		reload.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				ui.setScreen(State.RESTART_SCREEN);
			}
		});

		table.add(reload).pad(MARGIN);

		ImageButton help = new ImageButton(new TextureRegionDrawable(ui
				.getUIAtlas().findRegion(HELP_COMMAND)));
		help.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				ui.setScreen(State.HELP_SCREEN);
			}
		});

		table.add(help).pad(MARGIN);

		ImageButton credits = new ImageButton(new TextureRegionDrawable(ui
				.getUIAtlas().findRegion(CREDITS_COMMAND)));
		credits.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				ui.setScreen(State.CREDIT_SCREEN);
			}
		});

		table.add(credits).pad(MARGIN);

		ImageButton quit = new ImageButton(new TextureRegionDrawable(ui
				.getUIAtlas().findRegion(QUIT_COMMAND)));
		quit.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			}
		});

		table.add(quit).pad(MARGIN);
		table.pack();

		stage.addActor(table);

		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
