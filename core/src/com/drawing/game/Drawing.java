package com.drawing.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Drawing extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Handler handler;
	public float y;


	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		handler = new Handler();
		Gdx.input.setInputProcessor(handler);

	}

	@Override
	public void render () {
		tick();

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, y, 64, 64);
		batch.end();

	}

	public void tick(){

	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
