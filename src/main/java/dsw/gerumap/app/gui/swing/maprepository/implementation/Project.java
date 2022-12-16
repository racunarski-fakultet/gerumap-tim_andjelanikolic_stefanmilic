package dsw.gerumap.app.gui.swing.maprepository.implementation;

import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
import dsw.gerumap.app.gui.swing.maprepository.composite.MapNodeComposite;
import dsw.gerumap.app.observer.Subscriber;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;

@Getter
public class Project extends MapNodeComposite {

    String author;

    public Project(String name, MapNode parent) {
        super(name, parent);
    }

    public Project(String name, MapNode parent, String author) {
        super(name, parent);
        this.author = author;
    }

    @Override
    public void addChild(MapNode child) throws IOException {
        if (child instanceof MindMap) {
            MindMap mindMap = (MindMap) child;
            this.getChildren().add(mindMap);
            notify(this);
        }
    }

    @Override
    public void removeChild(MapNode child) throws IOException {
        if (child instanceof MindMap) {
            MindMap mindMap = (MindMap) child;
            this.getChildren().remove(mindMap);
            notify(this);
        }
    }

    public void setAuthor(String author) throws IOException {
        this.author = author;
    }
}
