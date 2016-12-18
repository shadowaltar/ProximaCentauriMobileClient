package com.ageofaquarius.proximacentauri.engine;

import android.content.Context;
import android.opengl.GLES20;

import com.ageofaquarius.proximacentauri.R;

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/**
 * Created by Mars on 2016-12-11.
 */

public class Triangle {
    private FloatBuffer vertexBuffer;
    private ShortBuffer drawListBuffer;
    private int program;
    private int programHandle;
    private int colorHandle;
    private int mvpMatrixHandle;

    public static float[] vertices = {
            0.0f, 0.0f, 0.0f, // center
            0.5f, 0.0f, 0.0f, // right
            0.25f, 0.433f, 0.0f, // top right
    };

    public static short drawOrder[] = {0, 1, 2};

    private float color[] = {0.1f, 0.4f, 0.2f, 1.0f};

    public Triangle(Context context) {
        vertexBuffer = OpenGLHelper.createBuffer(vertices);
        drawListBuffer = OpenGLHelper.createBuffer(drawOrder);
        setupProgram(context);
    }

    private void setupProgram(Context context) {
        int vertexShader = OpenGLHelper.loadShader(GLES20.GL_VERTEX_SHADER, TextResourceReader
                .readTextFileFromResource(context, R.raw.tile_vertex_shader));
        int fragmentShader = OpenGLHelper.loadShader(GLES20.GL_FRAGMENT_SHADER, TextResourceReader
                .readTextFileFromResource(context, R.raw.tile_fragment_shader));
        program = OpenGLHelper.createProgram(vertexShader, fragmentShader);
    }

    public void draw(float[] mvpMatrix) {
        programHandle = OpenGLHelper.startProgram(program);
        colorHandle = OpenGLHelper.setColor(program, color);
        mvpMatrixHandle = OpenGLHelper.setViewportMatrix(program, mvpMatrix);

        OpenGLHelper.draw(programHandle, vertexBuffer, drawOrder.length, drawListBuffer);

//        GLES20.glUniform4f(colorHandle, 1.0f, 1.0f, 0.0f, 1.0f);
//        GLES20.glDrawArrays(GLES20.GL_LINES, 6, 2);
        OpenGLHelper.stopProgram(programHandle);
    }
}
