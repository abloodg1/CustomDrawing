package com.drawing.game;


import com.badlogic.gdx.InputProcessor;

public class Handler implements InputProcessor {

    public static float speed = 7;
    public static float speedX = speed;
    public static float speedY = 0;
    public static float x = 400;
    public static float y = 400;

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(speedX == speed){
            speedY = speed * -1;
            speedX = 0;
        }else if(speedY == speed * -1){
            speedY = 0;
            speedX = speed * -1;
        }else if(speedX == speed * -1){
            speedY = speed;
            speedX = 0;
        }else if(speedY == speed){
            speedY = 0;
            speedX = speed;
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
