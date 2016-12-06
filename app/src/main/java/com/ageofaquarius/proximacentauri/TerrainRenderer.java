package com.ageofaquarius.proximacentauri;

import android.content.Context;
import android.opengl.GLSurfaceView;

import com.ageofaquarius.proximacentauri.engine.ShaderHelper;
import com.ageofaquarius.proximacentauri.engine.TextResourceReader;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import static android.opengl.GLES20.glGetAttribLocation;
import static android.opengl.GLES20.glGetUniformLocation;
import static android.opengl.GLES20.glUseProgram;
import static com.ageofaquarius.proximacentauri.misc.Utilities.FLOAT_BYTES;

/**
 * Created by Mars on 2016-12-04.
 */

public class TerrainRenderer implements GLSurfaceView.Renderer {

    private static final int POSITION_COMPONENT_COUNT = 3;
    private final FloatBuffer vertexData;
    private final Context context;
    private int program;

    private static final String U_COLOR = "u_Color";
    private int uColorLocation;
    private static final String A_POSITION = "a_Position";
    private int aPositionLocation;

    public TerrainRenderer(Context context) {
        this.context = context;
        float[] tileVertices = {
                0.0f, 0.0f, 0.0f, // center
                0.5f, 0.0f, 0.0f, // right
                0.25f, 0.433f, 0.0f, // top right
                -0.25f, 0.433f, 0.0f, // top left
                -0.5f, 0.0f, 0.0f, // left
                -0.25f, -0.433f, 0.0f, // bottom left
                0.25f, -0.433f, 0.0f  // bottom right
        };
        short drawOrder[] = {0, 1, 2, 2, 3, 0, 0, 3, 4, 4, 5, 0, 0, 5, 6, 6, 1, 0};
        vertexData = createBuffer(tileVertices);
    }

    public FloatBuffer createBuffer(float[] values) {
        FloatBuffer data = ByteBuffer.allocateDirect(values.length * FLOAT_BYTES)
                .order(ByteOrder.nativeOrder()).asFloatBuffer();
        data.put(values);
        return data;
    }

    public ShortBuffer createBuffer(short[] values) {
        ShortBuffer data = ByteBuffer.allocateDirect(values.length * FLOAT_BYTES)
                .order(ByteOrder.nativeOrder()).asShortBuffer();
        data.put(values);
        return data;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        String vertexShaderSource = TextResourceReader
                .readTextFileFromResource(context, R.raw.tile_vertex_shader);
        int vertexShader = ShaderHelper.compileVertexShader(vertexShaderSource);
        String fragmentShaderSource = TextResourceReader
                .readTextFileFromResource(context, R.raw.tile_fragment_shader);
        int fragmentShader = ShaderHelper.compileFragmentShader(fragmentShaderSource);
        program = ShaderHelper.linkProgram(vertexShader, fragmentShader);
        glUseProgram(program);

        uColorLocation = glGetUniformLocation(program, U_COLOR);
        aPositionLocation = glGetAttribLocation(program, A_POSITION);
    }



    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

    }

    @Override
    public void onDrawFrame(GL10 gl) {

    }
}
