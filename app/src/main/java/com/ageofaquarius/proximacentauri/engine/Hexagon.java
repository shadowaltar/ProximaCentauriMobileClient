package com.ageofaquarius.proximacentauri.engine;

import android.content.Context;
import android.opengl.GLES20;

import com.ageofaquarius.proximacentauri.R;

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import static com.ageofaquarius.proximacentauri.util.Utilities.COORDINATE_DIMENSION;
import static com.ageofaquarius.proximacentauri.util.Utilities.VERTEX_STRIDE;

/**
 * Created by Mars on 2016-12-11.
 */

public class Hexagon {
    private FloatBuffer vertexBuffer;
    private ShortBuffer drawListBuffer;
    private int program;
    private int positionHandle;
    private int colorHandle;
    private int mvpMatrixHandle;

    public static float[] vertices = {
            0.0f, 0.0f, 0.0f, // center
            0.5f, 0.0f, 0.0f, // right
            0.25f, 0.433f, 0.0f, // top right
            -0.25f, 0.433f, 0.0f, // top left
            -0.5f, 0.0f, 0.0f, // left
            -0.25f, -0.433f, 0.0f, // bottom left
            0.25f, -0.433f, 0.0f,  // bottom right
    };

//    public static short drawOrder[] = {0, 1, 2, 0, 2, 3, 0, 3, 4, 0, 4, 5, 0, 5, 6, 0, 6, 1};
    public static short drawOrder[] = {0, 1, 2, 3, 4, 5, 6, 1};

    private float color[] = {0.9f, 0.7f, 0.2f, 1f};

    public Hexagon(Context context) {
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
        GLES20.glUseProgram(program);

        mvpMatrixHandle = OpenGLHelper.setViewportMatrix(program, mvpMatrix);

        positionHandle = GLES20.glGetAttribLocation(program, "position");
        vertexBuffer.position(0);
        GLES20.glVertexAttribPointer(positionHandle, COORDINATE_DIMENSION, GLES20.GL_FLOAT, false, VERTEX_STRIDE, vertexBuffer);
        GLES20.glEnableVertexAttribArray(positionHandle);

        colorHandle = GLES20.glGetUniformLocation(program, "uniformColor");
        GLES20.glUniform4fv(colorHandle, 1, color, 0);

        GLES20.glDrawElements(GLES20.GL_TRIANGLE_FAN, drawOrder.length, GLES20.GL_UNSIGNED_SHORT, drawListBuffer);

//        GLES20.glUniform4f(colorHandle, 1.0f, 1.0f, 0.0f, 1.0f);
//        GLES20.glDrawArrays(GLES20.GL_LINES, 0, 2);
//        GLES20.glDrawArrays(GLES20.GL_TRIANGLE_FAN, 0, 7);
        OpenGLHelper.stopProgram(positionHandle);
    }
}
