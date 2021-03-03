package com.drawing.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class Drawing extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture dot;
	Handler handler;
	float dotX;
	float dotY;
	Random r = new Random();

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("Images/pacman.png");
		dot = new Texture("Images/yellowDot.png");

		dotX = r.nextFloat() * 1080;
		dotY = r.nextFloat() * 1920;
		handler = new Handler();
		Gdx.input.setInputProcessor(handler);

	}

	@Override
	public void render () {
		tick();

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, Handler.x, Handler.y, 64, 64);
		batch.draw(dot, dotX, dotY, 32, 32);
		batch.end();

	}

	public void tick(){
		Handler.x += Handler.speedX;
		Handler.y += Handler.speedY;
		if(Handler.x - 32 < dotX && dotX < Handler.x + 32 && Handler.y - 32 < dotY && dotY < Handler.y + 32){
			dotX = r.nextFloat() * 1080;
			dotY = r.nextFloat() * 1920;
		}
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
