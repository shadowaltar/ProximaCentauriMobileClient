package com.ageofaquarius.proximacentauri.engine;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLES20;
import android.os.Build;

import com.ageofaquarius.proximacentauri.R;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import static com.ageofaquarius.proximacentauri.misc.Utilities.FLOAT_BYTES;

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
}
