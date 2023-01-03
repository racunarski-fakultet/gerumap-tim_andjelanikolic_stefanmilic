package dsw.gerumap.app.gui.swing.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dsw.gerumap.app.core.Serializer;
import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
import dsw.gerumap.app.gui.swing.maprepository.implementation.MindMap;
import dsw.gerumap.app.gui.swing.maprepository.implementation.Project;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class GsonSerializer implements Serializer {

    private Gson gson = new Gson();

    @Override
    public void saveProject(Project project) {
        GsonBuilder gsonBilder = new GsonBuilder();
        gsonBilder.registerTypeAdapter(MapNode.class, new AbstractElementAdapter());
        gson = gsonBilder.create();
        try (FileWriter writer = new FileWriter(project.getFilePath())) {
            gson.toJson(project, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Project loadProject(File file) {
        GsonBuilder gsonBilder = new GsonBuilder();
        gsonBilder.registerTypeAdapter(MapNode.class, new AbstractElementAdapter());
        gson = gsonBilder.create();
//        Type fooType = new TypeToken<List<MapNode>>() {}.getType();
        try (FileReader fileReader = new FileReader(file)) {
            MapNode m = gson.fromJson(fileReader, MapNode.class);
            return (Project) m;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


//    @Override
//    public void saveProject(Project project) {
//        try (FileWriter writer = new FileWriter(project.getFilePath())) {
//            gson.toJson(project, writer);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
