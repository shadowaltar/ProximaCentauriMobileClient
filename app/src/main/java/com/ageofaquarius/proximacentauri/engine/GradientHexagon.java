package com.ageofaquarius.proximacentauri.engine;

import android.content.Context;
import android.opengl.GLES20;

import com.ageofaquarius.proximacentauri.R;

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import static com.ageofaquarius.proximacentauri.misc.Utilities.COLOR_DIMENSION;
import static com.ageofaquarius.proximacentauri.misc.Utilities.COORDINATE_DIMENSION;
import static com.ageofaquarius.proximacentauri.misc.Utilities.FLOAT_BYTES;
import static com.ageofaquarius.proximacentauri.misc.Utilities.VERTEX_STRIDE;

/**
 * Created by Mars on 2016-12-11.
 */

public class GradientHexagon {
    private FloatBuffer vertexBuffer;
    private ShortBuffer drawListBuffer;
    private int program;
    private int positionHandle;
    private int colorHandle;
    private int mvpMatrixHandle;

    public static float[] vertices = {
            0.0f, 0.0f, 0.0f, 0.7f, 0.7f, 1f, // center
            0.5f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f,// right
            0.25f, 0.433f, 0.0f, 0.5f, 0.5f, 0.5f,// top right
            -0.25f, 0.433f, 0.0f, 0.5f, 0.5f, 0.5f,// top left
            -0.5f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f,// left
            -0.25f, -0.433f, 0.0f, 0.5f, 0.5f, 0.5f,// bottom left
            0.25f, -0.433f, 0.0f, 0.5f, 0.5f, 0.5f,// bottom right
    };

    private static final int STRIDE = (COORDINATE_DIMENSION + COLOR_DIMENSION) * FLOAT_BYTES;

    public static short drawOrder[] = {0, 1, 2, 3, 4, 5, 6, 1};

//    private float color[] = {0.2f, 0.5f, 0.9f, 1.0f};

    public GradientHexagon(Context context) {
        vertexBuffer = OpenGLHelper.createBuffer(vertices);
        drawListBuffer = OpenGLHelper.createBuffer(drawOrder);
        setupProgram(context);
    }

    private void setupProgram(Context context) {
        int vertexShader = OpenGLHelper.loadShader(GLES20.GL_VERTEX_SHADER, TextResourceReader
                .readTextFileFromResource(context, R.raw.tile_gradient_vertex_shader));
        int fragmentShader = OpenGLHelper.loadShader(GLES20.GL_FRAGMENT_SHADER, TextResourceReader
                .readTextFileFromResource(context, R.raw.tile_gradient_fragment_shader));
        program = OpenGLHelper.createProgram(vertexShader, fragmentShader);
    }

    public void draw(float[] mvpMatrix) {
        GLES20.glUseProgram(program);

        mvpMatrixHandle = OpenGLHelper.setViewportMatrix(program, mvpMatrix);


        positionHandle = GLES20.glGetAttribLocation(program, "position");
        vertexBuffer.position(0);
        GLES20.glVertexAttribPointer(positionHandle, COORDINATE_DIMENSION, GLES20.GL_FLOAT, false, STRIDE, vertexBuffer);
        GLES20.glEnableVertexAttribArray(positionHandle);

        colorHandle = GLES20.glGetAttribLocation(program, "color");
        vertexBuffer.position(COORDINATE_DIMENSION);
        GLES20.glVertexAttribPointer(colorHandle, COLOR_DIMENSION, GLES20.GL_FLOAT, false, STRIDE, vertexBuffer);
        GLES20.glEnableVertexAttribArray(colorHandle);


        GLES20.glDrawElements(GLES20.GL_TRIANGLE_FAN, drawOrder.length, GLES20.GL_UNSIGNED_SHORT, drawListBuffer);


        OpenGLHelper.stopProgram(positionHandle);
    }
}
