package com.ageofaquarius.proximacentauri;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import static com.ageofaquarius.proximacentauri.misc.Utilities.FLOAT_BYTES;

/**
 * Created by Mars on 2016-12-04.
 */

public class TerrainRenderer {

    private static final int POSITION_COMPONENT_COUNT = 3;
    private final FloatBuffer vertexData;

    public TerrainRenderer() {
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
}
