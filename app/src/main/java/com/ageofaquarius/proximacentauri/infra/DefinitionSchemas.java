package com.ageofaquarius.proximacentauri.infra;

import com.ageofaquarius.proximacentauri.R;
import com.ageofaquarius.proximacentauri.gaming.entity.ResourceType;
import com.ageofaquarius.proximacentauri.gaming.entity.capabilities.Capability;
import com.ageofaquarius.proximacentauri.gaming.faction.Faction;
import com.ageofaquarius.proximacentauri.system.ServiceProvider;
import com.ageofaquarius.proximacentauri.util.FileAccess;
import com.google.gson.JsonArray;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Mars on 2016-12-25.
 */

public class DefinitionSchemas {

    private static DefinitionSchemas instance;

    private ArrayList<Class> classes = new ArrayList<>();
    private ArrayList<String> classNames = new ArrayList<>();
    private HashMap<String, Class> defaultClasses = new HashMap<>();
    private HashMap<String, Integer> resourceKeys = new HashMap<>();
    private HashMap<String, Field> definitionFields = new HashMap<>();

    private HashMap<Class, String> classToClassNames = new HashMap<>();

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
        addOneCategory("ResourceType", ResourceType.class, R.raw.def_resources, "resourceTypes");
        addOneCategory("Capability", Capability.class, R.raw.def_object_capabilities, "capabilities");
        addOneCategory("Faction", Faction.class, R.raw.def_factions, "factions");


        for (Map.Entry<String, Class> entry : defaultClasses.entrySet()) {
            String rawSchemas = FileAccess.readAsString(ServiceProvider.getInstance().getAppContext(), R.raw.def_definition_schema);
            parseSchemas(rawSchemas);
            classNames.add(entry.getKey());
            classes.add(entry.getValue());
            classToClassNames.put(entry.getValue(), entry.getKey());
        }
    }

    private void addOneCategory(String name, Class defaultClass, int definitionFileKey,
                                String definitionFieldName) {
        defaultClasses.put(name, defaultClass);
        resourceKeys.put(name, definitionFileKey);

        try {
            Field f = Definitions.class.getDeclaredField(definitionFieldName);
            f.setAccessible(true);
            definitionFields.put(name, f);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, DefinitionSchema> parseSchemas(String rawSchemas) {
        HashMap<String, DefinitionSchema> schemas = new HashMap<>();
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = (JsonObject) jsonParser.parse(rawSchemas);
            JsonArray schemaJsons = jsonObject.getAsJsonArray("SCHEMAS");
            int count = schemaJsons.size();
            for (int i = 0; i < count; i++) {
                DefinitionSchema schema = new DefinitionSchema();
                JsonObject schemaJson = (JsonObject) schemaJsons.get(i);
                String type = schemaJson.get("TYPE").getAsString();
                schema.setName(type);
                schema.setGlobal(schemaJson.get("GLOBAL").getAsBoolean());
                schema.setPredefined(schemaJson.get("PREDEFINED").getAsBoolean());

                JsonArray columnJsons = schemaJson.getAsJsonArray("COLUMNS");
                for (int j = 0; j < columnJsons.size(); j++) {
                    Object object = columnJsons.get(j);
                    if (object instanceof JsonNull)
                        continue;
                    JsonObject columnJson = (JsonObject) object;
                    DefinitionColumn column = new DefinitionColumn();
                    column.setHeader(columnJson.get("header").getAsString());
                    column.setType(columnJson.get("type").getAsString());
                    column.setFieldName(columnJson.get("fieldName").getAsString());
                    schema.getColumns().put(column.getHeader(), column);
                }
                schemas.put(type,schema);
            }
//        for (int i = 0; i < rawSchemas.size(); i++) {
//            String[] row = rawSchemas.get(i);
//            String className = row[0];
//            String subject = row[1];
//
//            if (!definitionSchemas.containsKey(className)) {
//                HashMap<String, String[]> def = new HashMap<>();
//                definitionSchemas.put(className, def);
//            }
//
//            HashMap<String, String[]> def = definitionSchemas.get(className);
//            def.put(subject, Arrays.copyOfRange(row, 2, row.length));
//            definitionSchemas.put(className, def);
//        }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return schemas;
    }

    public int getResourceKey(String className) {
        return resourceKeys.get(className);
    }

    public Class getClass(String className) {
        return defaultClasses.get(className);
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
