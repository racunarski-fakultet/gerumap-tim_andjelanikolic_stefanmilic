package dsw.gerumap.app.gui.swing.serializer;

import com.google.gson.*;
import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;

import java.lang.reflect.Type;

public class AbstractElementAdapter implements JsonSerializer<MapNode>, JsonDeserializer<MapNode> {
//    private static final String CLASS_META_KEY = "CLASS_META_KEY";

    @Override
    public JsonElement serialize(MapNode mapNode, Type type, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.add("name", new JsonPrimitive(mapNode.getClass().getSimpleName()));
        result.add("properties", context.serialize(mapNode, mapNode.getClass()));

        return result;
//        JsonElement jsonEle = context.serialize(mapNode, mapNode.getClass());
//        jsonEle.getAsJsonObject().addProperty(CLASS_META_KEY,
//                mapNode.getClass().getCanonicalName());
//        return jsonEle;
    }
    @Override
    public MapNode deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
//        JsonObject jsonObj = jsonElement.getAsJsonObject();
//        String className = jsonObj.get(CLASS_META_KEY).getAsString();
//        try {
//            Class<?> clz = Class.forName(className);
//            return context.deserialize(jsonElement, clz);
//        } catch (ClassNotFoundException e) {
//            throw new JsonParseException(e);
//        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String name = jsonObject.get("name").getAsString();
        JsonElement element = jsonObject.get("properties");

        try {
            return context.deserialize(element, Class.forName(name));
        } catch (ClassNotFoundException cnfe) {
            throw new JsonParseException("Unknown element type: " + name, cnfe);
        }
    }


}
