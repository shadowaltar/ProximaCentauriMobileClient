package com.ageofaquarius.proximacentauri.infra;

import com.ageofaquarius.proximacentauri.R;
import com.ageofaquarius.proximacentauri.ServiceLocator;
import com.ageofaquarius.proximacentauri.gaming.entity.ResourceType;
import com.ageofaquarius.proximacentauri.util.FileAccess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mars on 2016-12-25.
 */

public class DefinitionSchemas {

    private static DefinitionSchemas instance;

    private ArrayList<Class> classes = new ArrayList<>();
    private ArrayList<String> classNames = new ArrayList<>();
    private HashMap<String, Class> classNameToClasses = new HashMap<>();
    private HashMap<Class, String> classToClassNames = new HashMap<>();
    private HashMap<String, Integer> resourceKeys = new HashMap<>();

    private HashMap<String, HashMap<String, String[]>> definitionSchemas = new HashMap<>();

    private DefinitionSchemas() {
    }

    static {
        instance = new DefinitionSchemas();
    }

    public static DefinitionSchemas getInstance() {
        return instance;
    }

    public void initialize() {
        classNameToClasses.put("ResourceType", ResourceType.class);
        resourceKeys.put("ResourceType", R.raw.def_resources);

        for (Map.Entry<String, Class> entry : classNameToClasses.entrySet()) {
            ArrayList<String[]> rawSchemas = FileAccess.readTextFileAsArray(ServiceLocator.getAppContext(), R.raw.def_definition_schema);
            parseRawSchemas(rawSchemas);
            classNames.add(entry.getKey());
            classes.add(entry.getValue());
            classToClassNames.put(entry.getValue(), entry.getKey());
        }
    }

    private void parseRawSchemas(ArrayList<String[]> rawSchemas) {
        for (int i = 0; i < rawSchemas.size(); i++) {
            String[] row = rawSchemas.get(i);
            String className = row[0];
            String subject = row[1];

            if (!definitionSchemas.containsKey(className)) {
                HashMap<String, String[]> def = new HashMap<>();
                definitionSchemas.put(className, def);
            }

            HashMap<String, String[]> def = definitionSchemas.get(className);
            def.put(subject, Arrays.copyOfRange(row, 2, row.length));
            definitionSchemas.put(className, def);
        }
    }

    public int getResourceKey(String className) {
        return resourceKeys.get(className);
    }

    public Class getClass(String className) {
        return classNameToClasses.get(className);
    }

    public HashMap<String, String[]> getSchema(String className) throws DefinitionSchemaException {
        return definitionSchemas.get(className);
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public ArrayList<String> getClassNames() {
        return classNames;
    }
}
