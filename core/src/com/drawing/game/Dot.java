package com.drawing.game;

import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class Dot {

    public float x;
    public float y;


    public Dot(float X, float Y){
        Random r = new Random();
        x = X;
        y = Y;
    }

    public void randomize(){
        Random r = new Random();
        x = r.nextFloat() * 1080;
        y = r.nextFloat() * 1920;
    }


}
