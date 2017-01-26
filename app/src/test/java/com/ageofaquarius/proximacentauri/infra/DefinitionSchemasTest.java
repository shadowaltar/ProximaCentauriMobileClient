package com.ageofaquarius.proximacentauri.infra;

import android.content.Context;
import android.content.res.Resources;

import com.ageofaquarius.proximacentauri.R;
import com.ageofaquarius.proximacentauri.system.ServiceProvider;

import org.junit.*;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.powermock.api.easymock.PowerMock.mockStatic;
import static org.easymock.EasyMock.*;
import static org.powermock.api.easymock.PowerMock.mockStaticPartial;
import static org.powermock.api.easymock.PowerMock.replayAll;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Mars on 2017-01-08.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ServiceProvider.class)
public class DefinitionSchemasTest {
    private ServiceProvider mockServiceProvider;
    private Context mockContext;
    private Resources mockResources;
    @Before
    public void setUp() {
        mockServiceProvider = mock(ServiceProvider.class);
        mockContext = mock(Context.class);
        mockStaticPartial(ServiceProvider.class, "getInstance");
        expect(ServiceProvider.getInstance()).andReturn(mockServiceProvider);
        expect(mockServiceProvider.getAppContext()).andReturn(mockContext);
    }
    @Test
    public void initialize() throws Exception {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("def_definition_schema.csv");

        mockResources = mock(Resources.class);
        expect(mockContext.getResources()).andReturn(mockResources);
        expect(mockResources.openRawResource(R.raw.def_definition_schema)).andReturn(in);
        replayAll();

//        InputStreamReader inputStreamReader = new InputStreamReader(in);
//        StringBuilder result = new StringBuilder();
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//        String nextLine;
//        while ((nextLine = bufferedReader.readLine()) != null) {
//            result.append(nextLine);
//        }
        ServiceProvider instance2 = ServiceProvider.getInstance();
        final DefinitionSchemas instance = DefinitionSchemas.getInstance();
        instance.initialize();
//        HashMap<String, DefinitionSchema> schemas = instance.parseSchemas(result.toString());
//        for(Map.Entry<String, DefinitionSchema> entry : schemas.entrySet()){
//            assertTrue(entry.getKey() == entry.getValue().getName());
//        }
    }
}