package com.ageofaquarius.proximacentauri.engine;

import android.content.Context;
import android.opengl.GLES20;

import com.ageofaquarius.proximacentauri.R;

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import static com.ageofaquarius.proximacentauri.misc.Utilities.COORDINATE_DIMENSION;
import static com.ageofaquarius.proximacentauri.misc.Utilities.FLOAT_BYTES;

/**
 * Created by Mars on 2016-12-11.
 */

public class Hexagon {
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
            -0.25f, 0.433f, 0.0f, // top left
            -0.5f, 0.0f, 0.0f, // left
            -0.25f, -0.433f, 0.0f, // bottom left
            0.25f, -0.433f, 0.0f  // bottom right
    };

    public static short drawOrder[] = {0, 1, 2, 2, 3, 0, 0, 3, 4, 4, 5, 0, 0, 5, 6, 6, 1, 0};

    private float color[] = {0.63671875f, 0.76953125f, 0.22265625f, 1.0f};

    private static final int vertexStride = COORDINATE_DIMENSION * FLOAT_BYTES;

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
        // Add program to OpenGL ES environment
        GLES20.glUseProgram(program);

        programHandle = GLES20.glGetAttribLocation(program, "vPosition");

        GLES20.glEnableVertexAttribArray(programHandle);

        GLES20.glVertexAttribPointer(programHandle, COORDINATE_DIMENSION, GLES20.GL_FLOAT, false,
                vertexStride, vertexBuffer);

        // get handle to fragment shader's vColor member
        colorHandle = GLES20.glGetUniformLocation(program, "vColor");

        // Set color for drawing the triangle
        GLES20.glUniform4fv(colorHandle, 1, color, 0);
        mvpMatrixHandle = GLES20.glGetUniformLocation(program, "uMVPMatrix");

        GLES20.glUniformMatrix4fv(mvpMatrixHandle, 1, false, mvpMatrix, 0);

        // Draw the hex
        GLES20.glDrawElements(GLES20.GL_TRIANGLES, drawOrder.length, GLES20.GL_UNSIGNED_SHORT, drawListBuffer);

        GLES20.glDisableVertexAttribArray(programHandle);
    }
}
