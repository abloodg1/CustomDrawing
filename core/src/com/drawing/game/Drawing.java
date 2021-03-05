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
	Texture dotTex;
	Handler handler;
	float dotX;
	float dotY;
	Random r = new Random();
	Dot dots[] = new Dot [5];

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("Images/pacman.png");
		dotTex = new Texture("Images/yellowDot.png");
		for(int i = 0; i < dots.length; i++){
			dotX = r.nextFloat() * 1080;
			dotY = r.nextFloat() * 1920;
			dots[i] = new Dot(dotX, dotY);
		}
		handler = new Handler();
		Gdx.input.setInputProcessor(handler);

	}

	@Override
	public void render () {
		tick();

		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, Handler.x, Handler.y, 64, 64);
		for(int i = 0; i < dots.length; i++){
			batch.draw(dotTex, dots[i].x, dots[i].y, 32, 32);
		}
		batch.end();

	}

	public void tick(){
		Handler.x += Handler.speedX;
		Handler.y += Handler.speedY;
		for(int i = 0; i < dots.length; i++) {
			if (Handler.x - 40 < dots[i].x && dots[i].x < Handler.x + 40 && Handler.y - 40 < dots[i].y
					&& dots[i].y < Handler.y + 40) {
				dots[i].randomize();
			}
		}
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
