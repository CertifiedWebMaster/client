package com.jukusoft.mmo.engine.utils;

import com.badlogic.gdx.Gdx;

/**
 * Created by Justin on 06.02.2017.
 */
public class GameTime {

    protected volatile long time = 0;
    protected volatile float delta = 0;

    protected final long appStartUpTime;

    protected static GameTime instance = null;

    protected GameTime() {
        // set time, when game was started
        this.appStartUpTime = System.currentTimeMillis();
    }

    public void update() {
        this.update(true);
    }

    protected void update(boolean updateDelta) {
        //TODO: add offset, sync time with server

        this.time = System.currentTimeMillis();

        if (updateDelta && Gdx.graphics != null) {
            this.delta = Gdx.graphics.getDeltaTime();
        }
    }

    public long getTime() {
        return this.time;
    }

    public float getDeltaTime() {
        return this.delta;
    }

    public long getStartUpTime() {
        return this.appStartUpTime;
    }

    public static GameTime getInstance() {
        if (instance == null) {
            instance = new GameTime();
        }

        return instance;
    }

}
