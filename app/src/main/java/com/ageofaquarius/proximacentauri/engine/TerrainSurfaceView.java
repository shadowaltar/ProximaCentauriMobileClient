package com.ageofaquarius.proximacentauri.engine;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by Mars on 2016-12-11.
 */

public class TerrainSurfaceView extends GLSurfaceView {

    private final TerrainRenderer renderer;

    public TerrainSurfaceView(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        renderer = new TerrainRenderer(context);
        setRenderer(renderer);
    }
}
