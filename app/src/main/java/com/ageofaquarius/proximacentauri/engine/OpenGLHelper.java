package com.ageofaquarius.proximacentauri.engine;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLES20;
import android.os.Build;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import static com.ageofaquarius.proximacentauri.util.Utilities.COORDINATE_DIMENSION;
import static com.ageofaquarius.proximacentauri.util.Utilities.FLOAT_BYTES;
import static com.ageofaquarius.proximacentauri.util.Utilities.VERTEX_STRIDE;

/**
 * Created by Mars on 2016-12-11.
 */

public class OpenGLHelper {

    public static boolean supportsOpenGlEs2(Context context) {
        final ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        final boolean supportsEs2 = configurationInfo.reqGlEsVersion >= 0x20000
                || (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1 &&
                (Build.FINGERPRINT.startsWith("generic")
                        || Build.FINGERPRINT.startsWith("unknown")
                        || Build.MODEL.contains("google_sdk")
                        || Build.MODEL.contains("Emulator")
                        || Build.MODEL.contains("Android SDK built for x86")));
        return supportsEs2;
    }

    public static int createProgram(int vertexShader, int fragmentShader) {
        int program = GLES20.glCreateProgram();             // create empty OpenGL ES Program
        GLES20.glAttachShader(program, vertexShader);   // add the vertex shader to program
        GLES20.glAttachShader(program, fragmentShader); // add the fragment shader to program
        GLES20.glLinkProgram(program);                  // creates OpenGL ES program executables
        return program;
    }

    public static int loadShader(int type, String shaderCode) {
        // create a vertex shader type (GLES20.GL_VERTEX_SHADER)
        // or a fragment shader type (GLES20.GL_FRAGMENT_SHADER)
        int shader = GLES20.glCreateShader(type);

        // add the source code to the shader and compile it
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);

        return shader;
    }

    public static FloatBuffer createBuffer(float[] values) {
        FloatBuffer data = ByteBuffer.allocateDirect(values.length * FLOAT_BYTES)
                .order(ByteOrder.nativeOrder()).asFloatBuffer();
        data.put(values);
        data.position(0);
        return data;
    }

    public static ShortBuffer createBuffer(short[] values) {
        ShortBuffer data = ByteBuffer.allocateDirect(values.length * FLOAT_BYTES)
                .order(ByteOrder.nativeOrder()).asShortBuffer();
        data.put(values);
        data.position(0);
        return data;
    }

    public static void drawTriangle() {

    }

    public static int startProgram(int program) {
        // Add program to OpenGL ES environment
        GLES20.glUseProgram(program);
        int positionHandle = GLES20.glGetAttribLocation(program, "vPosition");
        GLES20.glEnableVertexAttribArray(positionHandle);
        return positionHandle;
    }

    public static int setColor(int program, float[] color) {
        int colorHandle = GLES20.glGetUniformLocation(program, "vColor");
        GLES20.glUniform4fv(colorHandle, 1, color, 0);
        return colorHandle;
    }

    public static int setViewportMatrix(int program, float[] mvpMatrix) {
        int mvpMatrixHandle = GLES20.glGetUniformLocation(program, "uMVPMatrix");
        GLES20.glUniformMatrix4fv(mvpMatrixHandle, 1, false, mvpMatrix, 0);
        return mvpMatrixHandle;
    }

    public static void setVertexes(int programHandle, FloatBuffer vertexBuffer) {
        GLES20.glVertexAttribPointer(programHandle, COORDINATE_DIMENSION, GLES20.GL_FLOAT, false, VERTEX_STRIDE, vertexBuffer);
    }

    public static void draw(int programHandle, FloatBuffer vertexBuffer, int drawVertexCount, ShortBuffer drawListBuffer) {
        setVertexes(programHandle, vertexBuffer);
        GLES20.glDrawElements(GLES20.GL_TRIANGLE_FAN, drawVertexCount, GLES20.GL_UNSIGNED_SHORT, drawListBuffer);
    }

    public static void stopProgram(int programHandle) {
        GLES20.glDisableVertexAttribArray(programHandle);
    }
}
