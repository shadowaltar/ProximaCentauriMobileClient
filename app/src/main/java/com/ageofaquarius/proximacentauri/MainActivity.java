package com.ageofaquarius.proximacentauri;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ageofaquarius.proximacentauri.engine.OpenGLHelper;
import com.ageofaquarius.proximacentauri.engine.TerrainSurfaceView;

public class MainActivity extends AppCompatActivity {

    private TerrainSurfaceView surfaceView;
    private boolean rendererSet = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        surfaceView = new TerrainSurfaceView(this);
        if (OpenGLHelper.supportsOpenGlEs2(this)) {
            setContentView(surfaceView);
            rendererSet = true;
        } else {
            Toast.makeText(this, "This device doesn't support OpenGL ES 2.0.", Toast.LENGTH_LONG).show();
            return;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (rendererSet)
            surfaceView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (rendererSet)
            surfaceView.onResume();
    }
}
